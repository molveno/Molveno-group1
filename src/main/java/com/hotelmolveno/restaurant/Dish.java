package com.hotelmolveno.restaurant;

public class Dish {

    public String menuList = "This is the menu list from dishes inheritant";

    public Dish(String menuList) {
        this.menuList = menuList;
    }

    public String getMenuList() {
        return menuList;
    }

    public void setMenuList(String menuList) {
        this.menuList = menuList;
    }
}
