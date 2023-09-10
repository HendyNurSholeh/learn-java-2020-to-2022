package kelasterbuka.util;

public class Memasak {

    public  static void dagingPublic(){
        System.out.println("kelasterbuka: Memasak: public");
    }
    private  static void dagingPrivate(){
        System.out.println("kelasterbuka: Memasak: private");
    }
    static void dagingDefault(){
        System.out.println("kelasterbuka: Memasak: default");
    }
    protected static void dagingprotected(){
        System.out.println("kelasterbuka: Memasak: protected");
    }
}
