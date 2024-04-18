package ATM;

public class ATM {
    private int moneyATM;

    public ATM(int moneyATM) {
        this.moneyATM = moneyATM;
    }

    public synchronized void getMoney(String nameCustomer, int moneyCustomer) {
        System.out.println(nameCustomer + " подошел к банкомату");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (moneyCustomer <= this.moneyATM) {
            this.moneyATM -= moneyCustomer;
            System.out.println(nameCustomer+" вывел "+moneyCustomer+" рублей. В банкомате осталось "+this.moneyATM+" рублей");
        }else {
            System.out.println("В банкомате недостаточно денег для "+nameCustomer);
        }
    }
}
