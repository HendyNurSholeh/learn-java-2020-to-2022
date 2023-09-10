package com.tutorial;

public class Hero{
    // attribute
    String name;
    double attackPower, health;

    // constructor
    Hero(String name, double healthInput, double attackInput){
        this.name = name;
        this.attackPower = attackInput;
        this.health = healthInput;
    }

    // method attack
    void attack(Hero enemy){
        System.out.println("\n"+ this.name +" attack "+enemy.name);
        enemy.takeDamage(this.attackPower);
    }

    void takeDamage(double damage){
        System.out.println(this.name+" receive 100% damage "+ damage+" -> "+damage*1);
        this.health = this.health - damage*1;
    }

    void display(){
        System.out.println("\nName \t: "+this.name);
        System.out.println("Health\t: "+this.health);
        System.out.println("Power\t: "+this.attackPower);
    }
}
