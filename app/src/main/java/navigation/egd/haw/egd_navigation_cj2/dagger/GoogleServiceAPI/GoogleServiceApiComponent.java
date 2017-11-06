package navigation.egd.haw.egd_navigation_cj2.dagger.GoogleServiceAPI;

import javax.inject.Singleton;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.dagger.AsyncUtil.AsyncUtilModule;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService.GoogleDirectionApiService;

/**
 * @author
 * Created by prann on 11/6/2017.
 */

@Component(modules = {AsyncUtilModule.class, GoogleServiceApiModule.class})
@Singleton
public interface GoogleServiceApiComponent {
    void inject(GoogleDirectionApiService googleServiceApi);
}
