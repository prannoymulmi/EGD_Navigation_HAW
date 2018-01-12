package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity;

import android.content.Context;

import java.util.Map;



import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.presenters.GpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModuleProviders;
import navigation.egd.haw.egd_navigation_cj2.utils.ClassInstantiatorUtil;
import navigation.egd.haw.egd_navigation_cj2.utils.StartupUtil;

/**
 * @author Prannoy
 * This module describes the necessary Objects that would be later injected to navigation activity module
 * NOTE: In principle you can add as many modules as you want but this in this project the module with the Class name
 * has dependencies which are specific to the class
 * Created by prann on 11/6/2017.
 */

@Module
public class NavigationMainActivityModule {
    private final Context context;
    private final StartupUtil startupUtil;
    private final Map<String, Map<String, DaggerModuleProviders>> configs;
    public NavigationMainActivityModule() {
        startupUtil = StartupUtil.getInstance();
        configs = startupUtil.getConfigs();
        context = startupUtil.getContext();
    }

    /**
     * This is an example where the config file which was read and the class is being instatinated dynamically
     * @return
     */
    @Provides
    INavigationManager iNavigationManager() {
        ClassInstantiatorUtil<INavigationManager> dynamicObjectInstantiator = new ClassInstantiatorUtil<>();
        // gets the packgae name of the coresponding provider
        DaggerModuleProviders provider = configs.get("NavigationMainActivityModule").get("iNavigationManager");
        // Instantiates the class with the package name
        INavigationManager nav = dynamicObjectInstantiator.instantiateClass(provider.getPackageName());
        return nav;
    }

    @Provides
    GpioPortsConfigs gpioPortsConfigs() {
        return new GpioPortsConfigs();
    }
}
