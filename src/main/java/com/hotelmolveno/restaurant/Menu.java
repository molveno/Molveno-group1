package com.hotelmolveno.restaurant;

import com.hotelmolveno.restaurant.Dish;
import com.hotelmolveno.restaurant.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public String menuList = "Menu list of dishes";

    public Menu() { //base constructor
    }
    public Menu(String getMenuList) { //setter
        this.menuList = getMenuList;
    }

    public String getMenuList() {//getter
        return menuList;
    }

    Menu newDish = new Dish();

    public Menu getNewDish() {
        return newDish;
    }

    public void setNewDish(Menu newDish) {
        this.newDish = newDish;
    }

}





//private List <Dish> menuList2 = new ArrayList<Dish>();
