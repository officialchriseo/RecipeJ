package com.blogspot.officialceo.recipe_j;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.blogspot.officialceo.recipe_j.Adapter.RecipeAdapter;
import com.blogspot.officialceo.recipe_j.Interface.ApiInterface;
import com.blogspot.officialceo.recipe_j.POJO.Recipe;
import com.blogspot.officialceo.recipe_j.client.ApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    List<Recipe> recipeList;

    @BindView(R.id.recipe_recyclerview)
    RecyclerView recyclerView;

    RecipeAdapter recipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }




    }



