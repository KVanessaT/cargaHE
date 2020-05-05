/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import espe.edu.ec.carga_horaria.dao.CabPeriodoRepository;
import espe.edu.ec.carga_horaria.dao.CabeceraARepository;
import espe.edu.ec.carga_horaria.dao.CabeceraRepository;
import espe.edu.ec.carga_horaria.dao.PeriodoRepository;
import espe.edu.ec.carga_horaria.model.CabPeriodo;
import espe.edu.ec.carga_horaria.model.CabPeriodoPK;
import espe.edu.ec.carga_horaria.model.Cabecera;
import espe.edu.ec.carga_horaria.model.CabeceraA;
import espe.edu.ec.carga_horaria.model.CabeceraPK;
import espe.edu.ec.carga_horaria.model.Periodo;
import espe.edu.ec.carga_horaria.vo.SubActividadesDocenteVo;
import espe.edu.ec.carga_horaria.vo.apiVo;
import espe.edu.ec.carga_horaria.vo.cabeceraVo;
import espe.edu.ec.util.mensajes;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.springframework.format.annotation.DateTimeFormat;
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
public class CabeceraARest {

    @Autowired
    private CabeceraARepository cabRep;

    @Autowired
    private CabeceraRepository cabecera;

    @Autowired
    private apiVo cabeceraApiVo;

    @Autowired
    private PeriodoRepository periodoRep;

    @Autowired
    private CabPeriodoRepository cabPeriodoRep;

    @Autowired
    private apiVo subactivRep;

    private final mensajes msg = new mensajes();

    //Devuelve registro cabeceras
    @RequestMapping(value = "/cabsAll", method = RequestMethod.GET)
    public ResponseEntity<CabeceraA> getCab() throws SQLException {
        List<CabeceraA> res = cabRep.findAllCabecera();
        return new ResponseEntity(res, HttpStatus.OK);
    }

