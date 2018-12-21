package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "data_for_notebook", schema = "log", catalog = "")
public class DataForNotebook {
    private Integer id;
    private String configuration;
    private String type;
    private Integer volume;
    private Byte optical;
    private Byte memoryCard;
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
    @Column(name = "configuration", nullable = true, length = 255)
    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
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

    @Basic
    @Column(name = "optical", nullable = true)
    public Byte getOptical() {
        return optical;
    }

    public void setOptical(Byte optical) {
        this.optical = optical;
    }

    @Basic
    @Column(name = "memory_card", nullable = true)
    public Byte getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(Byte memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataForNotebook that = (DataForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (configuration != null ? !configuration.equals(that.configuration) : that.configuration != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (optical != null ? !optical.equals(that.optical) : that.optical != null) return false;
        if (memoryCard != null ? !memoryCard.equals(that.memoryCard) : that.memoryCard != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (configuration != null ? configuration.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (optical != null ? optical.hashCode() : 0);
        result = 31 * result + (memoryCard != null ? memoryCard.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dataForNotebookByIdDataForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
