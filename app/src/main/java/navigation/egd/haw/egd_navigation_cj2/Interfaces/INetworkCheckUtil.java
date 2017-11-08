package navigation.egd.haw.egd_navigation_cj2.Interfaces;

/**
 * @author
 * This interface is the structure of how th
 * Created by prann on 11/8/2017.
 */

public interface INetworkCheckUtil {
    /**
     * The method is expecting an generic Object so that the isConnectingToInternet has a more flexible parameter
     * NOTE: In the current implementation the input parameter to the method is casted to a Context. May change later
     * @param context
     * @return
     */
    boolean isConnectingToInternet(Object context);
}
