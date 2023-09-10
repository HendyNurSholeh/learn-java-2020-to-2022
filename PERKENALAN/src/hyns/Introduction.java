package hyns;

public class Introduction {
    public static void main(String[] args) throws InterruptedException {
        String name = """
                HENDY NUR SHOLEH\nTEKNOLOGI INFORMASI 1C
                """;
        char[] arrayNames = name.toCharArray();
        Thread.sleep(3000);
        System.out.println("\n------SUCCESSFUL-------\n");
        Thread.sleep(1000);
        for (int i = 0; i < arrayNames.length; i++) {
        Thread.sleep(100);
        System.out.print(arrayNames[i]);
        }
        }
        }
