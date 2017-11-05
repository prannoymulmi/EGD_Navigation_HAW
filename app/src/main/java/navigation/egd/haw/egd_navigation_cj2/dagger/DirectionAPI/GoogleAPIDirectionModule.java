package navigation.egd.haw.egd_navigation_cj2.dagger.DirectionAPI;

import dagger.Binds;
import dagger.Module;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IDirection;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleAPIServices.GoogleAPIService;


/**
 * @author prannoy
 * Examples
 * <a href = https://github.com/slidenerd/Vivz_Dagger_2_Demo/>
 * <a href = http://slidenerd.com/2015/09/11/android-dependency-injection-frameworks />
 * <a href = https://github.com/peter-tackage/dagger2-examples/blob/master/build.gradle />
 *
 * Inversion of control (IoC) principles
    # The modules of top levels shouldn’t depend on modules of the lower levels. The modules of all levels should depend on abstractions.
    # The abstractions shouldn’t depend on details. The details should depend on abstractions.
 *
 * Design disadvantages to be eliminated with IoC
    # Rigidity. If we change one module the other modules are changed too.
    # Fragility. If we change one part of program the other parts will have got uncontrolled errors.
    # Immobility. The single module can be hardly separated from the rest part of the application to be used again.*
 * Created by prann on 11/4/2017.
 * A module which returns the IDirection interface with the specific GoogleAPI Service.
 */

@Module
public interface GoogleAPIDirectionModule {
    @Binds IDirection idirection(GoogleAPIService googleAPIService);
}
