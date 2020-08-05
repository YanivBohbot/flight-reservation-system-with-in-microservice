package com.yaniv.flightreservation.flightreservation.controllers;

import com.yaniv.flightreservation.flightreservation.entities.User;
import com.yaniv.flightreservation.flightreservation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class UserControllers {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/ShowReg")
    public String ShowRegistration(){
        return "login/registerUser";
    }

    @RequestMapping("/login")
    public String Showlogin(){
        return "login/login";
    }


    @RequestMapping(value="/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user)
    {
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password , ModelMap modelmap)
    {
        User user = userRepository.findbyEmail(email);

        if(user.getPassword().equals(password)){
            return "Findflight";
        }else{
            modelmap.addAttribute("msg","invalid user name or password . Please Try again ");
        }
        return "login/login";
    };
}
