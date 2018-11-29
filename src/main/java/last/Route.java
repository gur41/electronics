package last;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Route {
    private Integer idRoute;
    private String nameOfRoute;
    private Integer startPointOfRoute;
    private Integer endPointOfRoute;
    private Collection<Maps> mapsByIdRoute;
    private Points pointsByStartPointOfRoute;
    private Points pointsByEndPointOfRoute;

    @Id
    @Column(name = "id_route", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdRoute() {
        return idRoute;
    }

    public Route(String nameOfRoute, Integer startPointOfRoute, Integer endPointOfRoute) {
        this.nameOfRoute = nameOfRoute;
        this.startPointOfRoute = startPointOfRoute;
        this.endPointOfRoute = endPointOfRoute;
    }

    public Route() {
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

    @OneToMany(mappedBy = "routeByRoute")
    public Collection<Maps> getMapsByIdRoute() {
        return mapsByIdRoute;
    }

    public void setMapsByIdRoute(Collection<Maps> mapsByIdRoute) {
        this.mapsByIdRoute = mapsByIdRoute;
    }

    @ManyToOne
    @JoinColumn(name = "start_point_of_route", referencedColumnName = "id_point", insertable = false, updatable = false)
    public Points getPointsByStartPointOfRoute() {
        return pointsByStartPointOfRoute;
    }

    public void setPointsByStartPointOfRoute(Points pointsByStartPointOfRoute) {
        this.pointsByStartPointOfRoute = pointsByStartPointOfRoute;
    }

    @ManyToOne
    @JoinColumn(name = "end_point_of_route", referencedColumnName = "id_point", insertable = false, updatable = false)
    public Points getPointsByEndPointOfRoute() {
        return pointsByEndPointOfRoute;
    }

    public void setPointsByEndPointOfRoute(Points pointsByEndPointOfRoute) {
        this.pointsByEndPointOfRoute = pointsByEndPointOfRoute;
    }
}
