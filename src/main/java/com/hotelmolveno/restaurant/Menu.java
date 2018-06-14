package com.hotelmolveno.restaurant;

import com.hotelmolveno.restaurant.Dish;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public String menuList = "Menu list of dishes";

    private List <Dish> menuList2 = new ArrayList<Dish>();

    public Menu(String menuList) {
        this.menuList = menuList;
    }

    public String getMenuList() {
        return menuList;
    }

    public void setMenuList(String menuList) {
        this.menuList = menuList;
    }
}
