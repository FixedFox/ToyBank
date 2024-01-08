public class Handler extends Thread {

    private int index;
    FrontSystem frontSystem;

    public Handler(int index, FrontSystem frontSystem) {
        this.index = index;
        this.frontSystem = frontSystem;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Request request = frontSystem.getRequest();
                if (request.getRequestType() == RequestType.PAYMENT) {
                    BackSystem.procssing(request);
                    System.out.println("Обработчик" + index + ": " + request.toString() + " обработана \n" +
                            "Текущий баланс банка:" + BackSystem.getBankBalance());
                } else {
                    if (BackSystem.getBankBalance() > request.getAmount()) {
                        BackSystem.procssing(request);
                        System.out.println("Обработчик" + index + ": " + request.toString() + " обработана \n" +
                                "Текущий баланс банка:" + BackSystem.getBankBalance());
                    } else {
                        System.out.println("Обработчик" + index + ": " + request.toString() + " не обработана");
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
