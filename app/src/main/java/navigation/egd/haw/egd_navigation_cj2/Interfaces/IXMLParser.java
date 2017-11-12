package navigation.egd.haw.egd_navigation_cj2.Interfaces;

import android.content.Context;

import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModuleProviders;

/**
 *Interface defining the an xml parser
 * Created by prann on 11/12/2017.
 */

public interface IXMLParser {
    public Map<String, Map<String, DaggerModuleProviders>> parseXml(Context context);
}
