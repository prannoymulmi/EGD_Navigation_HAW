package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationManager;

import javax.inject.Singleton;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;

/**
 * @author prannoy
 * This is the component which injects all the dependencies into the NavigationManager using the inject method declared in the interface
 * Created by prann on 11/6/2017.
 */
@Component(modules = {NavigationManagerModule.class})
@Singleton
public interface NavigationManagerComponent {
    void inject(NavigationManger navigationManger);
}
