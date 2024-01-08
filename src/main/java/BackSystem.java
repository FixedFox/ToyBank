public class BackSystem {
    private static volatile int bankBalance;

    public static int getBankBalance() {
        return bankBalance;
    }

    public static synchronized void procssing(Request request) {
        if (request.getRequestType() == RequestType.CREDIT){
            bankBalance -= request.getAmount();
        }
        else {
            bankBalance += request.getAmount();
        }

    }
}
