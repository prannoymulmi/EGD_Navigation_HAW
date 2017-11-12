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
 * @
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

    public Map<String, Map<String, DaggerModuleProviders>> parseXml(Context context){
        Serializer serializer = new Persister();
        try {
            AssetManager am = context.getAssets();
            InputStream inputStream = am.open("test.xml");
            DaggerModulesList modules = serializer.read(DaggerModulesList.class, inputStream);
            return listToMap(modules);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
