package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "common_information_for_notebook", schema = "log", catalog = "")
public class CommonInformationForNotebook {
    private Integer id;
    private String timeEnter;
    private String type;
    private Byte transformer;
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
    @Column(name = "time_enter", nullable = true, length = 255)
    public String getTimeEnter() {
        return timeEnter;
    }

    public void setTimeEnter(String timeEnter) {
        this.timeEnter = timeEnter;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "transformer", nullable = true)
    public Byte getTransformer() {
        return transformer;
    }

    public void setTransformer(Byte transformer) {
        this.transformer = transformer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonInformationForNotebook that = (CommonInformationForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timeEnter != null ? !timeEnter.equals(that.timeEnter) : that.timeEnter != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (transformer != null ? !transformer.equals(that.transformer) : that.transformer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timeEnter != null ? timeEnter.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (transformer != null ? transformer.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "commonInformationForNotebookByIdCommonInformationForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
