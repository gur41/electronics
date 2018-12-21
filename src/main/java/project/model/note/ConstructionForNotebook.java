package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "construction_for_notebook", schema = "log", catalog = "")
public class ConstructionForNotebook {
    private Integer id;
    private String materialBody;
    private String colorBody;
    private String materialCap;
    private String colorCar;
    private Byte backlight;
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
    @Column(name = "material_body", nullable = true, length = 255)
    public String getMaterialBody() {
        return materialBody;
    }

    public void setMaterialBody(String materialBody) {
        this.materialBody = materialBody;
    }

    @Basic
    @Column(name = "color_body", nullable = true, length = 255)
    public String getColorBody() {
        return colorBody;
    }

    public void setColorBody(String colorBody) {
        this.colorBody = colorBody;
    }

    @Basic
    @Column(name = "material_cap", nullable = true, length = 255)
    public String getMaterialCap() {
        return materialCap;
    }

    public void setMaterialCap(String materialCap) {
        this.materialCap = materialCap;
    }

    @Basic
    @Column(name = "color_car", nullable = true, length = 255)
    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    @Basic
    @Column(name = "backlight", nullable = true)
    public Byte getBacklight() {
        return backlight;
    }

    public void setBacklight(Byte backlight) {
        this.backlight = backlight;
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

        ConstructionForNotebook that = (ConstructionForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (materialBody != null ? !materialBody.equals(that.materialBody) : that.materialBody != null) return false;
        if (colorBody != null ? !colorBody.equals(that.colorBody) : that.colorBody != null) return false;
        if (materialCap != null ? !materialCap.equals(that.materialCap) : that.materialCap != null) return false;
        if (colorCar != null ? !colorCar.equals(that.colorCar) : that.colorCar != null) return false;
        if (backlight != null ? !backlight.equals(that.backlight) : that.backlight != null) return false;
        if (impactResistance != null ? !impactResistance.equals(that.impactResistance) : that.impactResistance != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (materialBody != null ? materialBody.hashCode() : 0);
        result = 31 * result + (colorBody != null ? colorBody.hashCode() : 0);
        result = 31 * result + (materialCap != null ? materialCap.hashCode() : 0);
        result = 31 * result + (colorCar != null ? colorCar.hashCode() : 0);
        result = 31 * result + (backlight != null ? backlight.hashCode() : 0);
        result = 31 * result + (impactResistance != null ? impactResistance.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "constructionForNotebookByIdConstructionForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
