package com.tutorial;

// inheritance adalah hubungan is-a
public class Main {
    
    public static void main(String[] args) {
        Hero hero1 = new Hero();
        hero1.name = "ucup";
        hero1.Display();

        HeroStrength hero2 = new HeroStrength();
        hero2.name = "otong";
        hero2.Display();

        HeroIntelligent hero3 = new HeroIntelligent();
        hero3.name = "Michael";
        hero3.Display();
    }

}
