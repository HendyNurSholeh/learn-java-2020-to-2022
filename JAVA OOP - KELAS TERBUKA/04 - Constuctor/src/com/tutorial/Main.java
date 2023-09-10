package com.tutorial;

// class tanpa constructor / class polos
class Polos{
    String dataString;
    int dataInteger;
}

// class dengan constructor
class Mahasiswa{
    String nama;
    String NIM;
    String jurusan;

    // Mahasiswa(){
    //     // constructor dipanggil saat object pertama kali dibuat
    //     System.out.println("ini adalah constructor");
    // }

    // constructor dengan parameter
    Mahasiswa(String inputNama, String inputNIM, String inputJurusan){
        nama = inputNama;
        NIM = inputNIM;
        jurusan = inputJurusan;

        System.out.println(nama);
        System.out.println(NIM);
        System.out.println(jurusan);
        
    }
} 

public class Main {
    
    public static void main(String[] args) {
        

        Mahasiswa mahasiswa1 = new Mahasiswa("ucup","13305041","teknik perteknikan");
        Mahasiswa mahasiswa2 = new Mahasiswa("otong","13305042","teknik pertambangan");

    

        // Polos objectPolos = new Polos();
        // objectPolos.dataString = "Polos";
        // objectPolos.dataInteger = 0;

        // System.out.println(objectPolos.dataString);
        // System.out.println(objectPolos.dataInteger);

    }

}
