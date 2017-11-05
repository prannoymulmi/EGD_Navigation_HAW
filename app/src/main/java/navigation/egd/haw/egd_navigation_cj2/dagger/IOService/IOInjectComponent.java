package navigation.egd.haw.egd_navigation_cj2.dagger.IOService;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 * Created by prann on 11/5/2017.
 */

@Component(modules = IONavModule.class)
@Singleton
public interface IOInjectComponent extends IOComponent {
}
