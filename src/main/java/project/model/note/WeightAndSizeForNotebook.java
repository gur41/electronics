package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "weight_and_size_for_notebook", schema = "log", catalog = "")
public class WeightAndSizeForNotebook {
    private Integer id;
    private Double width;
    private Double depth;
    private Double thickness;
    private Double weight;
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
    @Column(name = "width", nullable = true, precision = 0)
    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Basic
    @Column(name = "depth", nullable = true, precision = 0)
    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    @Basic
    @Column(name = "thickness", nullable = true, precision = 0)
    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightAndSizeForNotebook that = (WeightAndSizeForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (depth != null ? !depth.equals(that.depth) : that.depth != null) return false;
        if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (depth != null ? depth.hashCode() : 0);
        result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "weightAndSizeForNotebookByIdWeightAndSizeForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
