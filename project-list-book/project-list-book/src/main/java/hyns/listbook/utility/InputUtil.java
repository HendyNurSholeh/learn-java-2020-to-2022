package hyns.listbook.utility;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputUser(String message){
        System.out.print(message + " : ");
        String inputUser = scanner.nextLine();
        return inputUser;
    }

    public static Boolean inputYesOrNo(String message){
        while (true){
            String yesOrNo = inputUser(message);
            if (yesOrNo.equalsIgnoreCase("y")){
                return true;
            }else if (yesOrNo.equalsIgnoreCase("n")){
                return false;
            }else {
                System.out.println("Input tidak dimengerti!!");
            }
        }
    }

    public static Integer inputTahun(String message) {
        while (true) {
            String tahun = InputUtil.inputUser(message);
            Integer tahunInt = ConvertUtil.stringToInteger(tahun, message);
            // tahun harus 4 digit
            if (tahunInt < 10000 && tahunInt > 999){
                return tahunInt;
            } else {
                log.info("Input Salah, Silahkan masukkan input sesuai format");
            }
        }
    }
}
