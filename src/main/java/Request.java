public class Request {
    private String clientThreadName;
    private int amount;
    private RequestType requestType;

    public Request(String clientThreadName, int amount, RequestType requestType) {
        this.clientThreadName = "Клиент №" + clientThreadName;
        this.amount = amount;
        this.requestType = requestType;
    }

    public String getClientThreadName() {
        return clientThreadName;
    }

    public int getAmount() {
        return amount;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public String toString() {
        return "Заявка{" +
                clientThreadName + '\'' +
                ", сумма=" + amount +
                ", тип запроса=" + requestType +
                '}';
    }
}