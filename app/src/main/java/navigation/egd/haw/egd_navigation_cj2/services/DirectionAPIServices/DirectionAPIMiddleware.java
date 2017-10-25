package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices;

import android.support.annotation.Nullable;

import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author prannoy
 * Created by prann on 10/25/2017.
 */

public class DirectionAPIMiddleware {
    private IDirectionAPIService mDirectionApi;

    public DirectionAPIMiddleware() {
        //        Retrofit retrofit = new Retrofit().

        //        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //        httpClient.addInterceptor(new Interceptor() {
        //                                      @Override
        //                                      public Response intercept(Interceptor.Chain chain) throws IOException {
        //                                          Request original = chain.request();
        //
        //                                          Request request = original.newBuilder()
        //                                                  .header("User-Agent", "Your-App-Name")
        //                                                  .header("Accept", "application/vnd.yourapi.v1.full+json")
        //                                                  .method(original.method(), original.body())
        //                                                  .build();
        //
        //                                          return chain.proceed(request);
        //                                      }
        //                                  });
        //
        //                OkHttpClient client = httpClient.build();

        mDirectionApi = new Retrofit.Builder()
                .baseUrl(APIConstants.GOOGLE_DIRECTIONS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IDirectionAPIService.class);
    }

    @Nullable
    public DirectionAPI getWalkingDirections(String mode, String origin, String destination, String key) throws IOException {
        Response<DirectionAPI> response = mDirectionApi.getWalkingDirections(mode, origin, destination, key).execute();

        return response.body();
    }
}
