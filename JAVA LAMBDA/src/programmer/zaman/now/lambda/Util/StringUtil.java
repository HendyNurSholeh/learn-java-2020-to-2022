package programmer.zaman.now.lambda.Util;

public class StringUtil {

    public static boolean isLowerCase(String value){
        for (var c : value.toCharArray()){
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
