package navigation.egd.haw.egd_navigation_cj2.controllers;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirectionApi;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpsService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationIOProcessService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.dagger.NavigationManager.DaggerNavigationManagerComponent;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;

/**
 * This class is responsible to communicate with all the services for the navigation
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class NavigationManger  implements INavigationManager {
    //The Abstractions of the services are being used so that they can be replaced by future implmentations
    @Inject IGpsService gpsService;
    @Inject INavigationIOProcessService navigationIOProcessService;
    @Inject IDirectionApi googleDirectionApiService;

    @Inject
    public NavigationManger() {
        // All the dependencies being injected using dagger
        DaggerNavigationManagerComponent.builder().build().inject(this);
    }

    public void run() {
        this.googleDirectionApiService.setOnProcessFinish(new IAsyncTaskListenerOnFinish() {
            @Override
            public void onProcessFinish(Object result) {
              Log.d("finished", result.toString());
            }
        });
        Map<String, String> queries = new HashMap<>();
        this.googleDirectionApiService.getDirections(APIConstants.MODE_WALKING, "Spannskamp 26","barmbek", APIConstants.GOOGLE_DIRECTIONS_API_KEY, queries);
    }
}
