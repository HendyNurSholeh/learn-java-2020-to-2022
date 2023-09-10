package programmer.zaman.now.application;

import programmer.zaman.now.data.LoginRequest;

public class RecordApp {
    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("Eko","Rahasia");
        System.out.println(loginRequest.userName());
        System.out.println(loginRequest.password());
        System.out.println(loginRequest);

        System.out.println(new LoginRequest());
        System.out.println(new LoginRequest("Eko"));
        System.out.println(new LoginRequest("Eko","Rahasia"));

    }
}
