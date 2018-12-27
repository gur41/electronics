package project.last;

import project.model.note.*;

public class Note {
    private Notebook notebook = null;
    private BatteryForNotebook batteryForNotebook = null;
    private CameraSoundForNotebook cameraSoundForNotebook = null;
    private CommonInformationForNotebook commonInformationForNotebook = null;
    private ComplectationForNotebook complectationForNotebook = null;
    private ConstructionForNotebook constructionForNotebook = null;
    private DataForNotebook dataForNotebook = null;
    private FounctionsForNotebook founctionsForNotebook = null;
    private GraphicsForNotebook graphicsForNotebook = null;
    private InterfaceForNotebook interfaceForNotebook = null;
    private KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook = null;
    private ProcessorForNotebook processorForNotebook = null;
    private RamForNotebook ramForNotebook = null;
    private ScreenForNotebook screenForNotebook = null;
    private WeightAndSizeForNotebook weightAndSizeForNotebook = null;

    public Note(Notebook notebook, BatteryForNotebook batteryForNotebook, CameraSoundForNotebook cameraSoundForNotebook, CommonInformationForNotebook commonInformationForNotebook, ComplectationForNotebook complectationForNotebook, ConstructionForNotebook constructionForNotebook, DataForNotebook dataForNotebook, FounctionsForNotebook founctionsForNotebook, GraphicsForNotebook graphicsForNotebook, InterfaceForNotebook interfaceForNotebook, KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook, ProcessorForNotebook processorForNotebook, RamForNotebook ramForNotebook, ScreenForNotebook screenForNotebook, WeightAndSizeForNotebook weightAndSizeForNotebook) {
        this.notebook = notebook;
        this.batteryForNotebook = batteryForNotebook;
        this.cameraSoundForNotebook = cameraSoundForNotebook;
        this.commonInformationForNotebook = commonInformationForNotebook;
        this.complectationForNotebook = complectationForNotebook;
        this.constructionForNotebook = constructionForNotebook;
        this.dataForNotebook = dataForNotebook;
        this.founctionsForNotebook = founctionsForNotebook;
        this.graphicsForNotebook = graphicsForNotebook;
        this.interfaceForNotebook = interfaceForNotebook;
        this.keyboardAndTouchpadForNotebook = keyboardAndTouchpadForNotebook;
        this.processorForNotebook = processorForNotebook;
        this.ramForNotebook = ramForNotebook;
        this.screenForNotebook = screenForNotebook;
        this.weightAndSizeForNotebook = weightAndSizeForNotebook;
    }

    public Note() {
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public BatteryForNotebook getBatteryForNotebook() {
        return batteryForNotebook;
    }

    public void setBatteryForNotebook(BatteryForNotebook batteryForNotebook) {
        this.batteryForNotebook = batteryForNotebook;
    }

    public CameraSoundForNotebook getCameraSoundForNotebook() {
        return cameraSoundForNotebook;
    }

    public void setCameraSoundForNotebook(CameraSoundForNotebook cameraSoundForNotebook) {
        this.cameraSoundForNotebook = cameraSoundForNotebook;
    }

    public CommonInformationForNotebook getCommonInformationForNotebook() {
        return commonInformationForNotebook;
    }

    public void setCommonInformationForNotebook(CommonInformationForNotebook commonInformationForNotebook) {
        this.commonInformationForNotebook = commonInformationForNotebook;
    }

    public ComplectationForNotebook getComplectationForNotebook() {
        return complectationForNotebook;
    }

    public void setComplectationForNotebook(ComplectationForNotebook complectationForNotebook) {
        this.complectationForNotebook = complectationForNotebook;
    }

    public ConstructionForNotebook getConstructionForNotebook() {
        return constructionForNotebook;
    }

    public void setConstructionForNotebook(ConstructionForNotebook constructionForNotebook) {
        this.constructionForNotebook = constructionForNotebook;
    }

    public DataForNotebook getDataForNotebook() {
        return dataForNotebook;
    }

    public void setDataForNotebook(DataForNotebook dataForNotebook) {
        this.dataForNotebook = dataForNotebook;
    }

    public FounctionsForNotebook getFounctionsForNotebook() {
        return founctionsForNotebook;
    }

    public void setFounctionsForNotebook(FounctionsForNotebook founctionsForNotebook) {
        this.founctionsForNotebook = founctionsForNotebook;
    }

    public GraphicsForNotebook getGraphicsForNotebook() {
        return graphicsForNotebook;
    }

    public void setGraphicsForNotebook(GraphicsForNotebook graphicsForNotebook) {
        this.graphicsForNotebook = graphicsForNotebook;
    }

    public InterfaceForNotebook getInterfaceForNotebook() {
        return interfaceForNotebook;
    }

    public void setInterfaceForNotebook(InterfaceForNotebook interfaceForNotebook) {
        this.interfaceForNotebook = interfaceForNotebook;
    }

    public KeyboardAndTouchpadForNotebook getKeyboardAndTouchpadForNotebook() {
        return keyboardAndTouchpadForNotebook;
    }

    public void setKeyboardAndTouchpadForNotebook(KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook) {
        this.keyboardAndTouchpadForNotebook = keyboardAndTouchpadForNotebook;
    }

    public ProcessorForNotebook getProcessorForNotebook() {
        return processorForNotebook;
    }

    public void setProcessorForNotebook(ProcessorForNotebook processorForNotebook) {
        this.processorForNotebook = processorForNotebook;
    }

    public RamForNotebook getRamForNotebook() {
        return ramForNotebook;
    }

    public void setRamForNotebook(RamForNotebook ramForNotebook) {
        this.ramForNotebook = ramForNotebook;
    }

    public ScreenForNotebook getScreenForNotebook() {
        return screenForNotebook;
    }

    public void setScreenForNotebook(ScreenForNotebook screenForNotebook) {
        this.screenForNotebook = screenForNotebook;
    }

    public WeightAndSizeForNotebook getWeightAndSizeForNotebook() {
        return weightAndSizeForNotebook;
    }

    public void setWeightAndSizeForNotebook(WeightAndSizeForNotebook weightAndSizeForNotebook) {
        this.weightAndSizeForNotebook = weightAndSizeForNotebook;
    }
}
