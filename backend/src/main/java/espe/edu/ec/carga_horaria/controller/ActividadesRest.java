/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import espe.edu.ec.carga_horaria.dao.ActividadesRepository;
import espe.edu.ec.carga_horaria.model.Actividades;
import espe.edu.ec.carga_horaria.vo.actividadesDocentesVo;
import espe.edu.ec.carga_horaria.vo.actividadesVo;
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
public class ActividadesRest {

    @Autowired
    private ActividadesRepository actividadesRep;

    @Autowired
    private apiVo activRep;
    
    @Autowired
    private actividadesDocentesVo actDocRep;

    @RequestMapping(value = "/allactividades", method = RequestMethod.GET)
    public ResponseEntity<Actividades> listaActividades() {
        List<Actividades> actividadess = actividadesRep.findAllActividades();
        if (actividadess.isEmpty()) {
            return new ResponseEntity("No encontrado", HttpStatus.OK);
        } else {
            return new ResponseEntity(actividadess, HttpStatus.OK);
        }
    }

    //actividades con un determinado periodo y pidm
    @RequestMapping(value = "/act/{periodo}/{pidm}", method = RequestMethod.GET)
    public ResponseEntity actividadesDocentem(@PathVariable String periodo, @PathVariable long pidm) throws SQLException {
        String dato = " where pzptcabperjact_periodo = '" + periodo + "' AND pzptcabperjact_Pidm = '" + pidm + "' GROUP BY pzptcabperjact_actividad,ptvjact_desc, pzptcabperjact_periodo,pzptcabperjact_horas,pzptcabperjact_unidad_gestion, pzptcabperjact_responsable, pzptcabperjact_pidm ORDER BY pzptcabperjact_Actividad";
        List<actividadesVo> actv = activRep.getActDoc(dato);
        return new ResponseEntity(actv, HttpStatus.OK);
    }
    
    
    
    
 
}




