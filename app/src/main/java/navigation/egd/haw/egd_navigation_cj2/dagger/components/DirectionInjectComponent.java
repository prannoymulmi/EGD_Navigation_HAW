package navigation.egd.haw.egd_navigation_cj2.dagger.components;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.DirectionAPIService;

/**
 * @
 * Created by prann on 11/5/2017.
 */

@Component(dependencies = DirectionComponent.class)
public interface DirectionInjectComponent {
    DirectionAPIService directionApiService();
    void inject(NavigationManger manager);
}
