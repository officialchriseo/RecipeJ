package com.blogspot.officialceo.recipe_j.POJO;

import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("name")
    private String name;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("description")
    private String description;

    @SerializedName("proteins")
    private String proteins;

    @SerializedName("headline")
    private String headline;

    @SerializedName("rating")
    private String rating;



    public  Recipe(String name, String thumb, String description, String proteins, String headline, String rating){
        this.name = name;
        this.thumb = thumb;
        this.description = description;
        this.proteins = proteins;
        this.headline = headline;
        this.rating = rating;
    }


    public String getName(){
        return name;
    }

    public String getThumb(){
        return thumb;
    }

    public String getDescription(){
        return description;
    }

    public String getProteins(){
        return proteins;
    }

    public String getHeadline(){
        return headline;
    }

    public String getRating(){
        return  rating;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setThumb(String thumb){
        this.thumb = thumb;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setProteins(String proteins){
        this.proteins = proteins;
    }

    public void setHeadline(String headline){
        this.headline = headline;
    }

    public  void setRating(String rating){
        this.rating = rating;
    }
}
