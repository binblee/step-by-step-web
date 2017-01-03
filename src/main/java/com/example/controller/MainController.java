package com.example.controller;

import com.example.model.Message;
import com.example.model.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;



@Controller
public class MainController {

    @Autowired
    private MessageRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model){

        ArrayList<Message> messages = new ArrayList<>();
        for(Message msg : repository.findAll()){
            messages.add(msg);
        }
        if(messages.size()>0){
            model.addAttribute("greeting",messages.get(0).getContent());
        }else{
            model.addAttribute("greeting","Greetings from cloud.");
        }
        return "index";
    }

}
