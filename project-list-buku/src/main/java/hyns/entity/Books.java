package hyns.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class Books {

    private Integer id;
    @NotNull(message = "tahun tidak boleh kosong")
    @Range(min = 1000, max = 2022, message = "tahun harus antara {min} sampai {max}")
    private Integer tahun;
    @NotBlank(message = "judul tidak boleh kosong")
    private String judul;
    @NotBlank(message = "penulis tidak boleh kosong")
    private String penulis;
    @NotBlank(message = "penerbit tidak boleh kosong")
    private String penerbit;

    public Books() {
    }

    public Books(Integer tahun, String judul, String penulis, String penerbit) {
        this.tahun = tahun;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    public Books(Integer id, Integer tahun, String judul, String penulis, String penerbit) {
        this.id = id;
        this.tahun = tahun;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    public Integer getTahun() {
        return tahun;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
