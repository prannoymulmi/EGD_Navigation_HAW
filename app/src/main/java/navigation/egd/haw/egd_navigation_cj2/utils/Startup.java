package navigation.egd.haw.egd_navigation_cj2.utils;

import android.content.Context;

import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationIOProcessService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModuleProviders;

/**
 * This is a singleton class which reads the config files from the xml used to inject dependencies dynamically
 * Created by prann on 11/12/2017.
 */

public class Startup {
    private static final Startup ourInstance = new Startup();
    private Context context;


    //Initialization of the singleton
    public void init(Context context) {
        this.context = context;
        XMLParserUtil parser = new XMLParserUtil();
        if(context != null) {
            configs = parser.parseXml(context);
        }
    }



    //------------------ Getters and Setters------------
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Map<String, Map<String, DaggerModuleProviders>> configs;

    public static Startup getOurInstance() {
        return ourInstance;
    }

    public Map<String, Map<String, DaggerModuleProviders>> getConfigs() {
        return configs;
    }

    public static Startup getInstance() {
        return ourInstance;
    }

    private Startup() {
    }
}
