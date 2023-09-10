package programmer.zaman.now.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class Address {

    public Address() {
    }

    public Address(String province, String districs, String street) {
        this.province = province;
        this.districs = districs;
        this.street = street;
    }

    @NotBlank(message = "provinsi tidak boleh blank bro")
    String province;

    @NotEmpty(message = "kecamatan tidak boleh kosong bro")
    String districs;

    @NotEmpty(message = "jalan tidak boleh kosong bro")
    String street;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrics() {
        return districs;
    }

    public void setDistrics(String districs) {
        this.districs = districs;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", districs='" + districs + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
