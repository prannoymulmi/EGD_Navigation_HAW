package navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;
import navigation.egd.haw.egd_navigation_cj2.dagger.GPSService.GPSComponent;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleAPIServices.GoogleAPIService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;

/**
 * @
 * Created by prann on 11/5/2017.
 */

@Component(dependencies = {
        DirectionComponent.class,
        GPSComponent.class
})
public interface DirectionInjectComponent {
    GoogleAPIService directionApiService();
    GPSService gpsService();
    void inject(NavigationManger manager);
}
