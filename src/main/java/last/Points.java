package last;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Points {
    private Integer idPoint;
    private String nameOfPoint;
    private Collection<Maps> mapsByIdPoint;
    private Collection<Maps> mapsByIdPoint_0;
    private Collection<Route> routesByIdPoint;
    private Collection<Route> routesByIdPoint_0;

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
    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    @Basic
    @Column(name = "name_of_point", nullable = true, length = 255)
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

    @OneToMany(mappedBy = "pointsByStartPointId")
    public Collection<Maps> getMapsByIdPoint() {
        return mapsByIdPoint;
    }

    public void setMapsByIdPoint(Collection<Maps> mapsByIdPoint) {
        this.mapsByIdPoint = mapsByIdPoint;
    }

    @OneToMany(mappedBy = "pointsByEndPointId")
    public Collection<Maps> getMapsByIdPoint_0() {
        return mapsByIdPoint_0;
    }

    public void setMapsByIdPoint_0(Collection<Maps> mapsByIdPoint_0) {
        this.mapsByIdPoint_0 = mapsByIdPoint_0;
    }

    @OneToMany(mappedBy = "pointsByStartPointOfRoute")
    public Collection<Route> getRoutesByIdPoint() {
        return routesByIdPoint;
    }

    public void setRoutesByIdPoint(Collection<Route> routesByIdPoint) {
        this.routesByIdPoint = routesByIdPoint;
    }

    @OneToMany(mappedBy = "pointsByEndPointOfRoute")
    public Collection<Route> getRoutesByIdPoint_0() {
        return routesByIdPoint_0;
    }

    public void setRoutesByIdPoint_0(Collection<Route> routesByIdPoint_0) {
        this.routesByIdPoint_0 = routesByIdPoint_0;
    }
}
