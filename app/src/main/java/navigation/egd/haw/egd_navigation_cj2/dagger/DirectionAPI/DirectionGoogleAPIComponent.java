package navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author prannoy
 * A Dagger component which exposes the GoogleDirectionApi module
 * Created by prann on 11/5/2017.
 */

@Component(modules = GoogleAPIDirectionModule.class)
@Singleton
interface DirectionGoogleAPIComponent extends DirectionComponent {

}
