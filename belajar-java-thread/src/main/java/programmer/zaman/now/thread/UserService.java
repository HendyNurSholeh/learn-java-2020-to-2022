package programmer.zaman.now.thread;

public class UserService {

    final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(String value){
        threadLocal.set(value);
    }

    public String doAction() {
        String user = threadLocal.get();
        return user;
    }
}
