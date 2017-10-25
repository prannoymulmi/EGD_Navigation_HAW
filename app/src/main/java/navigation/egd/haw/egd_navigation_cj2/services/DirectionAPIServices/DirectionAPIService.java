package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices;

import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListener;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.utils.AsyncTaskUtil;


/**
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class DirectionAPIService {
    private IDirectionAPIService mDirectionApi;
    private AsyncTaskUtil asyncTaskUtil;
    private DirectionAPIMiddleware directionAPIMiddleware;

    public DirectionAPIService()  {
        directionAPIMiddleware = new DirectionAPIMiddleware();
        asyncTaskUtil = new AsyncTaskUtil();
        asyncTaskUtil.setAsyncTaskListener(new IAsyncTaskListener() {
            @Override
            public Object asyncTaskCallback(Object... objects)  {
                DirectionAPI directions = null;
                try {
                    directions = directionAPIMiddleware.getWalkingDirections("walking", "Spannskamp 26","barmbek", APIConstants.GOOGLE_DIRECTIONS_API_KEY);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("Direction", directions.toString());
                return directions;
            }
        });
    }

    public void getDirections() {
        asyncTaskUtil.execute();
    }
}
