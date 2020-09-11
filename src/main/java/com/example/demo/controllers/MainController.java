package com.example.demo.controllers;

import com.example.demo.ExpandedForm;
import com.example.demo.WhichAreIN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;


@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @PostMapping("/")
    public String Second(@RequestParam String action,
                         @RequestParam String[] a1,
                         @RequestParam String[] a2,
                         Model model) {
        //String[] a1={"arp", "live", "strong"};
        //String[] a2={"lively", "alive", "harp", "sharp", "armstrong"};
        ExpandedForm E = new ExpandedForm();
        WhichAreIN W = new WhichAreIN();

        switch (action) {
            case "Задача №1":
                if (a1.length>0 && a2.length>0) {
                    model.addAttribute("Exercise", W.inArray(a1, a2));
                    model.addAttribute("act", "Решение " + action + " для:"
                            + Arrays.toString(a1)+ " " + Arrays.toString(a2));
                }
                else {
                    model.addAttribute("Exercise", "Ошибка: поле 'Ввод' не заполнено");
                }
                break;
            case "Задача №2":
                if (a1.length>0) {
                    model.addAttribute("act", "Решение " + action + " для  " + a1[0]);
                    model.addAttribute("Exercise", E.Expanded(a1));
                }
                else {
                    model.addAttribute("Exercise", "Ошибка: поле 'Ввод' не заполнено");
                }
                break;
            default:
                model.addAttribute ("Exercise", "Не выбран номер задачи!");
        }
        return "home";
    }

/*
    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }


    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("uploaded")));
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили";
            } catch (Exception e) {
                return "Вам не удалось загрузить"+ e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить, потому что файл пустой.";
        }
    }

*/
}
