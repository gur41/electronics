package last;

import project.model.OrderUserElectronic;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private Integer id;
    private String login;
    private String password;
    private String role;
    private Collection<OrderUser> orderUsersById;
    private Collection<Route> routesById;
    private Collection<OrderUserElectronic> orderUserElectronicsById;


    public User() {
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 255)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 255)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByIdUserOrder")
    public Collection<OrderUser> getOrderUsersById() {
        return orderUsersById;
    }

    public void setOrderUsersById(Collection<OrderUser> orderUsersById) {
        this.orderUsersById = orderUsersById;
    }

    @OneToMany(mappedBy = "userByIdUserCreatedRoute")
    public Collection<Route> getRoutesById() {
        return routesById;
    }

    public void setRoutesById(Collection<Route> routesById) {
        this.routesById = routesById;
    }

    @OneToMany(mappedBy = "userByIdOrderUserElectronics")

    public Collection<OrderUserElectronic> getOrderUserElectronicsById() {
        return orderUserElectronicsById;
    }

    public void setOrderUserElectronicsById(Collection<OrderUserElectronic> orderUserElectronicsById) {
        this.orderUserElectronicsById = orderUserElectronicsById;
    }
}
