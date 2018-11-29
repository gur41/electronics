package project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "points", schema = "logistics", catalog = "")
public class Points {

    public Points() {
    }

    public Points(Integer idPoint, String nameOfPoint) {
        this.idPoint = idPoint;
        this.nameOfPoint = nameOfPoint;
    }

    public Points(String nameOfPoint) {
        this.nameOfPoint = nameOfPoint;
    }

    @Id
    @Column(name = "id_point", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPoint;
    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    @Basic
    @Column(name = "name_of_point", nullable = true, length = 255)
    private String nameOfPoint;
    public String getNameOfPoint() {
        return nameOfPoint;
    }

    public void setNameOfPoint(String nameOfPoint) {
        this.nameOfPoint = nameOfPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Points points = (Points) o;

        if (idPoint != null ? !idPoint.equals(points.idPoint) : points.idPoint != null) return false;
        if (nameOfPoint != null ? !nameOfPoint.equals(points.nameOfPoint) : points.nameOfPoint != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPoint != null ? idPoint.hashCode() : 0;
        result = 31 * result + (nameOfPoint != null ? nameOfPoint.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "pointsByStartPoint")
    private List<Maps> mapsByIdPoint = new ArrayList<Maps>();
    public ArrayList<Maps> getMapsByIdPoint() {
        return (ArrayList<Maps>)mapsByIdPoint;
    }

    public void setMapsByIdPoint(ArrayList<Maps> mapsByIdPoint) {
        this.mapsByIdPoint = mapsByIdPoint;
    }

    @OneToMany(mappedBy = "pointsByEndPoint")
    private List<Maps> mapsByIdPoint_0 = new ArrayList<Maps>();
    public ArrayList<Maps> getMapsByIdPoint_0() {
        return (ArrayList<Maps>) mapsByIdPoint_0;
    }

    public void setMapsByIdPoint_0(ArrayList<Maps> mapsByIdPoint_0) {
        this.mapsByIdPoint_0 = mapsByIdPoint_0;
    }

    @OneToMany(mappedBy = "pointsByStartPointsOfRoute")
    private List<Route> routesByIdPoint = new ArrayList<Route>();
    public ArrayList<Route> getRoutesByIdPoint() {
        return (ArrayList <Route>) routesByIdPoint;
    }

    public void setRoutesByIdPoint(ArrayList<Route> routesByIdPoint) {
        this.routesByIdPoint = routesByIdPoint;
    }

    @OneToMany(mappedBy = "pointsByEndPointOfRoute")
    private List<Route> routesByIdPoint_0;
    public ArrayList<Route> getRoutesByIdPoint_0() {
        return (ArrayList<Route>) routesByIdPoint_0;
    }

    public void setRoutesByIdPoint_0(ArrayList<Route> routesByIdPoint_0) {
        this.routesByIdPoint_0 = routesByIdPoint_0;
    }*/
}
