public class MainClass {
    public static void main(String[] args) {
        System.out.println("--------------------Игрушечный банк--------------------");
        var frontSystem = new FrontSystem();

        var handler1 = new Handler(1,frontSystem);
        var handler2 = new Handler(2,frontSystem);
        handler1.start();
        handler2.start();

        var client1 = new Client(frontSystem,
                new Request("1",
                        10_000,
                        RequestType.CREDIT));

        var client2 = new Client(frontSystem,
                new Request("2",
                        15_000,
                        RequestType.PAYMENT));

        var client3 = new Client(frontSystem,
                new Request("3",
                        35_000,
                        RequestType.PAYMENT));

        var client4 = new Client(frontSystem,
                new Request("4",
                        7_000,
                        RequestType.CREDIT));

        var client5 = new Client(frontSystem,
                new Request("5",
                        2_000,
                        RequestType.CREDIT));

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

    }
}
