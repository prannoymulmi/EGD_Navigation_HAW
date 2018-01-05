package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices.GoogleDirectionAPIService;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import navigation.egd.haw.egd_navigation_cj2.constants.APIConstants;
import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is a middleware which instatiates the api and makes the actual calls to the web api
 * @author prannoy
 * Created by prann on 10/25/2017.
 * <a href=https://github.com/square/okhttp/wiki/Recipes#timeouts/> example for Retrofit timeout
 * <a href=https://futurestud.io/tutorials/retrofit-2-catch-server-errors-globally-with-response-interceptor/> example for error handling
 */

public class GoogleDirectionApiMiddleware {
    private IGoogleDirectionApiService mDirectionApi;


    /**
     * Here the retrofit client is being instantiated which is responsible for carrying out all the requests.
     */
    public GoogleDirectionApiMiddleware() {
        /**
         *An OkHttpclient adds a timeout so that if there are some issues connecting to the server it times out and
         * also an interceptor is added so that the status codes can be read meaning when the server send a status code of for the request not being
         * successful it can be handled.
         */

        //TODO: Override the timeout method
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(APIConstants.CONNECT_TIMEOUT_MILLI_SEC, TimeUnit.MILLISECONDS)
                .readTimeout(APIConstants.READ_TIMEOUT_MILLI_SEC, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        okhttp3.Response response = chain.proceed(request);

                        // TODO: Put related status code that is needed to be handled

                        //This code is a sucess
                        if (response.code() == 200) {


                            //TODO: This must be discussed what is to be done when an error occurs

                            return response;
                        }

                        //Catch all errors here
                        if (response.code() >= 400) {


                            //TODO: This must be discussed what is to be done when an error occurs

                            return null;
                        }

                        return response;
                    }
                })
                .build();

        mDirectionApi = new Retrofit.Builder()
                .baseUrl(APIConstants.GOOGLE_DIRECTIONS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(IGoogleDirectionApiService.class);
    }

    @Nullable
    public DirectionAPI getWalkingDirections(String mode, String origin, String destination, String key, Map<String,String> queries) throws IOException {
        Response<DirectionAPI> response = mDirectionApi.getWalkingDirections(mode, origin, destination, key, queries).execute();

        /**
         * ERROR handling being done when the status of the body is not OK
         * A Suggestion for error handling is get the query parameters from the response and the give it back to the UI so that they can check it
         * Must be discussed
         */
        if(!response.body().getStatus().equals("OK")) {
            return response.body();
        } else {
            return null;
        }
    }
}
