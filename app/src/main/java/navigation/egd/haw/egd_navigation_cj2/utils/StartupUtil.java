package navigation.egd.haw.egd_navigation_cj2.utils;

import android.content.Context;

import java.util.Map;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModuleProviders;

/**
 * This is a singleton class which reads the config files from the xml used to inject dependencies dynamically
 *
 * Note: This is a Singleton class and it does not make sense to use this if there is more than one Context contaning classes because
 * It may be the other class which is gonna use the context will use the incorrect Context.
 *
 * Possible solution:
 * If many Activities or classes containing Context is there the context of the class should be passed to the non activity class as a
 * dependency.
 * Created by prann on 11/12/2017.
 */

public class StartupUtil {
    private static final StartupUtil ourInstance = new StartupUtil();
    private Context context;


    /**
     * Initialization of the singleton where the context of the activity which can be used throughout the non activity class
     * @param context
     */
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

    public static StartupUtil getOurInstance() {
        return ourInstance;
    }

    public Map<String, Map<String, DaggerModuleProviders>> getConfigs() {
        return configs;
    }

    public static StartupUtil getInstance() {
        return ourInstance;
    }

    private StartupUtil() {
    }
}
