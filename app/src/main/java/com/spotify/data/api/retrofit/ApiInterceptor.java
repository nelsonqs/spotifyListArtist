package com.spotify.data.api.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.spotify.data.api.Constants.ACCESS_TOKEN;
import static com.spotify.data.api.Constants.API_KEY;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class ApiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder().header(API_KEY, ACCESS_TOKEN)
            .method(original.method(), original.body()).build();
        return chain.proceed(request);
    }
}
