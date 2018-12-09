package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import project.clasess.Property;
import project.model.User;
import project.service.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {
    private Service userService;
    private static User currentUser;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(Service userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users/currentUser", method = RequestMethod.GET)
    public static User getCurrentUser(Model model) {
        model.addAttribute("user", currentUser);
        return currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }


    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.add(user);
        }else {
            this.userService.update(user);
        }
        currentUser = user;
        if (user.getRole().equals("Грузоперевозчик"))
            return "redirect:http://localhost:8080/carrier";
        else
            return "redirect:http://localhost:8080/client";
    }



    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("listUsers", this.userService.list());
        return "users";
    }



    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.remove(id);

        return "redirect:/users";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.list());

        return "users";
    }

    @RequestMapping(value = "/autorization/add", method = RequestMethod.POST)
    public String listUsers(@ModelAttribute("use") User user){
        if(this.userService.getByLogin(user.getLogin())) {
            currentUser = (User)this.userService.getByLoginP(user.getLogin());
            if(currentUser.getRole().equals("Грузовладелец"))
                return "redirect:http://localhost:8080/client";
            else
                return "redirect:http://localhost:8080/carrier";
        }
        else {
            return "redirect:/users";
        }
    }

    @RequestMapping(value = "autorization", method = RequestMethod.GET)
    public String listFlower(Model model){
        model.addAttribute("use", new User());
        return "autorization";
    }

    @RequestMapping(value = "exit", method = RequestMethod.GET)
    public String getNam(Model model) {
        model.addAttribute("use", new User());
        currentUser = null;
        return "redirect:http://localhost:8080/";
    }



}
