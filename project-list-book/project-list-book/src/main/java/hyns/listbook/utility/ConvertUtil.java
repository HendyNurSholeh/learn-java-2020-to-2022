package hyns.listbook.utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertUtil {

    public static Integer stringToInteger(String string, String message){
        Integer integer;
        while (true) {
            try {
                integer = Integer.valueOf(string);
                break;
            } catch (NumberFormatException e) {
                log.warn("Input Salah, Silahkan masukkan input sesuai format");
                string = InputUtil.inputUser(message);
            }
        }
        return integer;
    }

    public static Integer stringToInteger(String stringValue, String message, String except){
        Integer integerValue;
        while (true) {
            try {
                if (stringValue.equalsIgnoreCase(except)){
                    return null;
                }else {
                    integerValue = Integer.valueOf(stringValue);
                    break;
                }
            } catch (NumberFormatException e) {
                log.warn("Input Salah, Silahkan masukkan input sesuai format");
                stringValue = InputUtil.inputUser(message);
            }
        }
        return integerValue;
    }
}
