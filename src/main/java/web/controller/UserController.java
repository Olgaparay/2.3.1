package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDaoImp;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserDaoImp userDaoImp;

    public UserController(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @GetMapping()
    public String index(Model model){// получим всех людей из дао
        model.addAttribute("user", userDaoImp.index());
        return "users/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){ //получаем одного человека по айди и передаем на отоброжение в представление
        model.addAttribute("user", userDaoImp.show(id));
        return "users/show";
    }
}
