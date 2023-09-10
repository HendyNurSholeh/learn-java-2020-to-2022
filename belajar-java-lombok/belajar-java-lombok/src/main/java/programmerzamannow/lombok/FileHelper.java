package programmerzamannow.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Slf4j
public class FileHelper {

    @SneakyThrows
    public static String loadFile(String file){
        log.info("load file {}", file);
        @Cleanup
        var fileReader = new FileReader(file);
        @Cleanup
        var scanner = new Scanner(fileReader);

        var builder = new StringBuilder();
        while (scanner.hasNextLine()){
            builder.append(scanner.nextLine()).append("\n");
        }

        return builder.toString();
    }
}
