package navigation.egd.haw.egd_navigation_cj2.dagger.GoogleServiceAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.DirectionAPIMiddleware;

/**
 *
 * Created by prann on 11/6/2017.
 */

@Module
public class GoogleServiceApiModule {
    @Provides
    DirectionAPIMiddleware directionAPIMiddleware() {
        return new DirectionAPIMiddleware();
    }

    @Provides
    DirectionAPI directionAPI() {
        return new DirectionAPI();
    }
}
