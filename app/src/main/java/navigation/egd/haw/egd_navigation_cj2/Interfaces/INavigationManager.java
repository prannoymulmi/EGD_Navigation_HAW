package navigation.egd.haw.egd_navigation_cj2.Interfaces;

import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService.GoogleDirectionApiService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * An interface so that the following classes are present in the implemented class
 * @author prannoy
 * Created by prann on 10/21/2017.
 */

public interface INavigationManager {
     GoogleDirectionApiService getGoogleDirectionApiService();
     GPSService getGpsService();
     NavigationIOProcessService getNavigationIOProcessService() ;
}
