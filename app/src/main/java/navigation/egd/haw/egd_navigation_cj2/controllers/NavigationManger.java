package navigation.egd.haw.egd_navigation_cj2.controllers;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.DirectionAPIService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * This class is responsible to communicate with all the services for the navigation
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class NavigationManger  implements INavigationManager {
    private DirectionAPIService directionAPIService;
    private GPSService gpsService;
    private NavigationIOProcessService navigationIOProcessService;

    public NavigationManger() {
        this.directionAPIService = new DirectionAPIService();
        this.gpsService = new GPSService();
        this.navigationIOProcessService = new NavigationIOProcessService();
    }

    public void run() {
        this.directionAPIService.setOnProcessFinish(new IAsyncTaskListenerOnFinish() {
            @Override
            public void onProcessFinish(Object result) {
              Log.d("finished", result.toString());
            }
        });
        Map<String, String> queries = new HashMap<>();
        this.directionAPIService.getDirections(APIConstants.MODE_WALKING, "Spannskamp 26","barmbek", APIConstants.GOOGLE_DIRECTIONS_API_KEY, queries);
    }

    //------------------Getters and setters-----------------
    public DirectionAPIService getDirectionAPIService() {
        return directionAPIService;
    }

    @Override
    public GPSService getGpsService() {
        return gpsService;
    }

    @Override
    public NavigationIOProcessService getNavigationIOProcessService() {
        return navigationIOProcessService;
    }

}
