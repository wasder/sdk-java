package io.visual_regression_tracker.sdk_java;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BasicAuthInterceptor implements Interceptor {
    protected String credentials;

    public BasicAuthInterceptor(String login, String pass) {
        credentials = Credentials.basic(login, pass);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder().header("Authorization", credentials);
        return chain.proceed(builder.build());
    }
}
