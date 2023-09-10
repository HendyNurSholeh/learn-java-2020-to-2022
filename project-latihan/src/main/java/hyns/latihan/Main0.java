package hyns.latihan;

public class Main0 {
    public static void main(String[] args) {
    }
    public Integer hitungKeuntungan(Karung karung){
        Integer result = karung.getBerat() * karung.getHargaJual() - karung.getHargaBeli();
        return result;
    }
    public void view(){
        Karung karung1 = new Karung(40, 350_000, 9000);
        Karung karung2 = new Karung(20, 195_000, 9000);
        Karung karung3 = new Karung(50, 400_000, 9000);
        Integer keuntunganKarung1 = hitungKeuntungan(karung1);
        Integer keuntunganKarung2 = hitungKeuntungan(karung2);
        Integer keuntunganKarung3 = hitungKeuntungan(karung3);
        System.out.println("Karung Pertama :");
        System.out.println("Berat : " + karung1.getHargaBeli() + "kg");
        System.out.println("Harga Beli : Rp" + karung1.getHargaBeli());
        System.out.println("Rencana Harga Jual/kg : Rp" + karung1.getHargaJual());
        System.out.println("Result : Rp" + keuntunganKarung1);
    }
}
