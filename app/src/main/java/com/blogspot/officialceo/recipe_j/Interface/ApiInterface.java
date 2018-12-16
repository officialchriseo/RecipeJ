package com.blogspot.officialceo.recipe_j.Interface;

import com.blogspot.officialceo.recipe_j.POJO.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("Recipe.json")
    Call<List<Recipe>> getRecipes();

}
