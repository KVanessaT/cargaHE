/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import espe.edu.ec.carga_horaria.dao.PerjactRepository;
import espe.edu.ec.carga_horaria.dao.SubactPerjactRepository;
import espe.edu.ec.carga_horaria.model.Perjact;
import espe.edu.ec.carga_horaria.model.PerjactSA;
import espe.edu.ec.util.mensajes;
import java.sql.SQLException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vanessa
 */
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/sch")
public class PerjactRest {

    @Autowired
    private PerjactRepository jactRep;

    @Autowired
    private SubactPerjactRepository subjactRep;
    private final mensajes msg = new mensajes();

    //agregar una actividad
    @RequestMapping(value = "/perjact", method = RequestMethod.POST)
    public ResponseEntity<PerjactSA> agregarPerjact(@RequestBody PerjactSA cabecer) throws SQLException {

        jactRep.save(cabecer);
        return new ResponseEntity(msg.add(), HttpStatus.CREATED);
    }

    @Transactional
    @RequestMapping(value = "/editarSub", method = RequestMethod.PUT)
    public ResponseEntity<PerjactSA> actualizarSistema(@RequestBody PerjactSA cur) throws SQLException {
        jactRep.save(cur);
        return new ResponseEntity(cur, HttpStatus.OK);
    }

    @RequestMapping(value = "/editS", method = RequestMethod.PUT)
    public ResponseEntity<PerjactSA> editaSubctivi(@Valid @RequestBody PerjactSA corre) throws SQLException {
        PerjactSA po = new PerjactSA();

        jactRep.save(corre);
        return new ResponseEntity(corre, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/ed", method = RequestMethod.PUT)
    public ResponseEntity<Perjact> actualizarSistema(@RequestBody Perjact cur) throws SQLException {
        subjactRep.save(cur);
        return new ResponseEntity(cur, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/editarSAc", method = RequestMethod.PUT)
    public ResponseEntity<PerjactSA> updSAC(@RequestBody  PerjactSA cur) {
        jactRep.save(cur);
        return new ResponseEntity(msg.update(), HttpStatus.OK);  
    }
}