    //verificar si una actividad ya existe
    @RequestMapping(value = "/cb/{actividad}/{periodo}/{pidm}", method = RequestMethod.GET)
    public ResponseEntity verficarActividad(@PathVariable String actividad, @PathVariable String periodo, @PathVariable int pidm) throws SQLException {
        List<Cabecera> resp = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodoAndPzptcabperjactActividad(pidm, periodo, actividad);

        if (resp.isEmpty()) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

        //trae las cabeceras de una persona
    @RequestMapping(value = "/getCa/{actividad}/{periodo}/{pidm}", method = RequestMethod.GET)
    public ResponseEntity getCabeceras(@PathVariable String actividad, @PathVariable String periodo, @PathVariable int pidm) throws SQLException {
        List<Cabecera> resp = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodoAndPzptcabperjactActividad(pidm, periodo, actividad);

       
            return new ResponseEntity(resp, HttpStatus.OK);
        
    }
    
    
    //Funcion Eliminar 
    @Transactional
    @RequestMapping(value = "/dela/{pidm}/{periodo}/{actividad}", method = RequestMethod.DELETE)
    public ResponseEntity<Cabecera> deleteById(@PathVariable int pidm, @PathVariable String periodo, @PathVariable String actividad) throws SQLException {
        Cabecera deletepk = new Cabecera();
        deletepk.setPzptcabperjactPidm(pidm);
        deletepk.setPzptcabperjactPeriodo(periodo);
        deletepk.setPzptcabperjactActividad(actividad);
        cabecera.delete(deletepk);
        return new ResponseEntity(deletepk, HttpStatus.OK);
    }

    //@Transactional
    @RequestMapping(value = "/delCab/{pidm}/{periodo}/{actividad}", method = RequestMethod.DELETE)
    public ResponseEntity periodoDocentePidmCodPer(@PathVariable int pidm, @PathVariable String periodo, @PathVariable String actividad) throws SQLException {
        String dat = " where pzptcabperjact_pidm = '" + pidm + "' AND pzptcabperjact_periodo = '" + periodo + "' AND pzptcabperjact_actividad = '" + actividad + "'";
        List<cabeceraVo> resp = cabeceraApiVo.deleteCabecera(dat);
        return new ResponseEntity("eliminado", HttpStatus.OK);
    }

    @RequestMapping(value = "/delAct/{pidm}/{periodo}/{actividad}", method = RequestMethod.DELETE)
    public ResponseEntity<Cabecera> deleteAct(@PathVariable int pidm, @PathVariable String periodo, @PathVariable String actividad) throws SQLException {
        Cabecera deletepk = new Cabecera();
        deletepk.setPzptcabperjactPidm(pidm);
        deletepk.setPzptcabperjactPeriodo(periodo);
        deletepk.setPzptcabperjactActividad(actividad);
        cabecera.delete(deletepk);
        return new ResponseEntity(deletepk, HttpStatus.OK);
    }

    //Agregar una actividad.... sin uso... no probada
    @RequestMapping(value = "/cabs1", method = RequestMethod.POST)
    public ResponseEntity<CabeceraA> agregarCab(@RequestBody CabeceraA cabecer) throws SQLException {
        CabeceraA cabExist = new CabeceraA();
        cabExist = cabRep.findByid(cabecer.id);
        if (cabExist != null) {
            return new ResponseEntity(msg.ifexiste(), HttpStatus.CREATED);
        } else {
            CabeceraA cab = new CabeceraA();
            cab.setId(cabecer.getId());
            cab = cabRep.save(cab);
            return new ResponseEntity(cab, HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value = "/cabs", method = RequestMethod.POST)
    public ResponseEntity<CabeceraA> agregarCab1(@RequestBody CabeceraA cabecer) throws SQLException {
        CabeceraA pidm = new CabeceraA();
        CabeceraA actividad = new CabeceraA();
        CabeceraA periodo = new CabeceraA();

        cabRep.save(cabecer);
        return new ResponseEntity(msg.add(), HttpStatus.CREATED);
    }

   //
   @RequestMapping(value = "/cabsUPDATE/{pidm}/{codeP}/{codeA}", method = RequestMethod.GET)
    public ResponseEntity<CabeceraA> actualizarActividad(@PathVariable int pidm, @PathVariable String codeP, @PathVariable String codeA) throws SQLException {
        List<Cabecera> cd = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodoAndPzptcabperjactActividad(pidm, codeP, codeA);
        String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + codeP + "' AND P.perjact_jact_code= '" + codeA + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT, P.PERJACT_SUFF, P.PERJACT_POSN, P.PERJACT_PIDM, P.PERJACT_EFFECTIVE_DATE,  P.PERJACT_JACT_CODE, P.PERJACT_DICD_CODE ORDER BY PERJACT_ASTY_CODE";
        List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
        //Cabecera cabo = new Cabecera();
        int suma = 0;
        for (int i = 0; i < subact.size(); i++) {
            suma += subact.get(i).getPerjact_std_hrs_per_pay();
        }
        cd.get(0).setPzptcabperjactHoras(suma);
        //cabecera.save(cd.get(0));
        return new ResponseEntity(cd.get(0), HttpStatus.OK);

    }


    @RequestMapping(value = "/editarSubact", method = RequestMethod.PUT)
    public ResponseEntity<CabeceraA> actualizarSistema(@RequestBody  CabeceraA cur) {
        cabRep.save(cur);
        return new ResponseEntity(msg.update(), HttpStatus.OK);  
    }

        //    Funcion Actualizar 
//    @RequestMapping(value = "/cabsUPDATE/{pidm}/{codeP}/{codeA}", method = RequestMethod.PUT)
//    public ResponseEntity<CabeceraA> actualizarActividad(@PathVariable int pidm, @PathVariable String codeP, @PathVariable String codeA) throws SQLException {
//        String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + codeP + "' AND P.perjact_jact_code= '" + codeA + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT ORDER BY PERJACT_ASTY_CODE";
//        List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
//        int suma=0;
//        for(int i =0;i<subact.size();i++){
//           suma += subact.get(i).getPerjact_std_hrs_per_pay();
//        }
//        return new ResponseEntity(suma, HttpStatus.OK);
//    }
        //Depende del tipo de contrato que tenga el docente permite el ingreso de horas
        @RequestMapping(value = ("sumaHoraActividades/{pidm}/{periodo}/{horaSub}/{codDed}"), method = RequestMethod.GET)
        public ResponseEntity sumarHorasAct
        (@PathVariable
        int pidm,
                
        @PathVariable String periodo,
                
        @PathVariable int horaSub,
                
        @PathVariable String codDed) throws SQLException {
            List<Cabecera> ca = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodo(pidm, periodo);
            int fact = 0;
            int tiempo = 0;
            codDed.trim();
            if ("EC".equals(codDed)) {
                tiempo = 40;
            } else if ("EP".equals(codDed)) {
                tiempo = 19;
            } else if ("EX".equals(codDed)) {
                tiempo = 20;
            }
            for ( int i = 0; i < ca.size(); i++) {
                fact += ca.get(i).getPzptcabperjactHoras();
            }
            fact = fact + horaSub;

            if (fact <= tiempo && horaSub > 0) {
                return new ResponseEntity(true, HttpStatus.OK);
            } else {
                return new ResponseEntity(false, HttpStatus.OK);
            }
        }

        @RequestMapping(value = "/deleteAct/{pidm}/{periodo}/{actividad}", method = RequestMethod.DELETE)
        public ResponseEntity<CabPeriodo> deletePerAct
        (@PathVariable int pidm, 
        @PathVariable String periodo, 
        @PathVariable String actividad) throws SQLException {

            CabPeriodoPK delete = new CabPeriodoPK();
            delete.setPzptcabperjactPidm(pidm);
            delete.setPzptcabperjactPeriodo(periodo);
            delete.setPzptcabperjactActividad(actividad);
            cabPeriodoRep.deleteById(delete);
            return new ResponseEntity(msg.delete(), HttpStatus.OK);
        }

    }
