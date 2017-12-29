package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService;

import android.util.Log;
import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;


import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirectionApi;
import navigation.egd.haw.egd_navigation_cj2.dagger.AsyncUtil.AsyncUtilModule;

import navigation.egd.haw.egd_navigation_cj2.dagger.GoogleServiceAPI.DaggerGoogleServiceApiComponent;
import navigation.egd.haw.egd_navigation_cj2.dagger.GoogleServiceAPI.GoogleServiceApiModule;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListener;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.utils.AsyncTaskUtil;


/**
 * This is a class which is responsible to call the endpoints of the google direction api
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class GoogleDirectionApiService implements IDirectionApi{
    //Injection the dependencies using the @Inject annotations
    // this is managed by the dagger framework checks in the component which modules are to be included
    @Inject AsyncTaskUtil asyncTaskUtil;
    @Inject GoogleDirectionApiMiddleware googleDirectionApiMiddleware;
    @Inject DirectionAPI results;
    public IAsyncTaskListenerOnFinish asyncTaskListenerOnFinish;



    @Inject
    public GoogleDirectionApiService()  {
        asyncTaskListenerOnFinish = null;
        //This way the initialization of the dependencies are not done in this module which makes the dependencies loosely coupled
        DaggerGoogleServiceApiComponent.builder()
                .asyncUtilModule(new AsyncUtilModule())
                .googleServiceApiModule(new GoogleServiceApiModule())
                .build()
                .inject(this);

        //setting up listener which notifies when a response is recieved from the
        //google API
        asyncTaskUtil.setAsyncTaskListenerOnFinish(new IAsyncTaskListenerOnFinish() {
            @Override
            public void onProcessFinish(Object result) {
                if(asyncTaskListenerOnFinish != null) {
                    asyncTaskListenerOnFinish.onProcessFinish(result);
                    asyncTaskListenerOnFinish = null;
                }
                results = (DirectionAPI) result;
            }
        });

    }

    public void getDirections(final String mode, final String origin, final String destination, final String key, final Map<String,String> queries) {
        //setting up a ascyn task to run as a thread when the http request is made
        //This ensures that the request that are being made is not blocking the code
        asyncTaskUtil.setAsyncTaskListener(new IAsyncTaskListener() {
            @Override
            public Object asyncTaskCallback(Object... objects)  {
                DirectionAPI directions = null;
                try {
                    directions = googleDirectionApiMiddleware.getWalkingDirections(mode,origin, destination, key, queries);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("Direction", directions.toString());
                return directions;
            }
        });
        asyncTaskUtil.execute();
    }

    public void setOnProcessFinish(IAsyncTaskListenerOnFinish listner) {
        asyncTaskListenerOnFinish = listner;
    }

}
