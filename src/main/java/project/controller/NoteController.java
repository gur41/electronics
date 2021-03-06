package project.controller;

import project.last.Note;
import project.last.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.OrderUserElectronic;
import project.model.note.*;
import project.service.Service;
import project.service.ServiceNote;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


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
    private Service orderUserElectronicService;

    private Integer id;
    private Integer idForOrder;

    @Autowired(required = true)
    @Qualifier(value = "orderUserElectronicService")
    public void setOrderUserElectronicService(Service orderUserElectronicService) {
        this.orderUserElectronicService = orderUserElectronicService;
    }




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
        if(UserController.getCurrentUser()!=null)
            if(UserController.getCurrentUser().getPassword().equals("admin"))
            return "note_admin";
            else return "/";
        else
            return  "/";
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
    public String geCommon(@ModelAttribute("user") User user, @ModelAttribute("common") CommonInformationForNotebook commonInformationForNotebook) {
        this.commonInformationForNotebook = commonInformationForNotebook;
        System.out.println("================");
        System.out.println(commonInformationForNotebook.getTransformer());
        /*this.noteService.add(this.notebook, this.batteryForNotebook, this.cameraSoundForNotebook, this.commonInformationForNotebook,
                this.complectationForNotebook, this.constructionForNotebook, this.dataForNotebook, this.founctionsForNotebook,
                this.graphicsForNotebook, this.interfaceForNotebook, this.keyboardAndTouchpadForNotebook,
                this.processorForNotebook, this.ramForNotebook, this.screenForNotebook, this.weightAndSizeForNotebook);
        if (UserController.getCurrentUser().getRole().equals("admin"))
            return "redirect:http://localhost:8080/carrier";
        else
            return "redirect:http://localhost:8080/client";*/
        return "redirect:http://localhost:8080/note_admin_processor";
    }

    @RequestMapping(value = "/note_admin_processor", method = RequestMethod.GET)
    public String showProcessor(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("processor", new ProcessorForNotebook());
        return "note/note_admin_processor";
    }

    @RequestMapping(value = "/note_admin_processor/add", method = RequestMethod.POST)
    public String getProcessor(@ModelAttribute("user") User user, @ModelAttribute("processor") ProcessorForNotebook processorForNotebook) {
        this.processorForNotebook = processorForNotebook;
        return "redirect:http://localhost:8080/note_admin_construction";
    }

    @RequestMapping(value = "/note_admin_construction", method = RequestMethod.GET)
    public String showConstruction(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("construction", new ConstructionForNotebook());
        return "note/note_admin_construction";
    }

    @RequestMapping(value = "/note_admin_construction/add", method = RequestMethod.POST)
    public String getConstruction(@ModelAttribute("user") User user, @ModelAttribute("construction") ConstructionForNotebook constructionForNotebook) {
        this.constructionForNotebook = constructionForNotebook;
        return "redirect:http://localhost:8080/note_admin_size";
    }


    @RequestMapping(value = "/note_admin_size", method = RequestMethod.GET)
    public String showSize(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("size", new WeightAndSizeForNotebook());
        return "note/note_admin_size";
    }

    @RequestMapping(value = "/note_admin_size/add", method = RequestMethod.POST)
    public String getSize(@ModelAttribute("user") User user, @ModelAttribute("size") WeightAndSizeForNotebook weightAndSizeForNotebook) {
        this.weightAndSizeForNotebook = weightAndSizeForNotebook;
        return "redirect:http://localhost:8080/note_admin_screen";
    }

    @RequestMapping(value = "/note_admin_screen", method = RequestMethod.GET)
    public String showScreen(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("screen", new ScreenForNotebook());
        return "note/note_admin_screen";
    }

    @RequestMapping(value = "/note_admin_screen/add", method = RequestMethod.POST)
    public String getScreen(@ModelAttribute("user") User user, @ModelAttribute("screen") ScreenForNotebook screenForNotebook) {
        this.screenForNotebook = screenForNotebook;
        return "redirect:http://localhost:8080/note_admin_ram";
    }

    @RequestMapping(value = "/note_admin_ram", method = RequestMethod.GET)
    public String showRam(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("ram", new RamForNotebook());
        return "note/note_admin_ram";
    }

    @RequestMapping(value = "/note_admin_ram/add", method = RequestMethod.POST)
    public String getRam(@ModelAttribute("user") User user, @ModelAttribute("ram") RamForNotebook ramForNotebook) {
        this.ramForNotebook = ramForNotebook;
        return "redirect:http://localhost:8080/note_admin_data";
    }

    @RequestMapping(value = "/note_admin_data", method = RequestMethod.GET)
    public String showData(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("data", new DataForNotebook());
        return "note/note_admin_data";
    }

    @RequestMapping(value = "/note_admin_data/add", method = RequestMethod.POST)
    public String getData(@ModelAttribute("user") User user, @ModelAttribute("data") DataForNotebook dataForNotebook) {
        this.dataForNotebook = dataForNotebook;
        return "redirect:http://localhost:8080/note_admin_graphics";
    }

    @RequestMapping(value = "/note_admin_graphics", method = RequestMethod.GET)
    public String showGraphics(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("graphics", new GraphicsForNotebook());
        return "note/note_admin_graphics";
    }

    @RequestMapping(value = "/note_admin_graphics/add", method = RequestMethod.POST)
    public String getGraphics(@ModelAttribute("user") User user, @ModelAttribute("graphics") GraphicsForNotebook graphicsForNotebook) {
        this.graphicsForNotebook = graphicsForNotebook;
        return "redirect:http://localhost:8080/note_admin_camera";
    }

    @RequestMapping(value = "/note_admin_camera", method = RequestMethod.GET)
    public String showCamera(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("camera", new CameraSoundForNotebook());
        return "note/note_admin_camera";
    }

    @RequestMapping(value = "/note_admin_camera/add", method = RequestMethod.POST)
    public String getCamera(@ModelAttribute("user") User user, @ModelAttribute("camera") CameraSoundForNotebook cameraSoundForNotebook) {
        this.cameraSoundForNotebook = cameraSoundForNotebook;
        return "redirect:http://localhost:8080/note_admin_keyboard";
    }

    @RequestMapping(value = "/note_admin_keyboard", method = RequestMethod.GET)
    public String showKeyboard(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("keyboard", new KeyboardAndTouchpadForNotebook());
        return "note/note_admin_keyboard";
    }

    @RequestMapping(value = "/note_admin_keyboard/add", method = RequestMethod.POST)
    public String getKeyBoard(@ModelAttribute("user") User user, @ModelAttribute("keyboard") KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook) {
        this.keyboardAndTouchpadForNotebook = keyboardAndTouchpadForNotebook;
        return "redirect:http://localhost:8080/note_admin_function";
    }

    @RequestMapping(value = "/note_admin_function", method = RequestMethod.GET)
    public String showFunction(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("function", new FounctionsForNotebook());
        return "note/note_admin_function";
    }

    @RequestMapping(value = "/note_admin_function/add", method = RequestMethod.POST)
    public String getFunction(@ModelAttribute("user") User user, @ModelAttribute("function") FounctionsForNotebook founctionsForNotebook) {
        this.founctionsForNotebook = founctionsForNotebook;
        return "redirect:http://localhost:8080/note_admin_interface";
    }

    @RequestMapping(value = "/note_admin_interface", method = RequestMethod.GET)
    public String showInterface(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("interface", new InterfaceForNotebook());
        return "note/note_admin_interface";
    }

    @RequestMapping(value = "/note_admin_interface/add", method = RequestMethod.POST)
    public String getInterface(@ModelAttribute("user") User user, @ModelAttribute("interface") InterfaceForNotebook interfaceForNotebook) {
        this.interfaceForNotebook = interfaceForNotebook;
        return "redirect:http://localhost:8080/note_admin_battery";
    }


    @RequestMapping(value = "/note_admin_battery", method = RequestMethod.GET)
    public String showBattery(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("battery", new BatteryForNotebook());
        return "note/note_admin_battery";
    }

    @RequestMapping(value = "/note_admin_battery/add", method = RequestMethod.POST)
    public String getBattery(@ModelAttribute("user") User user, @ModelAttribute("battery") BatteryForNotebook batteryForNotebook) {
        this.batteryForNotebook = batteryForNotebook;
        return "redirect:http://localhost:8080/note_admin_complectation";
    }

    @RequestMapping(value = "/note_admin_complectation", method = RequestMethod.GET)
    public String showComplectation(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("complectation", new ComplectationForNotebook());
        return "note/note_admin_complectation";
    }

    @RequestMapping(value = "/note_admin_complectaion/add", method = RequestMethod.POST)
    public String getComplectation(@ModelAttribute("user") User user, @ModelAttribute("complectation")ComplectationForNotebook complectationForNotebook) {
        this.complectationForNotebook = complectationForNotebook;
        this.notebook.setIdBatteryForNotebook(this.batteryForNotebook.getId());
        this.notebook.setIdCameraSoundForNotebook(this.cameraSoundForNotebook.getId());
        this.notebook.setIdCommonInformationForNotebook(this.commonInformationForNotebook.getId());
        this.notebook.setIdComplectationForNotebook(this.complectationForNotebook.getId());
        this.notebook.setIdConstructionForNotebook(this.constructionForNotebook.getId());
        this.notebook.setIdDataForNotebook(this.dataForNotebook.getId());
        this.notebook.setIdFounctionsForNotebook(this.founctionsForNotebook.getId());
        this.notebook.setIdGraphicsForNotebook(this.graphicsForNotebook.getId());
        this.notebook.setIdInterfaceForNotebook(this.interfaceForNotebook.getId());
        this.notebook.setIdKeyboardAndTouchpadForNotebook(this.keyboardAndTouchpadForNotebook.getId());
        this.notebook.setIdProcessorForNotebook(this.processorForNotebook.getId());
        this.notebook.setIdRamForNotebook(this.ramForNotebook.getId());
        this.notebook.setIdScreenForNotebook(this.screenForNotebook.getId());
        this.notebook.setIdWeightAndSizeForNotebook(this.weightAndSizeForNotebook.getId());
        this.noteService.add(this.notebook, this.batteryForNotebook, this.cameraSoundForNotebook, this.commonInformationForNotebook,
                this.complectationForNotebook, this.constructionForNotebook, this.dataForNotebook, this.founctionsForNotebook,
                this.graphicsForNotebook, this.interfaceForNotebook, this.keyboardAndTouchpadForNotebook,
                this.processorForNotebook, this.ramForNotebook, this.screenForNotebook, this.weightAndSizeForNotebook);
        return "redirect:http://localhost:8080/note_all";
    }

    @RequestMapping(value = "/note_all", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("listNote", this.noteService.getAllnote());
        return "note/note_all";
    }

    @RequestMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") Integer id, Model model){
        this.noteService.remove(id);
        return "redirect:http://localhost:8080/note_all";
    }

    @RequestMapping(value = "/note_change_price/{id}",  method = RequestMethod.POST)
    public String changePrice(@PathVariable("id") Integer id, Model model, HttpServletRequest httpServletRequest){
        String price = httpServletRequest.getParameter("price");
        System.out.println("/////////////////////////////////////////////");
        System.out.println(price);
        Notebook notebook = this.noteService.getById(id);
        notebook.setPrice(Double.parseDouble(price));
        this.noteService.update(notebook);
        return "redirect:http://localhost:8080/note_all";
    }

    @RequestMapping("/noteOne/{id}")
    public String showNoteOneId(@PathVariable("id") Integer id, Model model){
        this.id = id;
        return "redirect:http://localhost:8080/showOne";
    }


    @RequestMapping(value = "/showOne", method = RequestMethod.GET)
    public String showNoteOne(Model model) {
        Note note = this.noteService.getByIdNote(id);
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("notebook", note.getNotebook());
        model.addAttribute("common", note.getCommonInformationForNotebook());
        model.addAttribute("processor", note.getProcessorForNotebook());
        model.addAttribute("construction", note.getConstructionForNotebook());
        model.addAttribute("size", note.getWeightAndSizeForNotebook());
        model.addAttribute("screen", note.getScreenForNotebook());
        model.addAttribute("ram", note.getRamForNotebook());
        model.addAttribute("data", note.getDataForNotebook());
        model.addAttribute("graphics", note.getGraphicsForNotebook());
        model.addAttribute("camera", note.getCameraSoundForNotebook());
        model.addAttribute("keyboard", note.getKeyboardAndTouchpadForNotebook());
        model.addAttribute("function",note.getFounctionsForNotebook());
        model.addAttribute("interfac", note.getInterfaceForNotebook());
        model.addAttribute("battery", note.getBatteryForNotebook());
        model.addAttribute("complectation", note.getComplectationForNotebook());
        return "note/show_one_note";
    }

    @RequestMapping(value = "/add_order_for_note/{id}")
    public String showOrderElectronic(@PathVariable("id") Integer id,Model model) {
        this.idForOrder = id;
        return "redirect:http://localhost:8080/add_order_for_note";
    }

    @RequestMapping(value = "/add_order_for_note", method = RequestMethod.GET)
    public String showOrderElectronics(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("order", new OrderUserElectronic());
        return "note/add_order_for_note";
    }

    @RequestMapping(value = "/add_order_for_note/add/", method = RequestMethod.POST)
    public String getNewOrder(@ModelAttribute("user") User user, @ModelAttribute("order") OrderUserElectronic orderUserElectronic) {
        //this.interfaceForNotebook = interfaceForNotebook;
        System.out.println("666666666666666666666666666");
        System.out.println(orderUserElectronic.geteMail());
        System.out.println(UserController.getCurrentUser().getId());
        Notebook notebook = this.noteService.getById(idForOrder);
        orderUserElectronic.setName(notebook.getMark()+" "+notebook.getName());
        orderUserElectronic.setStatus("Оформлена");
        orderUserElectronic.setIdUserElectronics(user.getId());
        System.out.println(orderUserElectronic.geteMail());
        orderUserElectronic.setPrice(notebook.getPrice());
        this.orderUserElectronicService.add(orderUserElectronic);
        //+написать dao, service для добавленія заказа orderUserElectronics
        //+для пользователя просмотр заявок
        //+ізмененіе цены допісать
        //для админа измение статуса
        return "redirect:http://localhost:8080/show_my_orders";
    }

    @RequestMapping(value = "/show_my_orders", method = RequestMethod.GET)
    public String showOrderElectronicsUser(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        List<OrderUserElectronic> orderUserElectronics = this.orderUserElectronicService.list();
        List<OrderUserElectronic> orderUserElectronics1 = new ArrayList<OrderUserElectronic>();
        for (OrderUserElectronic o:orderUserElectronics) {
            if (o.getIdUserElectronics().equals(UserController.getCurrentUser().getId()))
                orderUserElectronics1.add(o);
        }
        model.addAttribute("orders", orderUserElectronics1);
        return "note/show_my_orders";
    }

    @RequestMapping("/changeStatusForElectronnicOrder/{string}")
    public String changeStatus(@PathVariable("string") String string, Model model){
        //this.orderUserService.add(new OrderUser());
        System.out.println("111111111111111111111111111111");
        System.out.println(string);
        String[] arg = string.split("_");
        String status = arg[1];
        Integer id = Integer.parseInt(arg[0]);
        /*System.out.println("id "+arg[0]);
        System.out.println("status "+status);
        System.out.println("id "+id);
        System.out.println("STRING : "+string);*/
        OrderUserElectronic orderUserElectronic = (OrderUserElectronic) this.orderUserElectronicService.getById(id);
        System.out.println(orderUserElectronic.geteMail());
        orderUserElectronic.setStatus(status);
        this.orderUserElectronicService.update(orderUserElectronic);
        System.out.println("status "+orderUserElectronic.getStatus());

        return "redirect:/admin_orders";
    }

    @RequestMapping(value = "/admin_orders", method = RequestMethod.GET)
    public String showCarrier(Model model){
        List<OrderUserElectronic> orderUsers = this.orderUserElectronicService.list();

        model.addAttribute("listOrderUserElectronics", orderUsers);
        model.addAttribute("user", UserController.getCurrentUser());
        return "note/admin_orders";
    }

    @RequestMapping(value = "/client_note_all", method = RequestMethod.GET)
    public String showAllClient(Model model) {
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("listNote", this.noteService.getAllnote());
        return "note/client_note_all";
    }

    @RequestMapping(value = "/show_one_admin", method = RequestMethod.GET)
    public String showNoteOneAdmin(Model model) {
        Note note = this.noteService.getByIdNote(id);
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("notebook", note.getNotebook());
        model.addAttribute("common", note.getCommonInformationForNotebook());
        model.addAttribute("processor", note.getProcessorForNotebook());
        model.addAttribute("construction", note.getConstructionForNotebook());
        model.addAttribute("size", note.getWeightAndSizeForNotebook());
        model.addAttribute("screen", note.getScreenForNotebook());
        model.addAttribute("ram", note.getRamForNotebook());
        model.addAttribute("data", note.getDataForNotebook());
        model.addAttribute("graphics", note.getGraphicsForNotebook());
        model.addAttribute("camera", note.getCameraSoundForNotebook());
        model.addAttribute("keyboard", note.getKeyboardAndTouchpadForNotebook());
        model.addAttribute("function",note.getFounctionsForNotebook());
        model.addAttribute("interfac", note.getInterfaceForNotebook());
        model.addAttribute("battery", note.getBatteryForNotebook());
        model.addAttribute("complectation", note.getComplectationForNotebook());
        return "note/show_one_note_admin_and_not";
    }

    @RequestMapping("/noteOneAdmin/{id}")
    public String showNoteOneIdAdmin(@PathVariable("id") Integer id, Model model){
        this.id = id;
        return "redirect:http://localhost:8080/show_one_admin";
    }





}
