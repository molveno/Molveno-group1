package com.hotelmolveno.controller;

import org.aspectj.lang.annotation.Before;

public class SimpleCalculator {
    int a = 0;
    int b = 0;

    public int subtract(int x, int y){
        int c = x-y;
        return c;
    }

    public int multiply(int x, int y){
        int c = x*y;
        return c;
    }

    public int devide(int x, int y){
        int c = x/y;
        return c;
    }
}
