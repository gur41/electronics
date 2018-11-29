package project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "route", schema = "logistics", catalog = "")
public class Route {
    private Integer idRoute;
    private String nameOfRoute;
    private Integer startPointOfRoute;
    private Integer endPointOfRoute;

    public Route() {
    }

    @Id
    @Column(name = "id_route", nullable = false)
    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    @Basic
    @Column(name = "name_of_route", nullable = true, length = 255)
    public String getNameOfRoute() {
        return nameOfRoute;
    }

    public void setNameOfRoute(String nameOfRoute) {
        this.nameOfRoute = nameOfRoute;
    }

    @Basic
    @Column(name = "start_point_of_route", nullable = true)
    public Integer getStartPointOfRoute() {
        return startPointOfRoute;
    }

    public void setStartPointOfRoute(Integer startPointOfRoute) {
        this.startPointOfRoute = startPointOfRoute;
    }

    @Basic
    @Column(name = "end_point_of_route", nullable = true)
    public Integer getEndPointOfRoute() {
        return endPointOfRoute;
    }

    public void setEndPointOfRoute(Integer endPointOfRoute) {
        this.endPointOfRoute = endPointOfRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (idRoute != null ? !idRoute.equals(route.idRoute) : route.idRoute != null) return false;
        if (nameOfRoute != null ? !nameOfRoute.equals(route.nameOfRoute) : route.nameOfRoute != null) return false;
        if (startPointOfRoute != null ? !startPointOfRoute.equals(route.startPointOfRoute) : route.startPointOfRoute != null)
            return false;
        if (endPointOfRoute != null ? !endPointOfRoute.equals(route.endPointOfRoute) : route.endPointOfRoute != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoute != null ? idRoute.hashCode() : 0;
        result = 31 * result + (nameOfRoute != null ? nameOfRoute.hashCode() : 0);
        result = 31 * result + (startPointOfRoute != null ? startPointOfRoute.hashCode() : 0);
        result = 31 * result + (endPointOfRoute != null ? endPointOfRoute.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "routeByRoute")
//    private List<Maps> mapsByIdRoute = new ArrayList<Maps>();
//
//    public ArrayList<Maps> getMapsByIdRoute() {
//        return (ArrayList<Maps>)mapsByIdRoute;
//    }
//
//    public void setMapsByIdRoute(ArrayList<Maps> mapsByIdRoute) {
//        this.mapsByIdRoute = mapsByIdRoute;
//    }
//    @ManyToOne
//    @JoinColumn(name = "start_point_of_route", referencedColumnName = "id_point")
//    private Points pointsByStartPointsOfRoute;
//
//    public Points getPointsByStartPointOfRoute() {
//        return this.pointsByStartPointsOfRoute;
//    }
//
//    public void setPointsByStartPointOfRoute(Points pointsByStartPointOfRoute) {
//        this.pointsByStartPointsOfRoute = pointsByStartPointOfRoute;
//    }
//
//
//    @ManyToOne
//    @JoinColumn(name = "end_point_of_route", referencedColumnName = "id_point")
//    private Points pointsByEndPointOfRoute;
//
//    public Points getPointsByEndPointOfRoute() {
//        return this.pointsByEndPointOfRoute;
//    }
//
//    public void setPointsByEndPointOfRoute(Points pointsByEndPointOfRoute) {
//        this.pointsByEndPointOfRoute = pointsByEndPointOfRoute;
//    }
}
