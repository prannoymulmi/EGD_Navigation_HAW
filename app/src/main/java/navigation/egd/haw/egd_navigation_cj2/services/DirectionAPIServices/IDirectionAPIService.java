package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices;

import java.util.List;

import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author prannoy
 * Created by prann on 10/23/2017.
 */

public interface IDirectionAPIService {

    @GET("maps/api/directions/json")
    Call <DirectionAPI> getWalkingDirections(
            @Query("mode") String mode,
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("key") String key
    );
}
