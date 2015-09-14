package com.lizeda.kohttp;

import com.squareup.okhttp.OkHttpClient;

public interface OkClientInterceptor {

    void intercept(OkHttpClient client);
}
