package navigation.egd.haw.egd_navigation_cj2.services.DirectionAPIServices;

import java.io.IOException;

import navigation.egd.haw.egd_navigation_cj2.models.DirectionAPI.DirectionAPI;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Prannoy
 * Created by prann on 10/20/2017.
 */

public class DirectionAPIService {

    public DirectionAPIService() {
//        Retrofit retrofit = new Retrofit().

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
                                      @Override
                                      public Response intercept(Interceptor.Chain chain) throws IOException {
                                          Request original = chain.request();

                                          Request request = original.newBuilder()
                                                  .header("User-Agent", "Your-App-Name")
                                                  .header("Accept", "application/vnd.yourapi.v1.full+json")
                                                  .method(original.method(), original.body())
                                                  .build();

                                          return chain.proceed(request);
                                      }
                                  });

                OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
