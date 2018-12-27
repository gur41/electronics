package project.last;

import javax.persistence.*;

@Entity
public class Maps {
    private Integer idMaps;
    private Integer startPointId;
    private Integer endPointId;
    private Integer route;
    private Double distance;
    private Integer idTransportInMaps;
    private Double costForHour;
    private Points pointsByStartPointId;
    private Points pointsByEndPointId;
    private Route routeByRoute;
    private Transport transportByIdTransportInMaps;

    public Maps(Integer startPointId, Integer endPointId, Integer route, Double distance, Integer idTransportInMaps, Double costForHour) {
        this.startPointId = startPointId;
        this.endPointId = endPointId;
        this.route = route;
        this.distance = distance;
        this.idTransportInMaps = idTransportInMaps;
        this.costForHour = costForHour;
    }

    public Maps() {
    }

    @Id
    @Column(name = "id_maps", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdMaps() {
        return idMaps;
    }

    public void setIdMaps(Integer idMaps) {
        this.idMaps = idMaps;
    }

    @Basic
    @Column(name = "start_point_id", nullable = true)
    public Integer getStartPointId() {
        return startPointId;
    }

    public void setStartPointId(Integer startPointId) {
        this.startPointId = startPointId;
    }

    @Basic
    @Column(name = "end_point_id", nullable = true)
    public Integer getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(Integer endPointId) {
        this.endPointId = endPointId;
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
    @Column(name = "distance", nullable = true, precision = 0)
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
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
        if (startPointId != null ? !startPointId.equals(maps.startPointId) : maps.startPointId != null) return false;
        if (endPointId != null ? !endPointId.equals(maps.endPointId) : maps.endPointId != null) return false;
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
        result = 31 * result + (startPointId != null ? startPointId.hashCode() : 0);
        result = 31 * result + (endPointId != null ? endPointId.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (idTransportInMaps != null ? idTransportInMaps.hashCode() : 0);
        result = 31 * result + (costForHour != null ? costForHour.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "start_point_id", referencedColumnName = "id_point", insertable = false, updatable = false)})
    public Points getPointsByStartPointId() {
        return pointsByStartPointId;
    }

    public void setPointsByStartPointId(Points pointsByStartPointId) {
        this.pointsByStartPointId = pointsByStartPointId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "end_point_id", referencedColumnName = "id_point", insertable = false, updatable = false)})
    public Points getPointsByEndPointId() {
        return pointsByEndPointId;
    }

    public void setPointsByEndPointId(Points pointsByEndPointId) {
        this.pointsByEndPointId = pointsByEndPointId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "route", referencedColumnName = "id_route", insertable = false, updatable = false)})
    public Route getRouteByRoute() {
        return routeByRoute;
    }

    public void setRouteByRoute(Route routeByRoute) {
        this.routeByRoute = routeByRoute;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_transport_in_maps", referencedColumnName = "id_transport", insertable = false, updatable = false)})
    public Transport getTransportByIdTransportInMaps() {
        return transportByIdTransportInMaps;
    }

    public void setTransportByIdTransportInMaps(Transport transportByIdTransportInMaps) {
        this.transportByIdTransportInMaps = transportByIdTransportInMaps;
    }
}
