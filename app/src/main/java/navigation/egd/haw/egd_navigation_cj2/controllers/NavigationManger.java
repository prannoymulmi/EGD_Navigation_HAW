package navigation.egd.haw.egd_navigation_cj2.controllers;


import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.DirectionAPIService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * This class is responsible to communicate with all the services for the navigation
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class NavigationManger implements INavigationManager {

    private DirectionAPIService apiService;
    private GPSService gpsService;
    private NavigationIOProcessService navigationIOProcessService;

    public NavigationManger() {
        this.apiService = new DirectionAPIService();
        this.gpsService = new GPSService();
        this.navigationIOProcessService = new NavigationIOProcessService();
    }


    //------------------Getters and setters-----------------
    @Override
    public DirectionAPIService getApiService() {
        return apiService;
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
