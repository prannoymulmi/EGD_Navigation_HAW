package navigation.egd.haw.egd_navigation_cj2.Interfaces;

import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.utils.AsyncTaskUtil;

/**
 * Created by prann on 11/4/2017.
 */

public interface IDirection {
    void getDirections(final String mode, final String origin, final String destination, final String key, final Map<String,String> queries);
    AsyncTaskUtil getAsyncTaskUtil();
    void setOnProcessFinish(IAsyncTaskListenerOnFinish listner);
    DirectionAPI getResults();

}
