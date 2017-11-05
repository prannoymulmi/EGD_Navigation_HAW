package navigation.egd.haw.egd_navigation_cj2.dagger.GPSService;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 * Created by prann on 11/5/2017.
 */

@Component(modules = GpsServiceModule.class)
@Singleton
public interface GpsRedHatImplmentationComponent extends GpsComponent {
}
