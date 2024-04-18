package ATM;

public class Main {
    private static Object monitor = new Object();

    public static void main(String[] args) {
        ATM atm = new ATM(7000);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {


                    atm.getMoney("John", 5000);


            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                    atm.getMoney("Sean", 5000);


            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                    atm.getMoney("Dick", 5000);

            }

        });
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
