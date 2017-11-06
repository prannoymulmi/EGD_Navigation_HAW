package navigation.egd.haw.egd_navigation_cj2.Interfaces;

import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.listeners.IAsyncTaskListenerOnFinish;

/**
 *
 * Created by prann on 11/4/2017.
 */

public interface IDirectionApi {
    void getDirections(final String mode, final String origin, final String destination, final String key, final Map<String,String> queries);
    void setOnProcessFinish(IAsyncTaskListenerOnFinish listner);
}
