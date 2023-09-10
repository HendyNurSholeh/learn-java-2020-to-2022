package programmer.zaman.now.thread;

public class DaemonApp {
    public static void main(String[] args){
        var thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Berjalan di Thread");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("program berhenti");
    }
}
