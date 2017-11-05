package navigation.egd.haw.egd_navigation_cj2.dagger.components;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.dagger.modules.GoogleAPIDirectionModule;

/**
 * @author
 * Created by prann on 11/5/2017.
 */

@Component(modules = GoogleAPIDirectionModule.class)
interface DirectionGoogleAPIComponent extends DirectionComponent {

}
