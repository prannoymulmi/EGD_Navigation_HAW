package navigation.egd.haw.egd_navigation_cj2.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;



import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModulesList;

/**
 * @
 * Created by prann on 11/11/2017.
 */

public class XMLParserUtil {
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

    public void parseXml(Context context){
        Serializer serializer = new Persister();
        try {
            AssetManager am = context.getAssets();
            InputStream inputStream = am.open("test.xml");
            DaggerModulesList modules = serializer.read(DaggerModulesList.class, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
