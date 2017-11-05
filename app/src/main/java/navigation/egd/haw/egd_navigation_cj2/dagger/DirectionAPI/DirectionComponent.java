package navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirection;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpsService;
import navigation.egd.haw.egd_navigation_cj2.controllers.NavigationManger;

/**
 * @author
 * Created by prann on 11/4/2017.
 * Simple interfaceto let dagger know the interface it is expecting is a IDirection
 * <a href = https://github.com/slidenerd/Vivz_Dagger_2_Demo/>
 */

public interface DirectionComponent {
   IDirection direction();
}
