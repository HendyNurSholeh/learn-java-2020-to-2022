package com.tutorial;

public class HeroStrength extends Hero{
    String type = "Strength";
    // constructor
    HeroStrength(String name, double healthInput, double attackInput){
        super(name, healthInput, attackInput);
    }

    @Override
    void display(){
        super.display();
        System.out.println("Type \t: "+this.type);
    }

    @Override
    void takeDamage(double damage){
        System.out.println(this.name+" receive 50% damage "+ damage+" -> "+0.5*damage);
        this.health = this.health - 0.5*damage;
    }



}
