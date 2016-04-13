package nl.bigo.retrofitoauth;


import retrofit2.Call;
import retrofit2.http.*;

public interface TwitterService {

    @FormUrlEncoded
    @POST("1.1/statuses/update.json")
    Call<TwitterDto> sendPost(@Field("status") String postContent);

    @GET("1.1/search/tweets.json")
    Call<Object> search(@Query("q") String query);
}
