package nl.bigo.retrofitoauth;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TwitterService {

    @FormUrlEncoded
    @POST("1.1/statuses/update.json")
    Call<TwitterDto> sendPost(@Field("status") String postContent);
}
