package project.service;


import last.InfoNote;
import last.Note;
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
        this.batteryForNotebookDao.add(batteryForNotebook);
        this.cameraSoundForNotebookDao.add(cameraSoundForNotebook);
        this.commonInformationForNotebookDao.add(commonInformationForNotebook);
        this.complectationForNotebookDao.add(complectationForNotebook);
        this.constructionForNotebookDao.add(constructionForNotebook);
        this.dataForNotebookDao.add(dataForNotebook);
        this.founctionsForNotebookDao.add(founctionsForNotebook);
        this.graphicsForNotebookDao.add(graphicsForNotebook);
        this.interfaceForNotebookDao.add(interfaceForNotebook);
        this.keyboardAndTouchpadForNotebookDao.add(keyboardAndTouchpadForNotebook);
        this.processorForNotebookDao.add(processorForNotebook);
        this.ramForNotebookDao.add(ramForNotebook);
        this.screenForNotebookDao.add(screenForNotebook);
        this.weightAndSizeForNotebookDao.add(weightAndSizeForNotebook);
        System.out.println("*************************************");
        this.notebookDao.add(notebook);
        System.out.println("ADD WORKS");
    }

    @Override
    public List<InfoNote> getAllnote() {
        List <InfoNote> infoNotes = new ArrayList<InfoNote>();
        List <Notebook> noteBook = this.notebookDao.list();
        //List <BatteryForNotebook> batteryForNotebook = this.batteryForNotebookDao.list();
        //List <CameraSoundForNotebook> cameraSoundForNotebook = this.cameraSoundForNotebookDao.list();
        //List <CommonInformationForNotebook> commonInformationForNotebook = this.commonInformationForNotebookDao.list();
        //List <ComplectationForNotebook> complectationForNotebook = this.complectationForNotebookDao.list();
        List <ConstructionForNotebook> constructionForNotebook = this.constructionForNotebookDao.list();
        List <DataForNotebook> dataForNotebook = this.dataForNotebookDao.list();
       // List <FounctionsForNotebook> founctionsForNotebook = this.founctionsForNotebookDao.list();
        List <GraphicsForNotebook> graphicsForNotebook = this.graphicsForNotebookDao.list();
        //List <InterfaceForNotebook> interfaceForNotebook = this.interfaceForNotebookDao.list();
        //List <KeyboardAndTouchpadForNotebook> keyboardAndTouchpadForNotebook = this.keyboardAndTouchpadForNotebookDao.list();
        List <ProcessorForNotebook> processorForNotebook = this.processorForNotebookDao.list();
        List <RamForNotebook> ramForNotebook = this.ramForNotebookDao.list();
        List <ScreenForNotebook> screenForNotebook = this.screenForNotebookDao.list();
        //List <WeightAndSizeForNotebook> weightAndSizeForNotebook = this.weightAndSizeForNotebookDao.list();
        for(int i=0;i<noteBook.size();i++){
            String str;
            str = screenForNotebook.get(i).getDiagonal()+"\" "+screenForNotebook.get(i).getResolution()+" "+screenForNotebook.get(i).getTechnologi()+", "+
                    processorForNotebook.get(i).getModelProcessor()+" "+processorForNotebook.get(i).getFrequency()+ " МГц, " + ramForNotebook.get(i).getVolume()+" ГБ, "+
                    dataForNotebook.get(i).getConfiguration()+" ГБ, "+graphicsForNotebook.get(i).getAdapter()+", цвет крышки "+constructionForNotebook.get(i).getColorCar()+" цвет корпуса "+constructionForNotebook.get(i).getColorBody();
            infoNotes.add(new InfoNote(noteBook.get(i).getId(),str, noteBook.get(i).getPhoto(),noteBook.get(i).getMark()+" "+noteBook.get(i).getName(),noteBook.get(i).getPrice()));
        }
        return infoNotes;
    }

    @Override
    public Note getByIdNote(Integer id) {
        return new Note(this.notebookDao.getById(id),
        this.batteryForNotebookDao.getById(id),
        this.cameraSoundForNotebookDao.getById(id),
        this.commonInformationForNotebookDao.getById(id),
        this.complectationForNotebookDao.getById(id),
        this.constructionForNotebookDao.getById(id),
        this.dataForNotebookDao.getById(id),
        this.founctionsForNotebookDao.getById(id),
        this.graphicsForNotebookDao.getById(id),
        this.interfaceForNotebookDao.getById(id),
        this.keyboardAndTouchpadForNotebookDao.getById(id),
        this.processorForNotebookDao.getById(id),
        this.ramForNotebookDao.getById(id),
        this.screenForNotebookDao.getById(id),
        this.weightAndSizeForNotebookDao.getById(id));
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
        this.batteryForNotebookDao.remove(id);
        this.cameraSoundForNotebookDao.remove(id);
        this.commonInformationForNotebookDao.remove(id);
        this.complectationForNotebookDao.remove(id);
        this.constructionForNotebookDao.remove(id);
        this.dataForNotebookDao.remove(id);
        this.founctionsForNotebookDao.remove(id);
        this.graphicsForNotebookDao.remove(id);
        this.interfaceForNotebookDao.remove(id);
        this.keyboardAndTouchpadForNotebookDao.remove(id);
        this.processorForNotebookDao.remove(id);
        this.ramForNotebookDao.remove(id);
        this.screenForNotebookDao.remove(id);
        this.weightAndSizeForNotebookDao.remove(id);
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

