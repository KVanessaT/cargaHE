/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vanessa
 */
@RestController
@RequestMapping("/sch")

public class hola {
@RequestMapping("/hola")
    String hellow() {
        return "holaK";
    }
}
