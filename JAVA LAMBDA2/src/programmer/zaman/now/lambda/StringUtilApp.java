package programmer.zaman.now.lambda;

import programmer.zaman.now.lambda.util.StringUtil;

import java.util.function.Predicate;

public class StringUtilApp {
    public static void main(String[] args) {
        StringUtilApp stringUtilApp = new StringUtilApp();
        stringUtilApp.run();
    }

    public void run(){
        StringUtilApp stringUtilApp = new StringUtilApp();
        Predicate<String> predicate = stringUtilApp::isLowerCase;
        System.out.println(predicate.test("hendy"));

    }

    public boolean isLowerCase(String value){
        for (var chars : value.toCharArray()) {
            if (!Character.isLowerCase(chars)){
                return false;
            }
        }
        return true;
    }
}
