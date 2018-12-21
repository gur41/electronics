package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "graphics_for_notebook", schema = "log", catalog = "")
public class GraphicsForNotebook {
    private Integer id;
    private String adapter;
    private String type;
    private Integer volume;
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
    @Column(name = "adapter", nullable = true, length = 255)
    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
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
    @Column(name = "volume", nullable = true)
    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphicsForNotebook that = (GraphicsForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (adapter != null ? !adapter.equals(that.adapter) : that.adapter != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adapter != null ? adapter.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "graphicsForNotebookByIdGraphicsForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
