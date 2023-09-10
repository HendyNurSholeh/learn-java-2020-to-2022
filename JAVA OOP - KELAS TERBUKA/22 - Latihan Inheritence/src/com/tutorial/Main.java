package com.tutorial;

public class Main {
    
    public static void main(String[] args) {
        Hero hero1 = new Hero("Tanjiro", 100, 10);
        HeroStrength hero2 = new HeroStrength("Zenitsu", 100, 20);
        HeroIntelligent hero3 = new HeroIntelligent("Otong", 100, 2);

        hero1.display();
        hero2.display();
        hero3.display();

        hero1.attack(hero2);
        hero2.attack(hero1);
        hero1.attack(hero3);

        hero1.display();
        hero2.display();
        hero3.display();
    }
}
