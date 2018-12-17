package com.blogspot.officialceo.recipe_j;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lb.auto_fit_textview.AutoResizeTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.recipe_RatingTV)
    TextView recipe_rating;

    @BindView(R.id.recipe_ProteinTV)
    TextView recipe_protein;

    @BindView(R.id.recipe_HeadLineTV)
    TextView recipe_headline;

    @BindView(R.id.recipe_DescriptionTV)
    AutoResizeTextView recipe_description;

    @BindView(R.id.recipe_nameTV)
    TextView recipe_name;

    @BindView(R.id.recipe_imageView)
    ImageView recipe_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


        String recipeName = getIntent().getExtras().getString("recipeName");
        String recipeDescription = getIntent().getExtras().getString("recipeDescription");
        String recipeProtein = getIntent().getExtras().getString("recipeProtein");
        String recipeRating = getIntent().getExtras().getString("recipeRating");
        String recipeHeadline = getIntent().getExtras().getString("recipeHeadline");
        String recipeImage = getIntent().getExtras().getString("recipeImage");

        if (TextUtils.isEmpty(recipeProtein)){
            recipe_protein.setText("0");
        }else {

            recipe_protein.setText(recipeProtein);

        }if (TextUtils.isEmpty(recipeRating)){

            recipe_rating.setText("0");

        }else{

            recipe_rating.setText(recipeRating);

        }

        recipe_name.setText(recipeName);
        recipe_description.setText(recipeDescription);
        recipe_headline.setText(recipeHeadline);


        recipe_headline.setVisibility(View.VISIBLE);

        collapsingToolbarLayout.setTitle(recipeName);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));

        Glide.with(this).load(recipeImage).into(recipe_Image);



    }
}
