package navigation.egd.haw.egd_navigation_cj2.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.Nullable;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import navigation.egd.haw.egd_navigation_cj2.Interfaces.IXMLParser;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModule;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModuleProviders;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModulesList;

/**
 * @author prannoy
 * This Class is responsible to read the parse the xml file using(simpleXML library) from the asset file and returns the
 * hash map which can be used by the Dagger modules for initalization of a Object using the config file
 *
 * Example config xml:
 * <modules>
 *     <moduleList>
 *         <module name="NavigationMainActivityModule">
 *              <methodList>
 *                  <methodProvider packageName="navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger" methodName="iNavigationManager"/>
 *                  <methodProvider packageName="name1.1"  methodName="dd"/>
 *              </methodList>
 *           </module>
 *     </moduleList>
 *
 * </modules>
 *
 * Example of the Hasmap returned:
 * map.get(NavigationMainActivityModule).get(iNavigationManager) will return the methodProviderObject
 *
 * Created by prann on 11/11/2017.
 */

public class XMLParserUtil implements IXMLParser{
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser myparser;

    public XMLParserUtil() {
        try {
            this.xmlFactoryObject = XmlPullParserFactory.newInstance();
            this.myparser = xmlFactoryObject.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method is responsible for parsing the config xml file in the asset folder
     * @param context
     * @return
     */
    public Map<String, Map<String, DaggerModuleProviders>> parseXml(Context context){
        Serializer serializer = new Persister();
        try {
            //getting the context so that the asset folder is accessable
            AssetManager am = context.getAssets();
            //TODO: Change the name of the config file
            InputStream inputStream = am.open("test.xml");
            DaggerModulesList modules = serializer.read(DaggerModulesList.class, inputStream);
            return listToMap(modules);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method takes a list of Daggermoduleslist and creates a hashmap of the nested list contained in the object
     * so that it is easily accessible.
     *
     * NOTE: This is a workaround to simpleXML method to parse using a hashmap because the deserialization can be done using
     * custom classes but decided with this workaround because it is an overkill to wirte an own deserailizer for this task.
     *
     * The example for writing a custom deserializer using simplexml is below:
     * http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php#converters
     * @param list
     * @return
     */
    @Nullable
    private Map<String, Map<String, DaggerModuleProviders>> listToMap(DaggerModulesList list) {
        Map<String, Map<String, DaggerModuleProviders>> newList = new HashMap<>();

        List<DaggerModule> test = list.getModuleList();
        for(DaggerModule item : test) {
           String moduleName = item.getModuleName();
           List<DaggerModuleProviders> providers = item.getMethodList();
           Map<String, DaggerModuleProviders> temp = new HashMap<>();

           for(DaggerModuleProviders provider: providers) {
               String key = provider.getMethodName();
               temp.put(key, provider);
           }
           newList.put(moduleName, temp);
        }
        return newList;
    }

}
