package com.journaldev.rxjavaretrofit.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.journaldev.rxjavaretrofit.data.api.CryptocurrencyService.BASE_URL;

public class ApiRetrofit {

    public ApiRetrofit(){

    }

    public static Retrofit retrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).client(client).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit;
    }


}
