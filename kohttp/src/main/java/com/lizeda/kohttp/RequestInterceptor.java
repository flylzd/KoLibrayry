package com.lizeda.kohttp;



public interface RequestInterceptor {
    void intercept(final KORequest request);
}