package project.model;

import last.User;

import javax.persistence.*;

@Entity
@Table(name = "order_user_electronic", schema = "log", catalog = "")
public class OrderUserElectronic {
    private Integer idOrder;
    private Double price;
    private String name;
    private Integer idUserElectronics;
    private String phone;
    private String firstName;
    private String secondName;
    private String eMail;
    private String status;
    private User userByIdOrderUserElectronics;

    @Id
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id_user_electronics", nullable = true)
    public Integer getIdUserElectronics() {
        return idUserElectronics;
    }

    public void setIdUserElectronics(Integer idUserElectronics) {
        this.idUserElectronics = idUserElectronics;
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

        OrderUserElectronic that = (OrderUserElectronic) o;

        if (idOrder != null ? !idOrder.equals(that.idOrder) : that.idOrder != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (idUserElectronics != null ? !idUserElectronics.equals(that.idUserElectronics) : that.idUserElectronics != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder != null ? idOrder.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idUserElectronics != null ? idUserElectronics.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_user_electronics", referencedColumnName = "id", insertable = false, updatable = false )

    public User getUserByIdOrderUserElectronics() {
        return userByIdOrderUserElectronics;
    }

    public void setUserByIdOrderUserElectronics(User userByIdOrderUserElectronics) {
        this.userByIdOrderUserElectronics = userByIdOrderUserElectronics;
    }
}
