
package navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI;

import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Prannoy
 * This is a model the description of Google Direction API return data
 */
public class DirectionAPI {

    @SerializedName("geocoded_waypoints")
    @Expose
    private List<GeocodedWaypoint> geocodedWaypoints = null;
    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Returns a Json String from the GSON
    public String toString() {
        Gson gson = new Gson();
        Type type = new TypeToken<DirectionAPI>() {}.getType();
        String json = gson.toJson(this, type);
        return json;
    }
}
