package nl.bigo.retrofitoauth;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class JavaRestTweet {
    static String consumerKeyStr = "m97PpyRg5NrRXMmXZuZ8MbDmO";
    static String consumerSecretStr = "AVcFK2KH50A2aLPg3TtFhf5co2nDcHpaR4ExvFD5MxnwNzNlZD";
    static String accessTokenStr = "56252103-cUVbOmZ2mkkyrfZ2y71KXtVcCVqXeZIXIjcmwlyUs";
    static String accessTokenSecretStr = "6UzR0ZOQr6zjfeI3wsBYe0IrlvJeM4tCctANHLizG6sTf";


    public static void main(String[] args) throws Exception {


        OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,
                consumerSecretStr);
        oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

        HttpPost httpPost = new HttpPost(
                "https://api.twitter.com/1.1/statuses/update.json?status=TestHello%20Twitter%20World.");

        oAuthConsumer.sign(httpPost);

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpPost);

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ':'
                + httpResponse.getStatusLine().getReasonPhrase());
        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));

    }
}