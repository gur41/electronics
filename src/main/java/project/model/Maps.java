package project.model;

import javax.persistence.*;

@Entity
@Table(name = "maps", schema = "logistics", catalog = "")
public class Maps {
    private Integer idMaps;
    private Integer startPoint;
    private Integer endPoint;
    private Integer route;
    private String distance;
    private Integer idTransportInMaps;
    private Double costForHour;


    public Maps() {
    }

    @Id
    @Column(name = "id_maps", nullable = false)
    public Integer getIdMaps() {
        return idMaps;
    }

    public void setIdMaps(Integer idMaps) {
        this.idMaps = idMaps;
    }

    @Basic
    @Column(name = "start_point", nullable = true)
    public Integer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    @Basic
    @Column(name = "end_point", nullable = true)
    public Integer getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Integer endPoint) {
        this.endPoint = endPoint;
    }

    @Basic
    @Column(name = "route", nullable = true)
    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    @Basic
    @Column(name = "distance", nullable = true, length = 255)
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "id_transport_in_maps", nullable = true)
    public Integer getIdTransportInMaps() {
        return idTransportInMaps;
    }

    public void setIdTransportInMaps(Integer idTransportInMaps) {
        this.idTransportInMaps = idTransportInMaps;
    }

    @Basic
    @Column(name = "cost_for_hour", nullable = true, precision = 0)
    public Double getCostForHour() {
        return costForHour;
    }

    public void setCostForHour(Double costForHour) {
        this.costForHour = costForHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maps maps = (Maps) o;

        if (idMaps != null ? !idMaps.equals(maps.idMaps) : maps.idMaps != null) return false;
        if (startPoint != null ? !startPoint.equals(maps.startPoint) : maps.startPoint != null) return false;
        if (endPoint != null ? !endPoint.equals(maps.endPoint) : maps.endPoint != null) return false;
        if (route != null ? !route.equals(maps.route) : maps.route != null) return false;
        if (distance != null ? !distance.equals(maps.distance) : maps.distance != null) return false;
        if (idTransportInMaps != null ? !idTransportInMaps.equals(maps.idTransportInMaps) : maps.idTransportInMaps != null)
            return false;
        if (costForHour != null ? !costForHour.equals(maps.costForHour) : maps.costForHour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaps != null ? idMaps.hashCode() : 0;
        result = 31 * result + (startPoint != null ? startPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (idTransportInMaps != null ? idTransportInMaps.hashCode() : 0);
        result = 31 * result + (costForHour != null ? costForHour.hashCode() : 0);
        return result;
    }

    /*@ManyToOne
    @JoinColumn(name = "start_point", referencedColumnName = "id_point")
    private Points pointsByStartPoint;
    public Points getPointsByStartPoint() {
        return pointsByStartPoint;
    }

    public void setPointsByStartPoint(Points pointsByStartPoint) {
        this.pointsByStartPoint = pointsByStartPoint;
    }

    @ManyToOne
    @JoinColumn(name = "end_point", referencedColumnName = "id_point")
    public Points pointsByEndPoint;

    public Points getPointsByEndPoint() {
        return pointsByEndPoint;
    }

    public void setPointsByEndPoint(Points pointsByEndPoint) {
        this.pointsByEndPoint = pointsByEndPoint;
    }

    @ManyToOne
    @JoinColumn(name = "route", referencedColumnName = "id_route")
    private Route routeByRoute;
    public Route getRouteByRoute() {
        return routeByRoute;
    }

    public void setRouteByRoute(Route routeByRoute) {
        this.routeByRoute = routeByRoute;
    }

    @ManyToOne
    @JoinColumn(name = "id_transport_in_maps", referencedColumnName = "id_transport")
    private Transport transportByIdTransportInMaps;
    public Transport getTransportByIdTransportInMaps() {
        return transportByIdTransportInMaps;
    }

    public void setTransportByIdTransportInMaps(Transport transportByIdTransportInMaps) {
        this.transportByIdTransportInMaps = transportByIdTransportInMaps;
    }*/
}
