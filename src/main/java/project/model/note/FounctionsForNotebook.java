package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "founctions_for_notebook", schema = "log", catalog = "")
public class FounctionsForNotebook {
    private Integer id;
    private Byte scaner;
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
    @Column(name = "scaner", nullable = true)
    public Byte getScaner() {
        return scaner;
    }

    public void setScaner(Byte scaner) {
        this.scaner = scaner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FounctionsForNotebook that = (FounctionsForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (scaner != null ? !scaner.equals(that.scaner) : that.scaner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (scaner != null ? scaner.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "founctionsForNotebookByIdFounctionsForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
