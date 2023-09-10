package hyns.latihan;

public class Karung {
    private Integer berat;
    private Integer hargaBeli;
    private Integer hargaJual;
    public Karung(Integer berat, Integer hargaBeli, Integer hargaJual) {
        this.berat = berat;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
    }
    public Integer getBerat() {
        return berat;
    }
    public Integer getHargaBeli() {
        return hargaBeli;
    }
    public Integer getHargaJual() {
        return hargaJual;
    }


}
