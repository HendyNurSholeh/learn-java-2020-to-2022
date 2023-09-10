package programmer.zaman.now.generic;

public class People implements Comparable<People> {
    private String data;
    private String address;

    public People(String data, String address) {
        this.data = data;
        this.address = address;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(People o) {
        return this.address.compareTo(o.address);
    }

    @Override
    public String toString() {
        return "People{" +
                "data='" + data + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
