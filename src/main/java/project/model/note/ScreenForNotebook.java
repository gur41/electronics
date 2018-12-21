package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "screen_for_notebook", schema = "log", catalog = "")
public class ScreenForNotebook {
    private Integer id;
    private Double diagonal;
    private String resolution;
    private String technologi;
    private String surface;
    private Byte sensonal;
    private Byte d3Screen;
    private Byte penInput;
    private Byte impactResistance;
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
    @Column(name = "diagonal", nullable = true, precision = 0)
    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }

    @Basic
    @Column(name = "resolution", nullable = true, length = 255)
    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Basic
    @Column(name = "technologi", nullable = true, length = 255)
    public String getTechnologi() {
        return technologi;
    }

    public void setTechnologi(String technologi) {
        this.technologi = technologi;
    }

    @Basic
    @Column(name = "surface", nullable = true, length = 255)
    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Basic
    @Column(name = "sensonal", nullable = true)
    public Byte getSensonal() {
        return sensonal;
    }

    public void setSensonal(Byte sensonal) {
        this.sensonal = sensonal;
    }

    @Basic
    @Column(name = "d3_screen", nullable = true)
    public Byte getD3Screen() {
        return d3Screen;
    }

    public void setD3Screen(Byte d3Screen) {
        this.d3Screen = d3Screen;
    }

    @Basic
    @Column(name = "pen_input", nullable = true)
    public Byte getPenInput() {
        return penInput;
    }

    public void setPenInput(Byte penInput) {
        this.penInput = penInput;
    }

    @Basic
    @Column(name = "impact_resistance", nullable = true)
    public Byte getImpactResistance() {
        return impactResistance;
    }

    public void setImpactResistance(Byte impactResistance) {
        this.impactResistance = impactResistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScreenForNotebook that = (ScreenForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (diagonal != null ? !diagonal.equals(that.diagonal) : that.diagonal != null) return false;
        if (resolution != null ? !resolution.equals(that.resolution) : that.resolution != null) return false;
        if (technologi != null ? !technologi.equals(that.technologi) : that.technologi != null) return false;
        if (surface != null ? !surface.equals(that.surface) : that.surface != null) return false;
        if (sensonal != null ? !sensonal.equals(that.sensonal) : that.sensonal != null) return false;
        if (d3Screen != null ? !d3Screen.equals(that.d3Screen) : that.d3Screen != null) return false;
        if (penInput != null ? !penInput.equals(that.penInput) : that.penInput != null) return false;
        if (impactResistance != null ? !impactResistance.equals(that.impactResistance) : that.impactResistance != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (diagonal != null ? diagonal.hashCode() : 0);
        result = 31 * result + (resolution != null ? resolution.hashCode() : 0);
        result = 31 * result + (technologi != null ? technologi.hashCode() : 0);
        result = 31 * result + (surface != null ? surface.hashCode() : 0);
        result = 31 * result + (sensonal != null ? sensonal.hashCode() : 0);
        result = 31 * result + (d3Screen != null ? d3Screen.hashCode() : 0);
        result = 31 * result + (penInput != null ? penInput.hashCode() : 0);
        result = 31 * result + (impactResistance != null ? impactResistance.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "screenForNotebookByIdScreenForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
