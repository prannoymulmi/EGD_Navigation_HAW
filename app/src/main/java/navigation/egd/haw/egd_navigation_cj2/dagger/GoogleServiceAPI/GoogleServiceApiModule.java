package navigation.egd.haw.egd_navigation_cj2.dagger.GoogleServiceAPI;

import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService.GoogleDirectionApiMiddleware;

/**
 *
 * Created by prann on 11/6/2017.
 */

@Module
public class GoogleServiceApiModule {
    @Provides
    GoogleDirectionApiMiddleware directionAPIMiddleware() {
        return new GoogleDirectionApiMiddleware();
    }

    @Provides
    DirectionAPI directionAPI() {
        return new DirectionAPI();
    }
}
