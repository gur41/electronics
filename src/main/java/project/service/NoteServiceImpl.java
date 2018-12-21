package project.service;


import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.note.CommonInformationForNotebook;
import project.model.note.*;

import java.util.ArrayList;
import java.util.List;

public class NoteServiceImpl implements ServiceNote {
    private Dao<Notebook> notebookDao;
    private Dao<CommonInformationForNotebook> commonInformationForNotebookDao;
    private Dao<ComplectationForNotebook> complectationForNotebookDao;
    private Dao<ConstructionForNotebook> constructionForNotebookDao;
    private Dao<DataForNotebook> dataForNotebookDao;
    private Dao<FounctionsForNotebook> founctionsForNotebookDao;
    private Dao<GraphicsForNotebook> graphicsForNotebookDao;
    private Dao<InterfaceForNotebook> interfaceForNotebookDao;
    private Dao<KeyboardAndTouchpadForNotebook> keyboardAndTouchpadForNotebookDao;
    private Dao<BatteryForNotebook> batteryForNotebookDao;
    private Dao<ProcessorForNotebook> processorForNotebookDao;
    private Dao<RamForNotebook> ramForNotebookDao;
    private Dao<ScreenForNotebook> screenForNotebookDao;
    private Dao<WeightAndSizeForNotebook> weightAndSizeForNotebookDao;
    private Dao<CameraSoundForNotebook> cameraSoundForNotebookDao;


    @Override
    @Transactional
    public void add(Notebook notebook, BatteryForNotebook batteryForNotebook, CameraSoundForNotebook cameraSoundForNotebook, CommonInformationForNotebook commonInformationForNotebook,
                    ComplectationForNotebook complectationForNotebook, ConstructionForNotebook constructionForNotebook, DataForNotebook dataForNotebook,
                    FounctionsForNotebook founctionsForNotebook, GraphicsForNotebook graphicsForNotebook, InterfaceForNotebook interfaceForNotebook, KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook,
                    ProcessorForNotebook processorForNotebook, RamForNotebook ramForNotebook, ScreenForNotebook screenForNotebook, WeightAndSizeForNotebook weightAndSizeForNotebook) {
        /*this.notebookDao.add(notebook);
        this.batteryForNotebookDao.add();*/
        System.out.println("*************************************");
        System.out.println("ADD WORKS");
    }

    @Override
    public void add(Notebook notebook) {

    }

    @Override
    @Transactional
    public void update(Notebook notebook) {
        this.notebookDao.update(notebook);
    }



    @Override
    @Transactional
    public void remove(int id) {
        this.notebookDao.remove(id);
    }

    @Override
    @Transactional
    public Notebook getById(int id) {
        return this.notebookDao.getById(id);
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.notebookDao.getByLogin(login);
    }

    @Override
    public Notebook getByLoginP(String login) {
        return this.notebookDao.getByLoginP(login);
    }


    @Override
    @Transactional
    public List<Notebook> find(String name) {
        List list = new ArrayList();
        for (Notebook purch:this.notebookDao.list()) {
            if(purch.getMark().equals(name))
                list.add(purch);
        }
        return list;
    }

    @Override
    @Transactional
    public List<Notebook> list() {
        return this.notebookDao.list();
    }

    public void setCameraSoundForNotebookDao(Dao<CameraSoundForNotebook> cameraSoundForNotebookDao) {
        this.cameraSoundForNotebookDao = cameraSoundForNotebookDao;
    }

    public void setComplectationForNotebookDao(Dao<ComplectationForNotebook> complectationForNotebookDao) {
        this.complectationForNotebookDao = complectationForNotebookDao;
    }

    public void setConstructionForNotebookDao(Dao<ConstructionForNotebook> constructionForNotebookDao) {
        this.constructionForNotebookDao = constructionForNotebookDao;
    }

    public void setDataForNotebookDao(Dao<DataForNotebook> dataForNotebookDao) {
        this.dataForNotebookDao = dataForNotebookDao;
    }

    public void setFounctionsForNotebookDao(Dao<FounctionsForNotebook> founctionsForNotebookDao) {
        this.founctionsForNotebookDao = founctionsForNotebookDao;
    }

    public void setGraphicsForNotebookDao(Dao<GraphicsForNotebook> graphicsForNotebookDao) {
        this.graphicsForNotebookDao = graphicsForNotebookDao;
    }

    public void setInterfaceForNotebookDao(Dao<InterfaceForNotebook> interfaceForNotebookDao) {
        this.interfaceForNotebookDao = interfaceForNotebookDao;
    }

    public void setKeyboardAndTouchpadForNotebookDao(Dao<KeyboardAndTouchpadForNotebook> keyboardAndTouchpadForNotebookDao) {
        this.keyboardAndTouchpadForNotebookDao = keyboardAndTouchpadForNotebookDao;
    }

    public void setBatteryForNotebookDao(Dao<BatteryForNotebook> batteryForNotebookDao) {
        this.batteryForNotebookDao = batteryForNotebookDao;
    }

    public void setProcessorForNotebookDao(Dao<ProcessorForNotebook> processorForNotebookDao) {
        this.processorForNotebookDao = processorForNotebookDao;
    }

    public void setRamForNotebookDao(Dao<RamForNotebook> ramForNotebookDao) {
        this.ramForNotebookDao = ramForNotebookDao;
    }

    public void setScreenForNotebookDao(Dao<ScreenForNotebook> screenForNotebookDao) {
        this.screenForNotebookDao = screenForNotebookDao;
    }

    public void setWeightAndSizeForNotebookDao(Dao<WeightAndSizeForNotebook> weightAndSizeForNotebookDao) {
        this.weightAndSizeForNotebookDao = weightAndSizeForNotebookDao;
    }

    public void setCommonInformationForNotebookDao(Dao<CommonInformationForNotebook> commonInformationForNotebookDao) {
        this.commonInformationForNotebookDao = commonInformationForNotebookDao;
    }

    public void setNotebookDao(Dao notebookDao) {
        this.notebookDao = notebookDao;
    }
}

