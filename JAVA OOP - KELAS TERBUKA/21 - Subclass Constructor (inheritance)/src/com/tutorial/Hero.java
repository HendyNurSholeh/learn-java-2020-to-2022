package com.tutorial;

public class Hero{
    // attribute
    String name;
    double defancePower;

    // constructor
    Hero(String name,double defancePower){
        this.name = name;
        this.defancePower = defancePower;
    }

    Hero(String name){
        this.name = name;
    }

    // method
    void display(){
        System.out.println("Name = "+ this.name);
    }
}
