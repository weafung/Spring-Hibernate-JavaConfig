package weafung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import weafung.dto.UserLoginDTO;
import weafung.dto.UserRegisterDTO;
import weafung.exception.UserLoginException;
import weafung.exception.UserRegisterException;
import weafung.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController {

    private static final String INSERT_USER_SQL = "INSERT INTO java_user (username, password) VALUES (?, ?)";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String showRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String register(UserRegisterDTO userRegisterDTO, Model model) {
        try {
            userService.save(userRegisterDTO);
            model.addAttribute("msg","Initialize successfully.");
            return "redirect:/User/Login";
        } catch (UserRegisterException e) {
            model.addAttribute("msg",e.getMessage());
            return "register";
        }
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String showLoginPage(@RequestParam("msg") String msg, Model model) {
        if (msg.equals("Initialize successfully.")) {
            model.addAttribute("msg", msg);
        }
        return "login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(UserLoginDTO userLoginDTO, Model model) {
        try {
            userService.login(userLoginDTO);
            model.addAttribute("msg","Login successfully");
        } catch (UserLoginException e) {
            model.addAttribute("msg", e.getMessage());
        }
        return "login";
    }
}
