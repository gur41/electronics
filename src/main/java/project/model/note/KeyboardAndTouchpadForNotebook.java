package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "keyboard_and_touchpad_for_notebook", schema = "log", catalog = "")
public class KeyboardAndTouchpadForNotebook {
    private Integer id;
    private Byte numpad;
    private Byte backlight;
    private Byte kirilitca;
    private String touchpad;
    private Byte multimediaPannel;
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
    @Column(name = "numpad", nullable = true)
    public Byte getNumpad() {
        return numpad;
    }

    public void setNumpad(Byte numpad) {
        this.numpad = numpad;
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
    @Column(name = "kirilitca", nullable = true)
    public Byte getKirilitca() {
        return kirilitca;
    }

    public void setKirilitca(Byte kirilitca) {
        this.kirilitca = kirilitca;
    }

    @Basic
    @Column(name = "touchpad", nullable = true, length = 255)
    public String getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(String touchpad) {
        this.touchpad = touchpad;
    }

    @Basic
    @Column(name = "multimedia_pannel", nullable = true)
    public Byte getMultimediaPannel() {
        return multimediaPannel;
    }

    public void setMultimediaPannel(Byte multimediaPannel) {
        this.multimediaPannel = multimediaPannel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyboardAndTouchpadForNotebook that = (KeyboardAndTouchpadForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (numpad != null ? !numpad.equals(that.numpad) : that.numpad != null) return false;
        if (backlight != null ? !backlight.equals(that.backlight) : that.backlight != null) return false;
        if (kirilitca != null ? !kirilitca.equals(that.kirilitca) : that.kirilitca != null) return false;
        if (touchpad != null ? !touchpad.equals(that.touchpad) : that.touchpad != null) return false;
        if (multimediaPannel != null ? !multimediaPannel.equals(that.multimediaPannel) : that.multimediaPannel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numpad != null ? numpad.hashCode() : 0);
        result = 31 * result + (backlight != null ? backlight.hashCode() : 0);
        result = 31 * result + (kirilitca != null ? kirilitca.hashCode() : 0);
        result = 31 * result + (touchpad != null ? touchpad.hashCode() : 0);
        result = 31 * result + (multimediaPannel != null ? multimediaPannel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "keyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
