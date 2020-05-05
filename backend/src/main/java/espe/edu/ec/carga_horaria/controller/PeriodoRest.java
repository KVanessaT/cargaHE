/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import espe.edu.ec.carga_horaria.dao.PeriodoRepository;
import espe.edu.ec.carga_horaria.model.Periodo;
import espe.edu.ec.carga_horaria.vo.apiVo;
import espe.edu.ec.carga_horaria.vo.periodoVo;
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
public class PeriodoRest {

    @Autowired
    private PeriodoRepository periodoRep;

    @Autowired
    private apiVo periodRep;

    @RequestMapping(value = "/allperiodos", method = RequestMethod.GET)
    public ResponseEntity<Periodo> listaPeriodos() {
        List<Periodo> periodos = periodoRep.findAllPeriodos();
        if (periodos.isEmpty()) {
            return new ResponseEntity("No encontrado", HttpStatus.OK);
        } else {
            return new ResponseEntity(periodos, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/per/{data1}/{data2}", method = RequestMethod.GET)
    public ResponseEntity periodoDocentePidmCodPer(@PathVariable int data1, @PathVariable String data2) throws SQLException {
        String dat = " where pzptcabperjact_pidm = '" + data1 + "' AND stvterm_code = '" + data2 + "' group by stvterm_code, stvterm_desc, stvterm_start_date,stvterm_end_date";
        List<periodoVo> periodo2 = periodRep.getPeriodo(dat);
        return new ResponseEntity(periodo2, HttpStatus.OK);
    }

    @RequestMapping(value = "/per/{data1}", method = RequestMethod.GET)
    public ResponseEntity periodosActualesDoc(@PathVariable int data1) throws SQLException {
        String dat = " where stvterm_code = sobterm_term_code AND pzptcabperjact_pidm = '" + data1 + "' AND sobterm.sobterm_Dynamic_Sched_Term_Ind ='Y' group by stvterm_code, stvterm_desc, stvterm_start_date,stvterm_end_date order by stvterm_code";
        List<periodoVo> period = periodRep.getPeriodo(dat);
        return new ResponseEntity(period, HttpStatus.OK);
    }

    @RequestMapping(value = "/codePeriodo/{codePer}", method = RequestMethod.GET)
    public ResponseEntity datosPer(@PathVariable String codePer) throws SQLException {
        Periodo per = periodoRep.findByStvtermCode(codePer);
        return new ResponseEntity(per, HttpStatus.OK);
    }
}
