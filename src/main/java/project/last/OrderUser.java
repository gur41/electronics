package project.last;

import javax.persistence.*;

@Entity
@Table(name = "order_user", schema = "log", catalog = "")
public class OrderUser {
    private Integer idOrder;
    private Double price;
    private Integer idRouteOrder;
    private Double weight;
    private Integer idUserOrder;
    private String phone;
    private String firstName;
    private String secondName;
    private String status;
    private String eMail;
    private Route routeByIdRouteOrder;
    private User userByIdUserOrder;


    public OrderUser(Double price, Integer idRouteOrder, Double weight, Integer idUserOrder, String phone, String firstName, String secondName, String eMail) {
        this.price = price;
        this.idRouteOrder = idRouteOrder;
        this.weight = weight;
        this.idUserOrder = idUserOrder;
        this.phone = phone;
        this.firstName = firstName;
        this.secondName = secondName;
        this.eMail = eMail;
    }

    public OrderUser(Double price, Integer idRouteOrder, Double weight, Integer idUserOrder, String phone, String firstName, String secondName, String status, String eMail) {
        this.price = price;
        this.idRouteOrder = idRouteOrder;
        this.weight = weight;
        this.idUserOrder = idUserOrder;
        this.phone = phone;
        this.firstName = firstName;
        this.secondName = secondName;
        this.status = status;
        this.eMail = eMail;
    }

    public OrderUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "id_route_order", nullable = true)
    public Integer getIdRouteOrder() {
        return idRouteOrder;
    }

    public void setIdRouteOrder(Integer idRouteOrder) {
        this.idRouteOrder = idRouteOrder;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "id_user_order", nullable = true)
    public Integer getIdUserOrder() {
        return idUserOrder;
    }

    public void setIdUserOrder(Integer idUserOrder) {
        this.idUserOrder = idUserOrder;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = true, length = 255)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "e_mail", nullable = true, length = 255)
    public String geteMail() {
        return eMail;
    }



    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderUser orderUser = (OrderUser) o;

        if (idOrder != null ? !idOrder.equals(orderUser.idOrder) : orderUser.idOrder != null) return false;
        if (price != null ? !price.equals(orderUser.price) : orderUser.price != null) return false;
        if (idRouteOrder != null ? !idRouteOrder.equals(orderUser.idRouteOrder) : orderUser.idRouteOrder != null)
            return false;
        if (weight != null ? !weight.equals(orderUser.weight) : orderUser.weight != null) return false;
        if (idUserOrder != null ? !idUserOrder.equals(orderUser.idUserOrder) : orderUser.idUserOrder != null)
            return false;
        if (phone != null ? !phone.equals(orderUser.phone) : orderUser.phone != null) return false;
        if (firstName != null ? !firstName.equals(orderUser.firstName) : orderUser.firstName != null) return false;
        if (secondName != null ? !secondName.equals(orderUser.secondName) : orderUser.secondName != null) return false;
        if (eMail != null ? !eMail.equals(orderUser.eMail) : orderUser.eMail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder != null ? idOrder.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (idRouteOrder != null ? idRouteOrder.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (idUserOrder != null ? idUserOrder.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_route_order", referencedColumnName = "id_route", insertable = false, updatable = false )
    public Route getRouteByIdRouteOrder() {
        return routeByIdRouteOrder;
    }

    public void setRouteByIdRouteOrder(Route routeByIdRouteOrder) {
        this.routeByIdRouteOrder = routeByIdRouteOrder;
    }

    @ManyToOne
    @JoinColumn(name = "id_user_order", referencedColumnName = "id", insertable = false, updatable = false )
    public User getUserByIdUserOrder() {
        return userByIdUserOrder;
    }

    public void setUserByIdUserOrder(User userByIdUserOrder) {
        this.userByIdUserOrder = userByIdUserOrder;
    }
}
