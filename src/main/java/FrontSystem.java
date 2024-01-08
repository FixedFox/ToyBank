import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class FrontSystem {

    private Deque<Request> incomingRequest = new ArrayDeque<Request>();

    public synchronized void addRequest(Request request) {
        try {
            while (incomingRequest.size() > 2) {
                wait();
            }
            incomingRequest.add(request);
            System.out.println("Поступила заявка:" + request.toString());
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized Request getRequest() throws InterruptedException {
        try {
            while (incomingRequest.isEmpty()) {
                wait();
            }
            var a = incomingRequest.poll();
            notifyAll();
            return a;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
