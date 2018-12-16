package com.blogspot.officialceo.recipe_j;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.blogspot.officialceo.recipe_j.Adapter.RecipeAdapter;
import com.blogspot.officialceo.recipe_j.Interface.ApiInterface;
import com.blogspot.officialceo.recipe_j.POJO.Recipe;
import com.blogspot.officialceo.recipe_j.auth.LoginActivity;
import com.blogspot.officialceo.recipe_j.client.ApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstActivity extends AppCompatActivity {

    List<Recipe> recipeList;

    @BindView(R.id.recipe_recyclerview)
    RecyclerView recyclerView;

    RecipeAdapter recipeAdapter;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recipeList = new ArrayList<>();
        //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recipeAdapter = new RecipeAdapter(getApplicationContext(), recipeList);
        recyclerView.setAdapter(recipeAdapter);


        loadRecipeData();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadRecipeData();

            }
        });

    }

    public void loadRecipeData() {


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Recipe>> call = apiInterface.getRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                final ProgressDialog progressDialog = new ProgressDialog(FirstActivity.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Fetching Data...");
                progressDialog.show();

                if (response.isSuccessful()) {

                    mSwipeRefreshLayout.setRefreshing(false);
                    progressDialog.dismiss();

                    recipeList = response.body();
                    Log.d("TAG", "Response == " + recipeList);
                    recipeAdapter.setRecipeList(recipeList);

                } else {

                    mSwipeRefreshLayout.setRefreshing(false);
                    progressDialog.dismiss();
                    Toast.makeText(FirstActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

                Log.d("TAG", "Response ==  " + t.toString());

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case  R.id.swiperefresh :

                mSwipeRefreshLayout.setRefreshing(true);

                loadRecipeData();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
