package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleAPIServices;

import java.util.Map;

import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author prannoy
 * Created by prann on 10/23/2017.
 * Required parameters are origin, destination and key
 * @see <a href=https://google-developers.appspot.com/maps/documentation/directions/intro/>
 */

public interface IDirectionGoogleAPIService {

    @GET("maps/api/directions/json")
    Call <DirectionAPI> getWalkingDirections(
            @Query("mode") String mode,
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("key") String key,
            @QueryMap Map<String, String> optionalQueries
    );
}
