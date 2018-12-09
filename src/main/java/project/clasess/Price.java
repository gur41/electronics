package project.clasess;

import java.util.zip.DeflaterOutputStream;

public class Price {
    private Integer idRoute;
    private Double price;
    private String nameOfRoute;
    private String description;

    public Price() {
    }

    public Price(Integer idRoute, Double price, String nameOfRoute, String description) {
        this.idRoute = idRoute;
        this.price = price;
        this.nameOfRoute = nameOfRoute;
        this.description = description;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameOfRoute() {
        return nameOfRoute;
    }

    public void setNameOfRoute(String nameOfRoute) {
        this.nameOfRoute = nameOfRoute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
