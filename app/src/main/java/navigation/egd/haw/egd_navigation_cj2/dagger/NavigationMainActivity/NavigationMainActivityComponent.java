package navigation.egd.haw.egd_navigation_cj2.dagger.NavigationMainActivity;

import dagger.Component;
import navigation.egd.haw.egd_navigation_cj2.NavigationMainActivity;

/**
 * @author
 * Created by prann on 11/6/2017.
 */

@Component(modules = {NavigationMainActivityModule.class})
public interface NavigationMainActivityComponent {
    void inject(NavigationMainActivity mainActivity);
}
