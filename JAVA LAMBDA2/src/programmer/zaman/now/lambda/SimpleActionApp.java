package programmer.zaman.now.lambda;

import programmer.zaman.now.lambda.data.SimpleAction;

public class SimpleActionApp {
    public static void main(String[] args) {
        SimpleAction simpleAction = name -> "Apa kabar " + name;
        System.out.println(simpleAction.action("hendy"));
    }

}
