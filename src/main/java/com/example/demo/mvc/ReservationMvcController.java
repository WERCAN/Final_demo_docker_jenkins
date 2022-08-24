package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationMvcController {

    @GetMapping("/reservation")
    public String reservationPage(){
        System.out.println("Inside reservation Page");
        return "reservation";
    }
}
