package project.clasess;

public class RouteCarrier {
    private String start;
    private String end;
    private int quantity;

    public RouteCarrier(String start, String end, int quantity) {
        this.start = start;
        this.end = end;
        this.quantity = quantity;
    }

    public RouteCarrier() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
