package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirectionApi;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpsService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationIOProcessService;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService.GoogleDirectionApiService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GpsService;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * @author prannoy
 * This is the dependencies which can be injected in the NavigationManagerModule
 * TODO: Make on runtime depnendecyinjection
 * https://stackoverflow.com/questions/41084333/dagger-2-how-to-change-provided-dependencies-at-runtime
 * Created by prann on 11/6/2017.
 */

@Module
public class NavigationManagerModule {
    @Provides
    @Singleton
    GoogleDirectionApiService googleDirectionApiService () {
        return new GoogleDirectionApiService();
    }

    @Provides
    IDirectionApi iDirectionApi() {
        return new GoogleDirectionApiService();
    }

    @Provides
    IGpsService gpsService() {
        return new GpsService();
    }

    @Provides
    INavigationIOProcessService navigationIOProcessService() {
        return new NavigationIOProcessService();
    }
}
