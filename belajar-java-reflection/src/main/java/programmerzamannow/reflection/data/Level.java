package programmerzamannow.reflection.data;

public enum Level {
    VIP("mahal"),
    PREMINUM("biasa"),
    BASIC("murah");

    private String harga;

    Level(String harga) {
        this.harga = harga;
    }

    public String getHarga() {
        return harga;
    }
}
