package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.Pair;

public class PairApp {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(20000, "Hendy otong");

        Integer integerPair = pair.getFirst();
        String stringPair = pair.getSecond();

        System.out.println(integerPair);
        System.out.println(stringPair);

    }
}
