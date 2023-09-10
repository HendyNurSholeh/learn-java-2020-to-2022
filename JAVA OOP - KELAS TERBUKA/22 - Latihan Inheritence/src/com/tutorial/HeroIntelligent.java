package com.tutorial;

public class HeroIntelligent extends Hero{
    // constructor
    HeroIntelligent(String name,double healthInput, double attackInput){
        super(name, healthInput, attackInput);
    }

    @Override
    void takeDamage(double damage){
        System.out.println(this.name+" receive 150% damage "+ damage+" -> "+damage*1.5);
        this.health = this.health - damage*1.5;
    }

}
