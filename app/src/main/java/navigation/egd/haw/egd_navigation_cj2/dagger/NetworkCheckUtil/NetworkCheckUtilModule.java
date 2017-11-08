package navigation.egd.haw.egd_navigation_cj2.dagger.NetworkCheckUtil;


import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INetworkCheckUtil;
import navigation.egd.haw.egd_navigation_cj2.utils.NetworkCheckUtil;

/**
 * @
 * Created by prann on 11/8/2017.
 */

@Module
public class NetworkCheckUtilModule {
    @Provides
    INetworkCheckUtil networkCheckUtil() {
        return new NetworkCheckUtil();
    }
}
