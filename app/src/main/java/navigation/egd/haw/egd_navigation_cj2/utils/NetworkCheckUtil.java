package navigation.egd.haw.egd_navigation_cj2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import navigation.egd.haw.egd_navigation_cj2.Interfaces.INetworkCheckUtil;

/**
 * @author
 * Created by prann on 11/8/2017.
 * <a href=https://stackoverflow.com/questions/36268948/how-to-check-internet-available-in-android/>
 * This class checks if the Network is connected to the internet or not
 */

//TODO: Remove it with a more generic class
public class NetworkCheckUtil implements INetworkCheckUtil{
    @Override
    public boolean isConnectingToInternet(Object object) {
        Context context = (Context) object;
        if(context != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) (context.getSystemService(Context.CONNECTIVITY_SERVICE));

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

            return activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }
}
