package hyns.soal1;

import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        // buat daftar nilai
        Nilai[] daftarNilai = new Nilai[3];

        // membuat siswa baru
        Siswa siswaBaru = new Siswa();
        Nilai nilai = new Nilai();
        nilai.setMapel("inggris");
        nilai.setNilai(100);
        daftarNilai[0] = nilai;
        siswaBaru.setDaftarNilai(nilai);

        //generate 10 siswa
        Siswa[] siswa = new Siswa[10];
        Random randomInt = new Random();
        for (int i = 0; i < 10; i++) {
            String randomNama = UUID.randomUUID().toString().substring(0, 10); // random nama 10 karakter
            siswa[i] = new Siswa();
            siswa[i].setNama(randomNama);
            int random0Sampai2 = randomInt.nextInt(3);
            // random mapel
            Nilai nilaiSiswa = new Nilai();
            if (random0Sampai2 == 0){
                nilaiSiswa.setMapel("inggris");
            } else if (random0Sampai2 == 1) {
                nilaiSiswa.setMapel("indonesia");
            } else if (random0Sampai2 == 2) {
                nilaiSiswa.setMapel("jepang");
            }
            int random0Sampai100 = randomInt.nextInt(101); // random nilai dari 0-100
            nilaiSiswa.setNilai(random0Sampai100);
            siswa[i].setDaftarNilai(nilaiSiswa);
        }



    }
}
