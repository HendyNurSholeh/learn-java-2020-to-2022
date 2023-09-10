package com.tutorial;

// player
class Player{
    String name;
    double health;
    int level;
    // object member
    Weapon weapon;
    Armor armor;

    Player(String name, double health){
        this.name = name;
        this.health = health;
    }

    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name + " attacking "+opponent.name+" with power "+attackPower);
        opponent.defance(attackPower);
    }

    void defance(double attackPower){
        // akan mengambil damagenya
        double damage;
        if (this.armor.defancePower < attackPower) {
            damage = attackPower - this.armor.defancePower;;
        }else{
            damage = 0;
        }

        this.health -= damage;
        System.out.println(this.name + " gets damage "+damage);
    }

    void equipWeapon (Weapon weapon){
        this.weapon = weapon;
    }
    void equipArmor (Armor armor){
        this.armor = armor;
    }

    void display(){
        System.out.println("\nName : "+ this.name);
        System.out.println("Health : "+ this.health + " hp");
        this.weapon.display();
        this.armor.display();
    }

}
// senjata
class Weapon{
    double attackPower;
    String name;


    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }

    void display(){
        System.out.println("Weapon : "+ this.name +" , attack : "+ this.attackPower);
    }


}
// armor
class Armor{
    double defancePower;
    String name;
    Armor(String name, double defancePower){
        this.name = name;
        this.defancePower = defancePower;
    }

    void display(){
        System.out.println("Armor : "+ this.name +" , defance : "+ this.defancePower);
    }
    
}

public class Main {
    
    public static void main(String[] args) {

        // membuat object player
        Player player1 = new Player("ucup", 100);
        Player player2 = new Player("Otong", 50);

        // membuat object weapon
        Weapon pedang = new Weapon("pedang",15);
        Weapon ketapel = new Weapon("ketapel", 1);

        // membuat object armor
        Armor bajuBesi = new Armor("baju besi",10);
        Armor kaos = new Armor("kaos",1);

        // player 1
        player1.equipWeapon(pedang);
        player1.equipArmor(bajuBesi);
        player1.display();

        // player 2
        player2.equipWeapon(ketapel);
        player2.equipArmor(kaos);
        player2.display();

        System.out.println("\nPERTEMPURAAAN");
        System.out.println("\nEpisode 1\n");
        player1.attack(player2);
        player1.display();
        player2.display();
        System.out.println("\nEpisode 2\n");
        player2.attack(player1);
        player1.display();
        player2.display();

    }

}
