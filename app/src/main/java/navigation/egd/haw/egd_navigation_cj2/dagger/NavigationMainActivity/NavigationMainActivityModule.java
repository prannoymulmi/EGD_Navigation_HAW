package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity;

import android.content.Context;

import java.util.Map;



import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.controllers.GpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.models.XML.DaggerModuleProviders;
import navigation.egd.haw.egd_navigation_cj2.utils.ClassInstantiatorUtil;
import navigation.egd.haw.egd_navigation_cj2.utils.Startup;

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
    private final Startup startup;
    private final Map<String, Map<String, DaggerModuleProviders>> configs;
    public NavigationMainActivityModule() {
        startup = Startup.getInstance();
        configs = startup.getConfigs();
        context = startup.getContext();
    }

    @Provides
    INavigationManager iNavigationManager() {
        ClassInstantiatorUtil<INavigationManager> test = new ClassInstantiatorUtil<>();
        DaggerModuleProviders provider = configs.get("NavigationMainActivityModule").get("iNavigationManager");
        INavigationManager nav = test.instantiateClass(provider.getClassName(), provider.getPackageName());
        return nav;
    }

    @Provides
    GpioPortsConfigs gpioPortsConfigs() {
        return new GpioPortsConfigs();
    }
}
