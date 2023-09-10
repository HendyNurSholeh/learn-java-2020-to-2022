package com.tutorial;

import kelasterbuka.util.Memasak;

public class Main {

    public static void main(String[] args) {
        // public, private, default, protected

        // karna dalam file yang sama maka dapat diakses
        Lain.methodPublic();

        // karena berbeda kelas maka tidak dapat diakses
        // Lain.methodPrivate

        // karena dalam package yang sama maka dapat diakses
        Lain.methodDefault();

        // karena dalam package yang sama maka dapat diakses
        Lain.methodProtected();


        //         MEMANGGIL DALAM PACKAGE BERBEDA
        Memasak.dagingPublic(); // bisa
        // Memasak.dagingPrivate // tidak bisa akarena berbeda kelas maupun package
        // Memasak.dagingdefault // tidak bisa karena berbeda package
        // Memasak.dagingprotected // tidak bisa karena berbeda package
    }
}
