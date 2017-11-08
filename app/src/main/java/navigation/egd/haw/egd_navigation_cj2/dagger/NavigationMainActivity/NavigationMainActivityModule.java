package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.controllers.GpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;

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
    public NavigationMainActivityModule(Context context) {
       this.context = context;
    }

    @Provides
    INavigationManager iNavigationManager() {
        return new NavigationManger(context);
    }

    @Provides
    GpioPortsConfigs gpioPortsConfigs() {
        return new GpioPortsConfigs();
    }
}
