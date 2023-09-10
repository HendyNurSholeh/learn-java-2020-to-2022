package hyns.latihan;

import org.junit.jupiter.api.Test;

public class JumlahPendudukTest {

    @Test
    void testHitungJumlahPenduduk() {

        double jumlahPenduduk = 1; // dihari pertama 1 penduduk
        for (int i = 1; i <= 50 ; i++) {
            if (i % 3 == 0){
                // thanos muncul
                jumlahPenduduk = jumlahPenduduk / 2;
                jumlahPenduduk = Math.floor(jumlahPenduduk); // dibulatkan kebawah
            } else if (i != 1) {
                // dr strange muncul
                jumlahPenduduk = jumlahPenduduk * 3;
            }
        }

        System.out.println(jumlahPenduduk); // hasil akhir


    }
}
