package navigation.egd.haw.egd_navigation_cj2.dagger.IOService;

import dagger.Binds;
import dagger.Module;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavIO;
import navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices.NavigationIOProcessService;

/**
 * @author
 * Created by prann on 11/5/2017.
 */

@Module
public interface IONavModule {
    @Binds
    INavIO iNavIO(NavigationIOProcessService nav);
}
