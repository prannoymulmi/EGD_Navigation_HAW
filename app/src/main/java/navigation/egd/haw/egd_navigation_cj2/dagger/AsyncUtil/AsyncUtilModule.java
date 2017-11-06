package navigation.egd.haw.egd_navigation_cj2.dagger.AsyncUtil;

import dagger.Module;
import dagger.Provides;
import navigation.egd.haw.egd_navigation_cj2.utils.AsyncTaskUtil;

/**
 * @author
 * Created by prann on 11/6/2017.
 */

@Module
public class AsyncUtilModule {
    @Provides
    AsyncTaskUtil asyncTaskUtil() {
        return new AsyncTaskUtil();
    };
}
