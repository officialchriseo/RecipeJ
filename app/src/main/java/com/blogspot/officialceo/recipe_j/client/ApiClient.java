package com.blogspot.officialceo.recipe_j.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static  String BASE_URL = "https://raw.githubusercontent.com/Nsikaktopdown/Recipe/master/";
    private static Retrofit retrofit;


    public static  Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}
