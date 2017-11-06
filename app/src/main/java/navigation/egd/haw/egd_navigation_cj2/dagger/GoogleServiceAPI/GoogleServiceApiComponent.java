package navigation.egd.haw.egd_navigation_cj2.dagger.GoogleServiceAPI;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.dagger.AsyncUtil.AsyncUtilModule;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.DirectionAPIService;

/**
 * @author
 * Created by prann on 11/6/2017.
 */

@Component(modules = {AsyncUtilModule.class, GoogleServiceApiModule.class})
public interface GoogleServiceApiComponent {
    void inject(DirectionAPIService googleServiceApi);
}
