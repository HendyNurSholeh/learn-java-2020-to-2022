package com.tutorial;

import java.util.Locale;
import java.util.Scanner;

public class TokoJaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isMember = false;
        System.out.print("Apakah anda member :");
        String member = scanner.nextLine();
        member.toUpperCase();
        System.out.println(member);
        switch (member.toLowerCase(Locale.ROOT)){
            case "ya" -> isMember = true;
        }



    }
}
