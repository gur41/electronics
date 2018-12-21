package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "battery_for_notebook", schema = "log", catalog = "")
public class BatteryForNotebook {
    private Integer id;
    private String time;
    private Integer cell;
    private Integer energy;
    private Collection<Notebook> notebooksById;

    public BatteryForNotebook() {
    }

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
    @Column(name = "time", nullable = true, length = 255)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "cell", nullable = true)
    public Integer getCell() {
        return cell;
    }

    public void setCell(Integer cell) {
        this.cell = cell;
    }

    @Basic
    @Column(name = "energy", nullable = true)
    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatteryForNotebook that = (BatteryForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (cell != null ? !cell.equals(that.cell) : that.cell != null) return false;
        if (energy != null ? !energy.equals(that.energy) : that.energy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (cell != null ? cell.hashCode() : 0);
        result = 31 * result + (energy != null ? energy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "batteryForNotebookByIdBatteryForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
