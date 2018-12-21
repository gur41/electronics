package project.controller;

import last.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.note.*;
import project.service.Service;
import project.service.ServiceNote;


@Controller
public class NoteController {

    private ServiceNote noteService;
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


    @Autowired(required = true)
    @Qualifier(value = "noteService")
    public void setNoteService(ServiceNote noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/note_admin", method = RequestMethod.GET)
    public String showNote(Model model) {
        this.notebook = null;
        this.batteryForNotebook = null;
        this.cameraSoundForNotebook = null;
        this.commonInformationForNotebook = null;
        this.complectationForNotebook = null;
        this.constructionForNotebook = null;
        this.dataForNotebook = null;
        this.founctionsForNotebook = null;
        this.graphicsForNotebook = null;
        this.interfaceForNotebook = null;
        this.keyboardAndTouchpadForNotebook = null;
        this.processorForNotebook = null;
        this.ramForNotebook = null;
        this.screenForNotebook = null;
        this.weightAndSizeForNotebook = null;
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("notebook", new Notebook());
        return "note_admin";
    }

    @RequestMapping(value = "/note_admin/add", method = RequestMethod.POST)
    public String getNote(@ModelAttribute("user") User user, @ModelAttribute("notebook") Notebook notebook) {
        this.notebook = notebook;
        return "redirect:http://localhost:8080/note_admin_common";
    }

    @RequestMapping(value = "/note_admin_common", method = RequestMethod.GET)
    public String showCommon(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("common", new CommonInformationForNotebook());
        return "note/note_admin_common";
    }

    @RequestMapping(value = "/note_admin_common/add", method = RequestMethod.POST)
    public String geCommon(@ModelAttribute("common") CommonInformationForNotebook commonInformationForNotebook) {
        this.commonInformationForNotebook = commonInformationForNotebook;
        System.out.println("================");
        System.out.println(commonInformationForNotebook.getTransformer());
        this.noteService.add(this.notebook, this.batteryForNotebook, this.cameraSoundForNotebook, this.commonInformationForNotebook,
                this.complectationForNotebook, this.constructionForNotebook, this.dataForNotebook, this.founctionsForNotebook,
                this.graphicsForNotebook, this.interfaceForNotebook, this.keyboardAndTouchpadForNotebook,
                this.processorForNotebook, this.ramForNotebook, this.screenForNotebook, this.weightAndSizeForNotebook);
        if (UserController.getCurrentUser().getRole().equals("admin"))
            return "redirect:http://localhost:8080/carrier";
        else
            return "redirect:http://localhost:8080/client";
    }


}
