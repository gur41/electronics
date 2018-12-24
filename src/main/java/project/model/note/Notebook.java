package project.model.note;

import javax.persistence.*;

@Entity
public class Notebook {
    private Integer id;
    private String mark;
    private String name;
    private String photo;
    private Double price;
    private Integer idCommonInformationForNotebook;
    private Integer idProcessorForNotebook;
    private Integer idConstructionForNotebook;
    private Integer idWeightAndSizeForNotebook;
    private Integer idScreenForNotebook;
    private Integer idRamForNotebook;
    private Integer idDataForNotebook;
    private Integer idGraphicsForNotebook;
    private Integer idCameraSoundForNotebook;
    private Integer idKeyboardAndTouchpadForNotebook;
    private Integer idFounctionsForNotebook;
    private Integer idInterfaceForNotebook;
    private Integer idBatteryForNotebook;
    private Integer idComplectationForNotebook;
    private CommonInformationForNotebook commonInformationForNotebookByIdCommonInformationForNotebook;
    private ProcessorForNotebook processorForNotebookByIdProcessorForNotebook;
    private ConstructionForNotebook constructionForNotebookByIdConstructionForNotebook;
    private WeightAndSizeForNotebook weightAndSizeForNotebookByIdWeightAndSizeForNotebook;
    private ScreenForNotebook screenForNotebookByIdScreenForNotebook;
    private RamForNotebook ramForNotebookByIdRamForNotebook;
    private DataForNotebook dataForNotebookByIdDataForNotebook;
    private GraphicsForNotebook graphicsForNotebookByIdGraphicsForNotebook;
    private CameraSoundForNotebook cameraSoundForNotebookByIdCameraSoundForNotebook;
    private KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook;
    private FounctionsForNotebook founctionsForNotebookByIdFounctionsForNotebook;
    private InterfaceForNotebook interfaceForNotebookByIdInterfaceForNotebook;
    private BatteryForNotebook batteryForNotebookByIdBatteryForNotebook;
    private ComplectationForNotebook complectationForNotebookByIdComplectationForNotebook;

