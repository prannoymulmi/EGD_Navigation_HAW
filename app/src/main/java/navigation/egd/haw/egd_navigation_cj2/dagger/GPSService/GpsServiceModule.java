package navigation.egd.haw.egd_navigation_cj2.dagger.GPSService;

import dagger.Binds;
import dagger.Module;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.IGpsService;
import navigation.egd.haw.egd_navigation_cj2.services.GPSServices.GPSService;

/**
 * Created by prann on 11/5/2017.
 */

@Module
public interface GpsServiceModule {
    @Binds
    IGpsService gps(GPSService gpsService);
}
