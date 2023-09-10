package programmer.zaman.now.data;

public record LoginRequest(String userName, String password) {

    public LoginRequest{
        System.out.println("Membuat Objeck LoginRequest");
    }

    public LoginRequest(String userName){
        this(userName, "");
    }

    public LoginRequest(){
        this("","");
    }

}