    public Notebook() {
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
    @Column(name = "mark", nullable = true, length = 255)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "photo", nullable = true, length = 255)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "id_common_information_for_notebook", nullable = true)
    public Integer getIdCommonInformationForNotebook() {
        return idCommonInformationForNotebook;
    }

    public void setIdCommonInformationForNotebook(Integer idCommonInformationForNotebook) {
        this.idCommonInformationForNotebook = idCommonInformationForNotebook;
    }

    @Basic
    @Column(name = "id_processor_for_notebook", nullable = true)
    public Integer getIdProcessorForNotebook() {
        return idProcessorForNotebook;
    }

    public void setIdProcessorForNotebook(Integer idProcessorForNotebook) {
        this.idProcessorForNotebook = idProcessorForNotebook;
    }

    @Basic
    @Column(name = "id_construction_for_notebook", nullable = true)
    public Integer getIdConstructionForNotebook() {
        return idConstructionForNotebook;
    }

    public void setIdConstructionForNotebook(Integer idConstructionForNotebook) {
        this.idConstructionForNotebook = idConstructionForNotebook;
    }

    @Basic
    @Column(name = "id_weight_and_size_for_notebook", nullable = true)
    public Integer getIdWeightAndSizeForNotebook() {
        return idWeightAndSizeForNotebook;
    }

    public void setIdWeightAndSizeForNotebook(Integer idWeightAndSizeForNotebook) {
        this.idWeightAndSizeForNotebook = idWeightAndSizeForNotebook;
    }

    @Basic
    @Column(name = "id_screen_for_notebook", nullable = true)
    public Integer getIdScreenForNotebook() {
        return idScreenForNotebook;
    }

    public void setIdScreenForNotebook(Integer idScreenForNotebook) {
        this.idScreenForNotebook = idScreenForNotebook;
    }

    @Basic
    @Column(name = "id_ram_for_notebook", nullable = true)
    public Integer getIdRamForNotebook() {
        return idRamForNotebook;
    }

    public void setIdRamForNotebook(Integer idRamForNotebook) {
        this.idRamForNotebook = idRamForNotebook;
    }

    @Basic
    @Column(name = "id_data_for_notebook", nullable = true)
    public Integer getIdDataForNotebook() {
        return idDataForNotebook;
    }

    public void setIdDataForNotebook(Integer idDataForNotebook) {
        this.idDataForNotebook = idDataForNotebook;
    }

    @Basic
    @Column(name = "id_graphics_for_notebook", nullable = true)
    public Integer getIdGraphicsForNotebook() {
        return idGraphicsForNotebook;
    }

    public void setIdGraphicsForNotebook(Integer idGraphicsForNotebook) {
        this.idGraphicsForNotebook = idGraphicsForNotebook;
    }

    @Basic
    @Column(name = "id_camera_sound_for_notebook", nullable = true)
    public Integer getIdCameraSoundForNotebook() {
        return idCameraSoundForNotebook;
    }

    public void setIdCameraSoundForNotebook(Integer idCameraSoundForNotebook) {
        this.idCameraSoundForNotebook = idCameraSoundForNotebook;
    }

    @Basic
    @Column(name = "id_keyboard_and_touchpad_for_notebook", nullable = true)
    public Integer getIdKeyboardAndTouchpadForNotebook() {
        return idKeyboardAndTouchpadForNotebook;
    }

    public void setIdKeyboardAndTouchpadForNotebook(Integer idKeyboardAndTouchpadForNotebook) {
        this.idKeyboardAndTouchpadForNotebook = idKeyboardAndTouchpadForNotebook;
    }

    @Basic
    @Column(name = "id_founctions_for_notebook", nullable = true)
    public Integer getIdFounctionsForNotebook() {
        return idFounctionsForNotebook;
    }

    public void setIdFounctionsForNotebook(Integer idFounctionsForNotebook) {
        this.idFounctionsForNotebook = idFounctionsForNotebook;
    }

    @Basic
    @Column(name = "id_interface_for_notebook", nullable = true)
    public Integer getIdInterfaceForNotebook() {
        return idInterfaceForNotebook;
    }

    public void setIdInterfaceForNotebook(Integer idInterfaceForNotebook) {
        this.idInterfaceForNotebook = idInterfaceForNotebook;
    }

    @Basic
    @Column(name = "id_battery_for_notebook", nullable = true)
    public Integer getIdBatteryForNotebook() {
        return idBatteryForNotebook;
    }

    public void setIdBatteryForNotebook(Integer idBatteryForNotebook) {
        this.idBatteryForNotebook = idBatteryForNotebook;
    }

    @Basic
    @Column(name = "id_complectation_for_notebook", nullable = true)
    public Integer getIdComplectationForNotebook() {
        return idComplectationForNotebook;
    }

    public void setIdComplectationForNotebook(Integer idComplectationForNotebook) {
        this.idComplectationForNotebook = idComplectationForNotebook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

        if (id != null ? !id.equals(notebook.id) : notebook.id != null) return false;
        if (mark != null ? !mark.equals(notebook.mark) : notebook.mark != null) return false;
        if (name != null ? !name.equals(notebook.name) : notebook.name != null) return false;
        if (photo != null ? !photo.equals(notebook.photo) : notebook.photo != null) return false;
        if (idCommonInformationForNotebook != null ? !idCommonInformationForNotebook.equals(notebook.idCommonInformationForNotebook) : notebook.idCommonInformationForNotebook != null)
            return false;
        if (idProcessorForNotebook != null ? !idProcessorForNotebook.equals(notebook.idProcessorForNotebook) : notebook.idProcessorForNotebook != null)
            return false;
        if (idConstructionForNotebook != null ? !idConstructionForNotebook.equals(notebook.idConstructionForNotebook) : notebook.idConstructionForNotebook != null)
            return false;
        if (idWeightAndSizeForNotebook != null ? !idWeightAndSizeForNotebook.equals(notebook.idWeightAndSizeForNotebook) : notebook.idWeightAndSizeForNotebook != null)
            return false;
        if (idScreenForNotebook != null ? !idScreenForNotebook.equals(notebook.idScreenForNotebook) : notebook.idScreenForNotebook != null)
            return false;
        if (idRamForNotebook != null ? !idRamForNotebook.equals(notebook.idRamForNotebook) : notebook.idRamForNotebook != null)
            return false;
        if (idDataForNotebook != null ? !idDataForNotebook.equals(notebook.idDataForNotebook) : notebook.idDataForNotebook != null)
            return false;
        if (idGraphicsForNotebook != null ? !idGraphicsForNotebook.equals(notebook.idGraphicsForNotebook) : notebook.idGraphicsForNotebook != null)
            return false;
        if (idCameraSoundForNotebook != null ? !idCameraSoundForNotebook.equals(notebook.idCameraSoundForNotebook) : notebook.idCameraSoundForNotebook != null)
            return false;
        if (idKeyboardAndTouchpadForNotebook != null ? !idKeyboardAndTouchpadForNotebook.equals(notebook.idKeyboardAndTouchpadForNotebook) : notebook.idKeyboardAndTouchpadForNotebook != null)
            return false;
        if (idFounctionsForNotebook != null ? !idFounctionsForNotebook.equals(notebook.idFounctionsForNotebook) : notebook.idFounctionsForNotebook != null)
            return false;
        if (idInterfaceForNotebook != null ? !idInterfaceForNotebook.equals(notebook.idInterfaceForNotebook) : notebook.idInterfaceForNotebook != null)
            return false;
        if (idBatteryForNotebook != null ? !idBatteryForNotebook.equals(notebook.idBatteryForNotebook) : notebook.idBatteryForNotebook != null)
            return false;
        if (idComplectationForNotebook != null ? !idComplectationForNotebook.equals(notebook.idComplectationForNotebook) : notebook.idComplectationForNotebook != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (idCommonInformationForNotebook != null ? idCommonInformationForNotebook.hashCode() : 0);
        result = 31 * result + (idProcessorForNotebook != null ? idProcessorForNotebook.hashCode() : 0);
        result = 31 * result + (idConstructionForNotebook != null ? idConstructionForNotebook.hashCode() : 0);
        result = 31 * result + (idWeightAndSizeForNotebook != null ? idWeightAndSizeForNotebook.hashCode() : 0);
        result = 31 * result + (idScreenForNotebook != null ? idScreenForNotebook.hashCode() : 0);
        result = 31 * result + (idRamForNotebook != null ? idRamForNotebook.hashCode() : 0);
        result = 31 * result + (idDataForNotebook != null ? idDataForNotebook.hashCode() : 0);
        result = 31 * result + (idGraphicsForNotebook != null ? idGraphicsForNotebook.hashCode() : 0);
        result = 31 * result + (idCameraSoundForNotebook != null ? idCameraSoundForNotebook.hashCode() : 0);
        result = 31 * result + (idKeyboardAndTouchpadForNotebook != null ? idKeyboardAndTouchpadForNotebook.hashCode() : 0);
        result = 31 * result + (idFounctionsForNotebook != null ? idFounctionsForNotebook.hashCode() : 0);
        result = 31 * result + (idInterfaceForNotebook != null ? idInterfaceForNotebook.hashCode() : 0);
        result = 31 * result + (idBatteryForNotebook != null ? idBatteryForNotebook.hashCode() : 0);
        result = 31 * result + (idComplectationForNotebook != null ? idComplectationForNotebook.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_common_information_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public CommonInformationForNotebook getCommonInformationForNotebookByIdCommonInformationForNotebook() {
        return commonInformationForNotebookByIdCommonInformationForNotebook;
    }

    public void setCommonInformationForNotebookByIdCommonInformationForNotebook(CommonInformationForNotebook commonInformationForNotebookByIdCommonInformationForNotebook) {
        this.commonInformationForNotebookByIdCommonInformationForNotebook = commonInformationForNotebookByIdCommonInformationForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_processor_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public ProcessorForNotebook getProcessorForNotebookByIdProcessorForNotebook() {
        return processorForNotebookByIdProcessorForNotebook;
    }

    public void setProcessorForNotebookByIdProcessorForNotebook(ProcessorForNotebook processorForNotebookByIdProcessorForNotebook) {
        this.processorForNotebookByIdProcessorForNotebook = processorForNotebookByIdProcessorForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_construction_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public ConstructionForNotebook getConstructionForNotebookByIdConstructionForNotebook() {
        return constructionForNotebookByIdConstructionForNotebook;
    }

    public void setConstructionForNotebookByIdConstructionForNotebook(ConstructionForNotebook constructionForNotebookByIdConstructionForNotebook) {
        this.constructionForNotebookByIdConstructionForNotebook = constructionForNotebookByIdConstructionForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_weight_and_size_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public WeightAndSizeForNotebook getWeightAndSizeForNotebookByIdWeightAndSizeForNotebook() {
        return weightAndSizeForNotebookByIdWeightAndSizeForNotebook;
    }

    public void setWeightAndSizeForNotebookByIdWeightAndSizeForNotebook(WeightAndSizeForNotebook weightAndSizeForNotebookByIdWeightAndSizeForNotebook) {
        this.weightAndSizeForNotebookByIdWeightAndSizeForNotebook = weightAndSizeForNotebookByIdWeightAndSizeForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_screen_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public ScreenForNotebook getScreenForNotebookByIdScreenForNotebook() {
        return screenForNotebookByIdScreenForNotebook;
    }

    public void setScreenForNotebookByIdScreenForNotebook(ScreenForNotebook screenForNotebookByIdScreenForNotebook) {
        this.screenForNotebookByIdScreenForNotebook = screenForNotebookByIdScreenForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_ram_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public RamForNotebook getRamForNotebookByIdRamForNotebook() {
        return ramForNotebookByIdRamForNotebook;
    }

    public void setRamForNotebookByIdRamForNotebook(RamForNotebook ramForNotebookByIdRamForNotebook) {
        this.ramForNotebookByIdRamForNotebook = ramForNotebookByIdRamForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_data_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public DataForNotebook getDataForNotebookByIdDataForNotebook() {
        return dataForNotebookByIdDataForNotebook;
    }

    public void setDataForNotebookByIdDataForNotebook(DataForNotebook dataForNotebookByIdDataForNotebook) {
        this.dataForNotebookByIdDataForNotebook = dataForNotebookByIdDataForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_graphics_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public GraphicsForNotebook getGraphicsForNotebookByIdGraphicsForNotebook() {
        return graphicsForNotebookByIdGraphicsForNotebook;
    }

    public void setGraphicsForNotebookByIdGraphicsForNotebook(GraphicsForNotebook graphicsForNotebookByIdGraphicsForNotebook) {
        this.graphicsForNotebookByIdGraphicsForNotebook = graphicsForNotebookByIdGraphicsForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_camera_sound_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public CameraSoundForNotebook getCameraSoundForNotebookByIdCameraSoundForNotebook() {
        return cameraSoundForNotebookByIdCameraSoundForNotebook;
    }

    public void setCameraSoundForNotebookByIdCameraSoundForNotebook(CameraSoundForNotebook cameraSoundForNotebookByIdCameraSoundForNotebook) {
        this.cameraSoundForNotebookByIdCameraSoundForNotebook = cameraSoundForNotebookByIdCameraSoundForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_keyboard_and_touchpad_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public KeyboardAndTouchpadForNotebook getKeyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook() {
        return keyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook;
    }

    public void setKeyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook(KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook) {
        this.keyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook = keyboardAndTouchpadForNotebookByIdKeyboardAndTouchpadForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_founctions_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public FounctionsForNotebook getFounctionsForNotebookByIdFounctionsForNotebook() {
        return founctionsForNotebookByIdFounctionsForNotebook;
    }

    public void setFounctionsForNotebookByIdFounctionsForNotebook(FounctionsForNotebook founctionsForNotebookByIdFounctionsForNotebook) {
        this.founctionsForNotebookByIdFounctionsForNotebook = founctionsForNotebookByIdFounctionsForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_interface_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public InterfaceForNotebook getInterfaceForNotebookByIdInterfaceForNotebook() {
        return interfaceForNotebookByIdInterfaceForNotebook;
    }

    public void setInterfaceForNotebookByIdInterfaceForNotebook(InterfaceForNotebook interfaceForNotebookByIdInterfaceForNotebook) {
        this.interfaceForNotebookByIdInterfaceForNotebook = interfaceForNotebookByIdInterfaceForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_battery_for_notebook", referencedColumnName = "id", insertable = false, updatable = false)
    public BatteryForNotebook getBatteryForNotebookByIdBatteryForNotebook() {
        return batteryForNotebookByIdBatteryForNotebook;
    }

    public void setBatteryForNotebookByIdBatteryForNotebook(BatteryForNotebook batteryForNotebookByIdBatteryForNotebook) {
        this.batteryForNotebookByIdBatteryForNotebook = batteryForNotebookByIdBatteryForNotebook;
    }

    @ManyToOne
    @JoinColumn(name = "id_complectation_for_notebook", referencedColumnName = "id" , insertable = false, updatable = false)
    public ComplectationForNotebook getComplectationForNotebookByIdComplectationForNotebook() {
        return complectationForNotebookByIdComplectationForNotebook;
    }

    public void setComplectationForNotebookByIdComplectationForNotebook(ComplectationForNotebook complectationForNotebookByIdComplectationForNotebook) {
        this.complectationForNotebookByIdComplectationForNotebook = complectationForNotebookByIdComplectationForNotebook;
    }
}
