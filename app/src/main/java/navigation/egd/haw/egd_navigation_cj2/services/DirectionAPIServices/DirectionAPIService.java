package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices;

import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListener;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.utils.AsyncTaskUtil;


/**
 * This is a class which is responsible to call the endpoints of the google direction api
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class DirectionAPIService {
    private AsyncTaskUtil asyncTaskUtil;
    private DirectionAPIMiddleware directionAPIMiddleware;
    private DirectionAPI results;
    public IAsyncTaskListenerOnFinish asyncTaskListenerOnFinish;



    public DirectionAPIService()  {
        directionAPIMiddleware = new DirectionAPIMiddleware();

        results = new DirectionAPI();
        asyncTaskUtil = new AsyncTaskUtil();
        asyncTaskListenerOnFinish = null;

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
        asyncTaskUtil.setAsyncTaskListener(new IAsyncTaskListener() {
            @Override
            public Object asyncTaskCallback(Object... objects)  {
                DirectionAPI directions = null;
                try {
                    directions = directionAPIMiddleware.getWalkingDirections(mode,origin, destination, key, queries);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("Direction", directions.toString());
                return directions;
            }
        });
        asyncTaskUtil.execute();
    }

    public AsyncTaskUtil getAsyncTaskUtil() {
        return asyncTaskUtil;
    }

    public void setOnProcessFinish(IAsyncTaskListenerOnFinish listner) {
        asyncTaskListenerOnFinish = listner;
    }

    public DirectionAPI getResults() {
        return results;
    }
}
