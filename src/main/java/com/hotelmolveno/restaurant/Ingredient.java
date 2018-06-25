package com.hotelmolveno.restaurant;

public class Ingredient extends Dish {

    String ingredient1 = "Pizza magarita";

    public Ingredient() { //base constructer
        super();
    }

    public String getIngredient1() { //getter
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) { //setter
        this.ingredient1 = ingredient1;
    }


}
