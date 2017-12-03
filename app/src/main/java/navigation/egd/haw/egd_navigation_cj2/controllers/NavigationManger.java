package navigation.egd.haw.egd_navigation_cj2.controllers;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirectionApi;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpsService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationIOProcessService;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationManager;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.INetworkCheckUtil;
import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.dagger.NavigationManager.DaggerNavigationManagerComponent;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;
import navigation.egd.haw.egd_navigation_cj2.utils.StartupUtil;

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
    @Inject INetworkCheckUtil networkCheckUtil;



    public NavigationManger() {
        // All the dependencies being injected using dagger
        DaggerNavigationManagerComponent.builder().build().inject(this);
    }

    /**
     * Runs all the services in the right sequence to send the navigation data to the UI
     * includes making request to the server, Gps connection
     */
    public void run() {
        this.googleDirectionApiService.setOnProcessFinish(new IAsyncTaskListenerOnFinish() {
            @Override
            //This method only runs when a successful query to the server is done
            public void onProcessFinish(Object result) {
                Log.d("finished", result.toString());
            }
        });
        Map<String, String> queries = new HashMap<>();
        Context context = StartupUtil.getInstance().getContext();
        boolean isNetworkConnected = networkCheckUtil.isConnectingToInternet(context);

        if(isNetworkConnected) {
            //TODO: Change the Origin and destination with proper inputs
            //NOTE: If the street names are the same in two different places the Cty and the country must be given
            /**
             * A Suggestion to solve this issue, Since the use case is only for walking  it is assumed that the user will not be using the navigation for going long distance travel so the
             * City name and Country of his current position will be added to the destination or latitiute or long will be specified
             */
            this.googleDirectionApiService.getDirections(APIConstants.MODE_WALKING, "Spannskamp 26", "rathausstraße, Hamburg", APIConstants.GOOGLE_DIRECTIONS_API_KEY, queries);
        } else {
            //TODO: Send A feedback to the UI that no internet Connection
        }

    }
}
