package project.service;

import last.InfoNote;
import last.Note;
import project.model.note.*;

import java.util.List;

public interface ServiceNote extends Service<Notebook>{
    public void add(Notebook notebook, BatteryForNotebook batteryForNotebook, CameraSoundForNotebook cameraSoundForNotebook, CommonInformationForNotebook commonInformationForNotebook,
                  ComplectationForNotebook complectationForNotebook, ConstructionForNotebook constructionForNotebook, DataForNotebook dataForNotebook,
                  FounctionsForNotebook founctionsForNotebook, GraphicsForNotebook graphicsForNotebook, InterfaceForNotebook interfaceForNotebook, KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook,
                  ProcessorForNotebook processorForNotebook, RamForNotebook ramForNotebook, ScreenForNotebook screenForNotebook, WeightAndSizeForNotebook weightAndSizeForNotebook);


    public List<InfoNote> getAllnote();

    public Note getByIdNote(Integer id);
}

