package navigation.egd.haw.egd_navigation_cj2.controllers;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirection;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpsService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavIO;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;


import navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI.DaggerDirectionGoogleAPIComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI.DaggerDirectionInjectComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI.DirectionComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.GPSService.DaggerGpsRedHatImplmentationComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.GPSService.GpsComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.IOService.DaggerIOInjectComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.IOService.IOComponent;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleAPIServices.GoogleAPIService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * This class is responsible to communicate with all the services for the navigation
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class NavigationManger  implements INavigationManager {
    //Injection of the objects using dagger
    @Inject IDirection directionAPIService;
    @Inject IGpsService gpsService;
    @Inject INavIO navigationIOProcessService;

    @Inject
    public NavigationManger() {
        DirectionComponent directionGoogleAPIComponent = DaggerDirectionGoogleAPIComponent.create();
        GpsComponent gpsComponent = DaggerGpsRedHatImplmentationComponent.create();
        IOComponent ioComponent = DaggerIOInjectComponent.create();

        DaggerDirectionInjectComponent.builder()
                .directionComponent(directionGoogleAPIComponent)
                .gpsComponent(gpsComponent)
                .iOComponent(ioComponent)
                .build()
                .inject(this);
    }

    public void run() {
        this.directionAPIService.setOnProcessFinish(new IAsyncTaskListenerOnFinish() {
            @Override
            public void onProcessFinish(Object result) {
              Log.d("finished", result.toString());
            }
        });
        Map<String, String> queries = new HashMap<>();
        this.directionAPIService.getDirections(APIConstants.MODE_WALKING, "Spannskamp 26","berliner tor 7", APIConstants.GOOGLE_DIRECTIONS_API_KEY, queries);
    }

    //------------------Getters and setters-----------------
    public GoogleAPIService getDirectionAPIService() {
        return null;
    }

    @Override
    public GPSService getGpsService() {
        return null;
    }

    @Override
    public NavigationIOProcessService getNavigationIOProcessService() {
        return null;
    }

}
