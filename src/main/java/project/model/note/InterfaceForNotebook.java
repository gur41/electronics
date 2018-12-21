package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "interface_for_notebook", schema = "log", catalog = "")
public class InterfaceForNotebook {
    private Integer id;
    private Byte nfc;
    private String bluetooth;
    private Byte lan;
    private String wifi;
    private Byte mobile;
    private Integer usbPort;
    private Integer usb2;
    private Integer usb3;
    private Integer usb31A;
    private Integer usb31C;
    private Byte vga;
    private Byte hdmi;
    private Byte displayPort;
    private Byte thounderbolt;
    private Byte jack;
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
    @Column(name = "nfc", nullable = true)
    public Byte getNfc() {
        return nfc;
    }

    public void setNfc(Byte nfc) {
        this.nfc = nfc;
    }

    @Basic
    @Column(name = "bluetooth", nullable = true, length = 255)
    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    @Basic
    @Column(name = "LAN", nullable = true)
    public Byte getLan() {
        return lan;
    }

    public void setLan(Byte lan) {
        this.lan = lan;
    }

    @Basic
    @Column(name = "wifi", nullable = true, length = 255)
    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    @Basic
    @Column(name = "mobile", nullable = true)
    public Byte getMobile() {
        return mobile;
    }

    public void setMobile(Byte mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "usb_port", nullable = true)
    public Integer getUsbPort() {
        return usbPort;
    }

    public void setUsbPort(Integer usbPort) {
        this.usbPort = usbPort;
    }

    @Basic
    @Column(name = "usb_2", nullable = true)
    public Integer getUsb2() {
        return usb2;
    }

    public void setUsb2(Integer usb2) {
        this.usb2 = usb2;
    }

    @Basic
    @Column(name = "usb_3", nullable = true)
    public Integer getUsb3() {
        return usb3;
    }

    public void setUsb3(Integer usb3) {
        this.usb3 = usb3;
    }

    @Basic
    @Column(name = "usb_3_1_a", nullable = true)
    public Integer getUsb31A() {
        return usb31A;
    }

    public void setUsb31A(Integer usb31A) {
        this.usb31A = usb31A;
    }

    @Basic
    @Column(name = "usb_3_1_c", nullable = true)
    public Integer getUsb31C() {
        return usb31C;
    }

    public void setUsb31C(Integer usb31C) {
        this.usb31C = usb31C;
    }

    @Basic
    @Column(name = "vga", nullable = true)
    public Byte getVga() {
        return vga;
    }

    public void setVga(Byte vga) {
        this.vga = vga;
    }

    @Basic
    @Column(name = "hdmi", nullable = true)
    public Byte getHdmi() {
        return hdmi;
    }

    public void setHdmi(Byte hdmi) {
        this.hdmi = hdmi;
    }

    @Basic
    @Column(name = "display_port", nullable = true)
    public Byte getDisplayPort() {
        return displayPort;
    }

    public void setDisplayPort(Byte displayPort) {
        this.displayPort = displayPort;
    }

    @Basic
    @Column(name = "thounderbolt", nullable = true)
    public Byte getThounderbolt() {
        return thounderbolt;
    }

    public void setThounderbolt(Byte thounderbolt) {
        this.thounderbolt = thounderbolt;
    }

    @Basic
    @Column(name = "jack", nullable = true)
    public Byte getJack() {
        return jack;
    }

    public void setJack(Byte jack) {
        this.jack = jack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterfaceForNotebook that = (InterfaceForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nfc != null ? !nfc.equals(that.nfc) : that.nfc != null) return false;
        if (bluetooth != null ? !bluetooth.equals(that.bluetooth) : that.bluetooth != null) return false;
        if (lan != null ? !lan.equals(that.lan) : that.lan != null) return false;
        if (wifi != null ? !wifi.equals(that.wifi) : that.wifi != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (usbPort != null ? !usbPort.equals(that.usbPort) : that.usbPort != null) return false;
        if (usb2 != null ? !usb2.equals(that.usb2) : that.usb2 != null) return false;
        if (usb3 != null ? !usb3.equals(that.usb3) : that.usb3 != null) return false;
        if (usb31A != null ? !usb31A.equals(that.usb31A) : that.usb31A != null) return false;
        if (usb31C != null ? !usb31C.equals(that.usb31C) : that.usb31C != null) return false;
        if (vga != null ? !vga.equals(that.vga) : that.vga != null) return false;
        if (hdmi != null ? !hdmi.equals(that.hdmi) : that.hdmi != null) return false;
        if (displayPort != null ? !displayPort.equals(that.displayPort) : that.displayPort != null) return false;
        if (thounderbolt != null ? !thounderbolt.equals(that.thounderbolt) : that.thounderbolt != null) return false;
        if (jack != null ? !jack.equals(that.jack) : that.jack != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nfc != null ? nfc.hashCode() : 0);
        result = 31 * result + (bluetooth != null ? bluetooth.hashCode() : 0);
        result = 31 * result + (lan != null ? lan.hashCode() : 0);
        result = 31 * result + (wifi != null ? wifi.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (usbPort != null ? usbPort.hashCode() : 0);
        result = 31 * result + (usb2 != null ? usb2.hashCode() : 0);
        result = 31 * result + (usb3 != null ? usb3.hashCode() : 0);
        result = 31 * result + (usb31A != null ? usb31A.hashCode() : 0);
        result = 31 * result + (usb31C != null ? usb31C.hashCode() : 0);
        result = 31 * result + (vga != null ? vga.hashCode() : 0);
        result = 31 * result + (hdmi != null ? hdmi.hashCode() : 0);
        result = 31 * result + (displayPort != null ? displayPort.hashCode() : 0);
        result = 31 * result + (thounderbolt != null ? thounderbolt.hashCode() : 0);
        result = 31 * result + (jack != null ? jack.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "interfaceForNotebookByIdInterfaceForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
