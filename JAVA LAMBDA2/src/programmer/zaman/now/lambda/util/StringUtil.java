package programmer.zaman.now.lambda.util;

public class StringUtil {
    public static boolean isLowerCase (String value){
        for (var chars : value.toCharArray()) {
            if (!Character.isLowerCase(chars)){
                return false;
            }
        }
        return true;
    }
}
