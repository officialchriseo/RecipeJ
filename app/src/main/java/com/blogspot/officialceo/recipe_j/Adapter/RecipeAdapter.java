package com.blogspot.officialceo.recipe_j.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.officialceo.recipe_j.DetailsActivity;
import com.blogspot.officialceo.recipe_j.POJO.Recipe;
import com.blogspot.officialceo.recipe_j.R;
import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private Context context;

    public RecipeAdapter(Context context, List<Recipe> recipeList){
        this.recipeList = recipeList;
        this.context = context;
    }

    public void setRecipeList(List<Recipe> recipeList){

        this.recipeList = recipeList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_item, viewGroup, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeAdapter.RecipeViewHolder recipeViewHolder, int i) {

        final Recipe recipe = recipeList.get(i);

        recipeViewHolder.recipeDescription.setText(recipe.getDescription());
        recipeViewHolder.recipeProtein.setText(recipe.getProteins());
        recipeViewHolder.recipeRating.setText(recipe.getRating());
        recipeViewHolder.recipeName.setText(recipe.getName());
        recipeViewHolder.recipeHeadline.setText(recipe.getHeadline());

        Glide.with(context).load(recipe.getThumb()).into(recipeViewHolder.recipeImage);

        recipeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context.getApplicationContext(), DetailsActivity.class);
                myIntent.putExtra("recipeDescription", recipe.getDescription());
                myIntent.putExtra("recipeProtein", recipe.getProteins());
                myIntent.putExtra("recipeRating", recipe.getRating());
                myIntent.putExtra("recipeName", recipe.getName());
                myIntent.putExtra("recipeHeadline", recipe.getHeadline());
                myIntent.putExtra("recipeImage", recipe.getThumb());
                context.startActivity(myIntent);

                Toast.makeText(context, "Item at" + recipe, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (recipeList != null){
        return recipeList.size();
        }
        return 0;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{

        TextView recipeName;
        TextView recipeDescription;
        TextView recipeHeadline;
        TextView recipeProtein;
        ImageView recipeImage;
        TextView recipeRating;
        LikeButton likeButton;

//        @BindView(R.id.recipe_nameTV)
//        TextView recipeName;
//        @BindView(R.id.recipe_DescriptionTV)
//        TextView recipeDescription;
//        @BindView(R.id.recipe_HeadLineTV)
//        TextView recipeHeadline;
//        @BindView(R.id.recipe_ProteinTV)
//        TextView recipeProtein;
//        @BindView(R.id.recipe_imageView)
//        ImageView recipeImage;
//        @BindView(R.id.recipe_RatingTV)
//        TextView recipeRating;

        public RecipeViewHolder(@NonNull final View itemView) {
            super(itemView);

             recipeName = itemView.findViewById(R.id.recipe_name);
             recipeDescription = itemView.findViewById(R.id.recipe_description);
            recipeHeadline = itemView.findViewById(R.id.recipe_headline);
             recipeProtein = itemView.findViewById(R.id.recipe_protein);
            recipeImage = itemView.findViewById(R.id.recipe_Image);
            recipeRating = itemView.findViewById(R.id.recipe_rating);
            likeButton = itemView.findViewById(R.id.star_button);

            likeButton.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {

                    @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = context.getSharedPreferences("com.blogspot.officialceo.recipe_j.Adapter", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("buttonLiked", true);
                    editor.apply();

                }

                @Override
                public void unLiked(LikeButton likeButton) {

                    @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = context.getSharedPreferences("com.blogspot.officialceo.recipe_j.Adapter", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("buttonUnliked", true);
                    editor.apply();

                }
            });



        }
    }

}
