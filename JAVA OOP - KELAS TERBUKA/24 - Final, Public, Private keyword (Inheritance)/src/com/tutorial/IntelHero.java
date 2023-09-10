package com.tutorial;

// public ini akan terbuka untuk semua
public class IntelHero extends Hero{

    IntelHero(String name,double health){
        super(name, health);
        // System.out.println(this.health); tidak bisa diakses karena private 
    }

    // visibility harus sama dengan super class
    public void display(){
        System.out.println(this.name + " mempunyai "+this.getHealth());
    }

}
