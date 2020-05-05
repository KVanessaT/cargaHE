/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import espe.edu.ec.carga_horaria.vo.PosicionDocVo;
import espe.edu.ec.carga_horaria.vo.apiVo;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
public class PosicionDocRest {
     
     @Autowired
    private apiVo posVo;
    
     @RequestMapping(value = "/posn/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getPosnDoc(@PathVariable int pidm) throws SQLException {
        String dat = " WHERE (NBRJOBS_PICT_CODE IN ('ES','LS','CT','ED','LD') AND NBRJOBS_ECLS_CODE IN ('EC','EX','EP','')) AND NBRJOBS_PIDM = '"+ pidm +"' AND NBRJOBS_EFFECTIVE_DATE = (SELECT MAX(NBRJOBS_EFFECTIVE_DATE) FROM NBRJOBS where NBRJOBS_PIDM = '"+ pidm +"' AND NBRJOBS_ECLS_CODE IN ('EC','EX','EP','') AND (NBRJOBS_PICT_CODE IN ('ES','LS','CT','ED','LD'))) ";
        List<PosicionDocVo> resp = posVo.getPosn(dat);
    //resp.get(pidm).getNBRJOBS_ECLS_CODE();
        return new ResponseEntity(resp, HttpStatus.OK);
    }
}
