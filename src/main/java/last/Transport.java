package last;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Transport {
    private Integer idTransport;
    private String transportName;
    private Integer speed;
    private Double coefficient;
    private Integer maxWeight;
    private Collection<Maps> mapsByIdTransport;

    public Transport(String transportName, Integer speed, Double coefficient, Integer maxWeight) {
        this.transportName = transportName;
        this.speed = speed;
        this.coefficient = coefficient;
        this.maxWeight = maxWeight;
    }

    public Transport() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transport", nullable = false)
    public Integer getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(Integer idTransport) {
        this.idTransport = idTransport;
    }

    @Basic
    @Column(name = "transport_name", nullable = true, length = 255)
    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    @Basic
    @Column(name = "speed", nullable = true)
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "coefficient", nullable = true, precision = 0)
    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Basic
    @Column(name = "max_weight", nullable = true)
    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (idTransport != null ? !idTransport.equals(transport.idTransport) : transport.idTransport != null)
            return false;
        if (transportName != null ? !transportName.equals(transport.transportName) : transport.transportName != null)
            return false;
        if (speed != null ? !speed.equals(transport.speed) : transport.speed != null) return false;
        if (coefficient != null ? !coefficient.equals(transport.coefficient) : transport.coefficient != null)
            return false;
        if (maxWeight != null ? !maxWeight.equals(transport.maxWeight) : transport.maxWeight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =1;
        result = 31 * result + (transportName != null ? transportName.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (coefficient != null ? coefficient.hashCode() : 0);
        result = 31 * result + (maxWeight != null ? maxWeight.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "transportByIdTransportInMaps")
    public Collection<Maps> getMapsByIdTransport() {
        return mapsByIdTransport;
    }

    public void setMapsByIdTransport(Collection<Maps> mapsByIdTransport) {
        this.mapsByIdTransport = mapsByIdTransport;
    }
}
