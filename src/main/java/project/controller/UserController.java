package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import project.last.User;
import project.service.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


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
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            user.setRole("client");
            if (!this.userService.getByLogin(user.getLogin())) {
                this.userService.add(user);
                System.out.println("___________________________________");
                System.out.println("ID :" + user.getId());
            } else return "redirect:/users";
        } else {
            user.setRole("client");
            this.userService.update(user);
        }
        currentUser = user;
        if (user.getRole().equals("admin"))
            return "redirect:http://localhost:8080/note_all";
        else
            return "redirect:http://localhost:8080/client_note_all";
    }


    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("listUsers", this.userService.list());
        return "users";
    }


    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.userService.remove(id);

        return "redirect:/users";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        ArrayList<String> loginList = new ArrayList<String>();
        for (User user : (ArrayList<User>)userService.list()){
            loginList.add(user.getLogin());
        }
        model.addAttribute("user", new User());
        model.addAttribute("loginList", loginList);

        return "users";
    }

    @RequestMapping(value = "/autorization/add", method = RequestMethod.POST)
    public String listUsers(@ModelAttribute("use") User user) {
        if (this.userService.getByLogin(user.getLogin())) {
            currentUser = (User) this.userService.getByLoginP(user.getLogin());
            if (currentUser.getPassword().equals(user.getPassword())) {
                if (currentUser.getRole().equals("Грузоперевозчик"))
                    return "redirect:http://localhost:8080/carrier";
                if (currentUser.getRole().equals("admin"))
                    return "redirect:http://localhost:8080/note_all";
                if (currentUser.getRole().equals("client"))
                    return "redirect:http://localhost:8080/client_note_all";
                return "redirect:http://localhost:8080/client_note_all";
            }
            else return "redirect:/users";
        } else {
            return "redirect:/users";
        }
    }

    @RequestMapping(value = "autorization", method = RequestMethod.GET)
    public String listFlower(Model model) {
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
