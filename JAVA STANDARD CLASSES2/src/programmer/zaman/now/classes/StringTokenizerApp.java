package programmer.zaman.now.classes;

import java.util.StringTokenizer;

public class StringTokenizerApp {
    public static void main(String[] args) {

        String name = "Hendy Nur Sholeh";
        StringTokenizer token = new StringTokenizer(name," ");
        while (token.hasMoreTokens()){
            System.out.println(token.nextToken());
        }



    }
}
