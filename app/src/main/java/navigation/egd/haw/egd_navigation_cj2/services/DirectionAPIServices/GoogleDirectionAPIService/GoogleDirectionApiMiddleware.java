package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService.IGoogleDirectionApiService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is a middleware which instatiates the api and makes the actual calls to the web api
 * @author prannoy
 * Created by prann on 10/25/2017.
 */

public class GoogleDirectionApiMiddleware {
    private IGoogleDirectionApiService mDirectionApi;

    public GoogleDirectionApiMiddleware() {
        mDirectionApi = new Retrofit.Builder()
                .baseUrl(APIConstants.GOOGLE_DIRECTIONS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IGoogleDirectionApiService.class);
    }

    @Nullable
    public DirectionAPI getWalkingDirections(String mode, String origin, String destination, String key, Map<String,String> queries) throws IOException {
        Response<DirectionAPI> response = mDirectionApi.getWalkingDirections(mode, origin, destination, key, queries).execute();

        return response.body();
    }
}
