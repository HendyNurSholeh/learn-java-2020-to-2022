package programmer.zaman.now.data;

public class LokationApp {
    public static void main(String[] args) {
        // kegunaan abrack class yaitu kita hanya bisa mengakses
        // class childnya tp tdk bs parentnya
        // var location = new Lokation(); // EROR
        var city = new City();
        city.name ="Jakarta";
        System.out.println(city.name);
    }
}
