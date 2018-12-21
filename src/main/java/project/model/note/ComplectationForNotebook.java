package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "complectation_for_notebook", schema = "log", catalog = "")
public class ComplectationForNotebook {
    private Integer id;
    private Byte batary2;
    private Byte mouse;
    private Byte bagCase;
    private String complect;
    private Collection<Notebook> notebooksById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "batary_2", nullable = true)
    public Byte getBatary2() {
        return batary2;
    }

    public void setBatary2(Byte batary2) {
        this.batary2 = batary2;
    }

    @Basic
    @Column(name = "mouse", nullable = true)
    public Byte getMouse() {
        return mouse;
    }

    public void setMouse(Byte mouse) {
        this.mouse = mouse;
    }

    @Basic
    @Column(name = "bag_case", nullable = true)
    public Byte getBagCase() {
        return bagCase;
    }

    public void setBagCase(Byte bagCase) {
        this.bagCase = bagCase;
    }

    @Basic
    @Column(name = "complect", nullable = true, length = 255)
    public String getComplect() {
        return complect;
    }

    public void setComplect(String complect) {
        this.complect = complect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplectationForNotebook that = (ComplectationForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (batary2 != null ? !batary2.equals(that.batary2) : that.batary2 != null) return false;
        if (mouse != null ? !mouse.equals(that.mouse) : that.mouse != null) return false;
        if (bagCase != null ? !bagCase.equals(that.bagCase) : that.bagCase != null) return false;
        if (complect != null ? !complect.equals(that.complect) : that.complect != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (batary2 != null ? batary2.hashCode() : 0);
        result = 31 * result + (mouse != null ? mouse.hashCode() : 0);
        result = 31 * result + (bagCase != null ? bagCase.hashCode() : 0);
        result = 31 * result + (complect != null ? complect.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "complectationForNotebookByIdComplectationForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
