package Thread;

public class MFD {

    private static Object printMONITOR = new Object();
    private static Object scanMONITOR = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    public void print(int pages){
        synchronized (printMONITOR) {
            for (int i = 0; i < pages; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Отпечатано " + i + " стр");
            }
        }
    }
    public void scan(int pages){
        synchronized (scanMONITOR) {
            for (int i = 0; i < pages; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Отсканировано " + i + " стр");
            }
        }
    }

}
