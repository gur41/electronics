package project.clasess;

public class MapsCarrier {
    private String startPointName;
    private String endPointName;
    private String nameOfTransport;
    private Integer speed;
    private Double coefficient;
    private Integer maxWeight;
    private Double distance;
    private Double costForHour;

    public MapsCarrier(String startPointName, String endPointName, String nameOfTransport, Integer speed, Double coefficient, Integer maxWeight, Double distance, Double costForHour) {
        this.startPointName = startPointName;
        this.endPointName = endPointName;
        this.nameOfTransport = nameOfTransport;
        this.speed = speed;
        this.coefficient = coefficient;
        this.maxWeight = maxWeight;
        this.distance = distance;
        this.costForHour = costForHour;
    }

    public MapsCarrier() {
    }

    public String getStartPointName() {
        return startPointName;
    }

    public void setStartPointName(String startPointName) {
        this.startPointName = startPointName;
    }

    public String getEndPointName() {
        return endPointName;
    }

    public void setEndPointName(String endPointName) {
        this.endPointName = endPointName;
    }

    public String getNameOfTransport() {
        return nameOfTransport;
    }

    public void setNameOfTransport(String nameOfTransport) {
        this.nameOfTransport = nameOfTransport;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getCostForHour() {
        return costForHour;
    }

    public void setCostForHour(Double costForHour) {
        this.costForHour = costForHour;
    }
}
