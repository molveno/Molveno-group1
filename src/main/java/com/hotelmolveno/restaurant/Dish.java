package com.hotelmolveno.restaurant;

import com.hotelmolveno.restaurant.Ingredient;

public class Dish extends Menu {

    public String menuList = "This is the menu list from dishes inheritant";

    public Dish() { //base construtor
        super();
    }
    public Dish(int i) { //base2 constructer
    }
    public Dish(String menuList) { //second constructer
        this.menuList = menuList;
    }


    public String getMenuList() { //getter
        return menuList;
    }

    public void setMenuList(String menuList) { //setter
        this.menuList = menuList;
    }

}
