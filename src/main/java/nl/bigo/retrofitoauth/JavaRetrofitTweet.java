package nl.bigo.retrofitoauth;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class JavaRetrofitTweet {
    static String consumerKeyStr = "m97PpyRg5NrRXMmXZuZ8MbDmO";
    static String consumerSecretStr = "AVcFK2KH50A2aLPg3TtFhf5co2nDcHpaR4ExvFD5MxnwNzNlZD";
    static String accessTokenStr = "56252103-cUVbOmZ2mkkyrfZ2y71KXtVcCVqXeZIXIjcmwlyUs";
    static String accessTokenSecretStr = "6UzR0ZOQr6zjfeI3wsBYe0IrlvJeM4tCctANHLizG6sTf";


    public static void main(String[] args) throws Exception {


        //consumer
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
        consumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

        //log
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//print all


        //client
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.twitter.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        TwitterService service = retrofit.create(TwitterService.class);
        Call<TwitterDto> twitterDtoCall = service.sendPost("This is third tweet sent from Retrofit." + System.currentTimeMillis());
        Response<TwitterDto> tempResult = twitterDtoCall.execute();

        TwitterDto body = tempResult.body();
        String id = body.getId_str();
        String alice = body.getAliceSource();
        System.out.println(id);
        System.out.println(alice);


    }
}