package com.example.testofflinemovie.Respositories

import com.example.testofflinemovie.common.ApiConstants
import okhttp3.Interceptor
import okhttp3.Response

class ResquestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        var originalUrl = originalRequest.url()
        var newUrl = originalUrl.newBuilder()
            .addQueryParameter("api_key", ApiConstants.TMDB_API_KE)
            .addQueryParameter("language", "es-Es")
            .addQueryParameter("page", "1").build()
        var request = originalRequest.newBuilder().url(newUrl).build()
        return chain.proceed(request)
    }
}