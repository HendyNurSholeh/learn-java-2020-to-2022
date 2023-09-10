package com.tutorial;
// visibility
// 1. public : JIka method atau attribute dalam public secara explisit,
//    maka subclass tidak boleh mengurangi visibility
// 2. private : Jika method atau attribute dalam private secara explisit,
//    maka subclass pun tidak dapat mengakses
public class Main {
    
    public static void main(String[] args) {
        System.out.println("test");

        Hero hero1 = new Hero ("Ucup", 100);
        IntelHero hero2 = new IntelHero("otong", 50);

        hero1.display();
        hero2.display();

        System.out.println(hero1.getHealth());
        System.out.println(hero2.getHealth());

        hero1.setHealth(120);
        hero2.setHealth(80);

        System.out.println(hero1.getHealth());
        System.out.println(hero2.getHealth());

    }

}
