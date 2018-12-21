package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "camera_sound_for_notebook", schema = "log", catalog = "")
public class CameraSoundForNotebook {
    private Integer id;
    private Byte camera;
    private Byte microphone;
    private String dinamics;
    private Integer pixel;
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
    @Column(name = "camera", nullable = true)
    public Byte getCamera() {
        return camera;
    }

    public void setCamera(Byte camera) {
        this.camera = camera;
    }

    @Basic
    @Column(name = "microphone", nullable = true)
    public Byte getMicrophone() {
        return microphone;
    }

    public void setMicrophone(Byte microphone) {
        this.microphone = microphone;
    }

    @Basic
    @Column(name = "dinamics", nullable = true, length = 255)
    public String getDinamics() {
        return dinamics;
    }

    public void setDinamics(String dinamics) {
        this.dinamics = dinamics;
    }

    @Basic
    @Column(name = "pixel", nullable = true)
    public Integer getPixel() {
        return pixel;
    }

    public void setPixel(Integer pixel) {
        this.pixel = pixel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CameraSoundForNotebook that = (CameraSoundForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (camera != null ? !camera.equals(that.camera) : that.camera != null) return false;
        if (microphone != null ? !microphone.equals(that.microphone) : that.microphone != null) return false;
        if (dinamics != null ? !dinamics.equals(that.dinamics) : that.dinamics != null) return false;
        if (pixel != null ? !pixel.equals(that.pixel) : that.pixel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (camera != null ? camera.hashCode() : 0);
        result = 31 * result + (microphone != null ? microphone.hashCode() : 0);
        result = 31 * result + (dinamics != null ? dinamics.hashCode() : 0);
        result = 31 * result + (pixel != null ? pixel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cameraSoundForNotebookByIdCameraSoundForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
