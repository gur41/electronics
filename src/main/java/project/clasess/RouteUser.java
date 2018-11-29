package project.clasess;

public class RouteUser {
    private String start;
    private String end;
    private double mass;

    public RouteUser(String start, String end, double mass) {
        this.start = start;
        this.end = end;
        this.mass = mass;
    }

    public RouteUser() {
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

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
