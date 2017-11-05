package navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;
import navigation.egd.haw.egd_navigation_cj2.dagger.GPSService.GpsComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.IOService.IOComponent;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleAPIServices.GoogleAPIService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * @
 * Created by prann on 11/5/2017.
 */

@Component(dependencies = {
        DirectionComponent.class,
        GpsComponent.class,
        IOComponent.class
})

public interface DirectionInjectComponent {
    GoogleAPIService directionApiService();
    GPSService gpsService();
    NavigationIOProcessService ioService();
    void inject(NavigationManger manager);
}
