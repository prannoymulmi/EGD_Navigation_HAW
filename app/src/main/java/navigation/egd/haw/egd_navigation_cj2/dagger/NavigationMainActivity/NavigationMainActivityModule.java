package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.controllers.GpioPortsConfigs;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;

/**
 * @author Prannoy
 * Created by prann on 11/6/2017.
 */

@Module
public class NavigationMainActivityModule {

    @Provides
    INavigationManager iNavigationManager() {
        return new NavigationManger();
    }

    @Provides
    GpioPortsConfigs gpioPortsConfigs() {
        return new GpioPortsConfigs();
    }
}
