public class Client extends Thread{

    private Request request;
    private FrontSystem frontSystem;

    public Client(FrontSystem frontSystem, Request request) {
        this.request = request;
        this.frontSystem = frontSystem;
    }

    @Override
    public void run() {
        frontSystem.addRequest(request);
    }
}
