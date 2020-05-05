/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.controller;

import espe.edu.ec.carga_horaria.dao.CabeceraRepository;
import espe.edu.ec.carga_horaria.dao.EmpleadoRepository;
import espe.edu.ec.carga_horaria.dao.PerjactRepository;
import espe.edu.ec.carga_horaria.dao.SubactPerjactRepository;
import espe.edu.ec.carga_horaria.dao.SubactividadesRepository;
import espe.edu.ec.carga_horaria.model.Cabecera;
import espe.edu.ec.carga_horaria.model.Empleado;
import espe.edu.ec.carga_horaria.model.Perjact;
import espe.edu.ec.carga_horaria.model.PerjactSA;
import espe.edu.ec.carga_horaria.model.PerjactSAPK;
import espe.edu.ec.carga_horaria.model.subActividades;
import espe.edu.ec.carga_horaria.vo.apiVo;
import espe.edu.ec.carga_horaria.vo.SubActividadesDocenteVo;
import espe.edu.ec.carga_horaria.vo.subactividadesVo;
import espe.edu.ec.util.mensajes;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
public class SubactividadesRest {

    @Autowired
    private SubactividadesRepository subactividadesRep;

    @Autowired
    private SubactPerjactRepository perjactRep;

    @Autowired
    private apiVo subactivRep;

    @Autowired
    private CabeceraRepository cabecera;

    @Autowired
    private PerjactRepository perRep;

    private final mensajes msg = new mensajes();

    @Autowired
    private EmpleadoRepository emp;

    //Lista todas las subactividades
    @RequestMapping(value = "/allSubactividades", method = RequestMethod.GET)
    public ResponseEntity<subActividades> listaSubActividades() {
        List<subActividades> subactividades = subactividadesRep.findAllSubActividades();
        if (subactividades.isEmpty()) {
            return new ResponseEntity("No encontrado", HttpStatus.OK);
        } else {
            return new ResponseEntity(subactividades, HttpStatus.OK);
        }
    }

    //lista las subactividades del docente dependiendo de actividad
    @RequestMapping(value = "/subA/{data1}/{data2}/{data3}", method = RequestMethod.GET)
    public ResponseEntity subactividadesDoc(@PathVariable String data1, @PathVariable String data2, @PathVariable String data3) throws SQLException {
        String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + data1 + "' AND ST.STVTERM_CODE = '" + data2 + "' AND P.perjact_jact_code= '" + data3 + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT, P.PERJACT_SUFF, P.PERJACT_POSN, P.PERJACT_PIDM, P.PERJACT_EFFECTIVE_DATE,  P.PERJACT_JACT_CODE, P.PERJACT_DICD_CODE ORDER BY PERJACT_ASTY_CODE";
        List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
        return new ResponseEntity(subact, HttpStatus.OK);
    }

    //horas totales subactividades dependiendo actividad
    @RequestMapping(value = "/sumaH/{pidm}/{codeP}/{codeA}", method = RequestMethod.GET)
    public ResponseEntity horasSubactividades(@PathVariable int pidm, @PathVariable String codeP, @PathVariable String codeA) throws SQLException {
        String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + codeP + "' AND P.perjact_jact_code= '" + codeA + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT,  P.PERJACT_SUFF,P.PERJACT_POSN, P.PERJACT_PIDM, P.PERJACT_EFFECTIVE_DATE,  P.PERJACT_JACT_CODE, P.PERJACT_DICD_CODE ORDER BY PERJACT_ASTY_CODE";
        List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
        int horas = 0;
        for (int i = 0; i < subact.size(); i++) {
            horas += subact.get(i).getPerjact_std_hrs_per_pay();
        }
        return new ResponseEntity(horas, HttpStatus.OK);
    }

    //suma horas totales de subactividades
    @RequestMapping(value = "/sumaHT/{pidm}/{codeP}", method = RequestMethod.GET)
    public ResponseEntity horasSubact(@PathVariable int pidm, @PathVariable String codeP) throws SQLException {
        String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + codeP + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT, P.PERJACT_SUFF, P.PERJACT_POSN, P.PERJACT_PIDM, P.PERJACT_EFFECTIVE_DATE,  P.PERJACT_JACT_CODE, P.PERJACT_DICD_CODE ORDER BY PERJACT_ASTY_CODE";
        List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
        int horas = 0;
        for (int i = 0; i < subact.size(); i++) {
            horas += subact.get(i).getPerjact_std_hrs_per_pay();
        }
        return new ResponseEntity(horas, HttpStatus.OK);
    }

    //Lista subactividades de acuerdo a cod actividad
    @RequestMapping(value = "/sub/{codAct}", method = RequestMethod.GET)
    public ResponseEntity subactCodeActividad(@PathVariable String codAct) throws SQLException {
        String dato = " where stvasty_Code LIKE '" + codAct + "%'";
        List<subactividadesVo> subact = subactivRep.getSubActByCodeAct(dato);

        return new ResponseEntity(subact, HttpStatus.OK);
    }

    //verifica horas para eliminar
    @RequestMapping(value = "/getSub/{pidm}/{periodo}/{actividad}", method = RequestMethod.GET)
    public ResponseEntity<SubActividadesDocenteVo> searchByPidm(@PathVariable long pidm, @PathVariable String periodo, @PathVariable String actividad) throws SQLException {
        String suba = " where P.perjact_activity_date >= ST.stvterm_start_date AND P.perjact_activity_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + periodo + "' AND P.perjact_jact_code= '" + actividad + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT, P.PERJACT_SUFF, P.PERJACT_POSN, P.PERJACT_PIDM, P.PERJACT_EFFECTIVE_DATE,  P.PERJACT_JACT_CODE, P.PERJACT_DICD_CODE ORDER BY PERJACT_ASTY_CODE";
        List<SubActividadesDocenteVo> subAc = subactivRep.getSubAct(suba);
        int horas = 0;

        for (int i = 0; i < subAc.size(); i++) {

            horas += subAc.get(i).getPerjact_std_hrs_per_pay();
        }
        if (horas == 0) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    //verificar si una actividad ya existe SE DEMORA MUCHO EN RESPONDER
    @RequestMapping(value = "/suba/{pidm}/{fecha}/{codSub}", method = RequestMethod.GET)
    public ResponseEntity verficarSubActividad(@PathVariable int pidm, @PathVariable @DateTimeFormat(iso = ISO.DATE) Date fecha, @PathVariable String codSub) throws SQLException {
        List<Perjact> resp = perjactRep.findByPerjactPidmAndPerjactEffectiveDateAndPerjactAstyCode(pidm, fecha, codSub);

        if (resp.isEmpty()) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    //verifica si una subactividad ya existe
    @RequestMapping(value = "/su/{pidm}/{codeP}/{codeS}", method = RequestMethod.GET)
    public ResponseEntity verifsubactividadesDoc(@PathVariable int pidm, @PathVariable String codeP, @PathVariable String codeS) throws SQLException {
        String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + codeP + "' AND P.perjact_asty_code= '" + codeS + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT, P.PERJACT_SUFF, P.PERJACT_POSN, P.PERJACT_PIDM, P.PERJACT_EFFECTIVE_DATE,  P.PERJACT_JACT_CODE, P.PERJACT_DICD_CODE ORDER BY PERJACT_ASTY_CODE";
        List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
        if (subact.isEmpty()) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
        //return new ResponseEntity(subact, HttpStatus.OK);
    }

    //lista las subactividades del docente dependiendo de actividad
    //lista las subactividades del docente dependiendo de actividad
    @RequestMapping(value = "/subActividad/{pidm}/{codeP}/{codeA}/{horas}", method = RequestMethod.GET)
    public ResponseEntity subactividades(@PathVariable int pidm, @PathVariable String codeP, @PathVariable String codeA, @PathVariable int horas) throws SQLException {
        /// String dato = " where P.perjact_effective_date >= ST.stvterm_start_date AND P.perjact_effective_date <= ST.stvterm_end_date AND P.PERJACT_PIDM = '" + pidm + "' AND ST.STVTERM_CODE = '" + codeP + "' AND P.perjact_jact_code= '" + codeA + "' GROUP BY P.PERJACT_ASTY_CODE, S.STVASTY_DESC, S.STVASTY_ACTIVITY_DATE,P.PERJACT_STD_HRS_PER_PAY, P.PERJACT_PERCENT ORDER BY PERJACT_ASTY_CODE";
        // List<SubActividadesDocenteVo> subact = subactivRep.getSubAct(dato);
        Empleado gh = emp.findByPebemplPidm(pidm);
        String codDed = gh.getCodeDedicacion();
        List<Cabecera> resp = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodo(pidm, codeP);
        int horaSb = 0;
        for (int i = 0; i < resp.size(); i++) {
            horaSb += resp.get(i).getPzptcabperjactHoras();
        }
        horaSb = horaSb + horas;

        int tiempo = 0;
        codDed.trim();
        if ("EC".equals(codDed)) {
            tiempo = 40;
        } else if ("EP".equals(codDed)) {
            tiempo = 19;
        } else if ("EX".equals(codDed)) {
            tiempo = 20;
        }

        if (horaSb <= tiempo && horas > 0) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    //para editar una subactividad, horasTotales se restan las horas de la subac y se suma la nueva hora
    @RequestMapping(value = "/horasEditar/{pidm}/{codeP}/{codeA}/{horaS}/{horaN}", method = RequestMethod.GET)
    public ResponseEntity horasEditar(@PathVariable int pidm, @PathVariable String codeP, @PathVariable String codeA, @PathVariable int horaS, @PathVariable int horaN) throws SQLException {
        Empleado gh = emp.findByPebemplPidm(pidm);
        String codDed = gh.getCodeDedicacion();
        List<Cabecera> resp = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodo(pidm, codeP);
 
        int horaT = 0;
        for (int i = 0; i < resp.size(); i++) {
           
            horaT += resp.get(i).getPzptcabperjactHoras();
        }
        horaT = horaT -horaS+ horaN;
        
        int tiempo = 0;
        codDed.trim();
        if ("EC".equals(codDed)) {
            tiempo = 40;
        } else if ("EP".equals(codDed)) {
            tiempo = 19;
        } else if ("EX".equals(codDed)) {
            tiempo = 20;
        }

        if (horaT <= tiempo && horaN > 0) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    
    
    
    @RequestMapping(value = "/getSubact", method = RequestMethod.PUT)
    public ResponseEntity buscarSubact(@RequestBody Perjact cur) throws SQLException {
        PerjactSAPK git = new PerjactSAPK();

        git.setPidm(cur.getPerjactPidm());
        git.setPerjactSuff(cur.getPerjactSuff());
        git.setPerjactPosn(cur.getPerjactPosn());
        git.setEfectiveDate(cur.getPerjactEffectiveDate());
        git.setCodSubact(cur.getPerjactAstyCode());
        git.setCodActividad(cur.getPerjactJactCode());
        git.setCodProvincia(cur.getPerjactDicdCode());
        Optional<PerjactSA> ejek = perRep.findById(git);
        if (ejek != null) {
            return new ResponseEntity(ejek, HttpStatus.OK);
        } else {
            return new ResponseEntity(msg.notfound(), HttpStatus.OK);
        }
    }

//    @Transactional
//    @RequestMapping(value = "/editSSAA", method = RequestMethod.PUT)
//    public ResponseEntity<PerjactSA> editaSubctivi(@Valid @RequestBody PerjactSA corre) throws SQLException {
//        //Optional<PerjactSA> employee = perRep.findById(new PerjactSAPK());
//        PerjactSA employee = new PerjactSA();
//        //employee.setId(new PerjactSAPK());
//        employee.getId();
//        corre.getId().getPidm();
//        corre.getId().getPerjactPosn();
//        corre.getId().getPerjactSuff();
//        corre.getId().getEfectiveDate();
//        corre.getId().getCodProvincia();
//        corre.getId().getCodActividad();
//        corre.getId().getCodSubact();
//        // employee.getClass();
//        // employee.setId(corre.getId());
//        employee.setHoras(corre.getHoras());
//        employee.setPorcentaje(corre.getPorcentaje());
//        employee.setPerjactFte(corre.getPerjactFte());
//        employee.setFechaActividad(corre.getFechaActividad());
//        perRep.save(employee);
//        perRep.save(corre);
//        System.out.println(corre.getId());
//        return new ResponseEntity(corre, HttpStatus.OK);
//    }
    @Transactional
    @RequestMapping(value = "/editSSAA", method = RequestMethod.PUT)
    public ResponseEntity<PerjactSA> editaSubctivi(@Valid @RequestBody PerjactSA corre) throws SQLException {
        //Optional<PerjactSA> employee = perRep.findById(new PerjactSAPK());
        PerjactSA employee = new PerjactSA();
        //employee.setId(new PerjactSAPK());
        employee.getId().getPidm();
        employee.getId().getPerjactPosn();
        employee.getId().getPerjactSuff();
        employee.getId().getEfectiveDate();
        employee.getId().getCodProvincia();
        employee.getId().getCodActividad();
        employee.getId().getCodSubact();

        employee.setHoras(corre.getHoras());
        employee.setPorcentaje(corre.getPorcentaje());
        employee.setPerjactFte(corre.getPerjactFte());
        employee.setFechaActividad(corre.getFechaActividad());
        //employee.setId(corre.getId());

//        corre.getId();
//        corre.setHoras(employee.getHoras());
//        corre.setPorcentaje(employee.getPorcentaje());
//        corre.setPerjactFte(employee.getPerjactFte());
//        corre.setFechaActividad(employee.getFechaActividad());
        perRep.save(employee);
        perRep.save(corre);
        System.out.println(corre.getHoras());
        return new ResponseEntity(corre, HttpStatus.OK);
    }

    @RequestMapping(value = "/dele/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PerjactSA> deleteS(@PathVariable PerjactSAPK id) throws SQLException {
        PerjactSAPK delete = new PerjactSAPK();
        delete.setPidm(id.pidm);
        delete.setPerjactPosn(id.perjactPosn);
        delete.setPerjactSuff(id.perjactSuff);
        delete.setEfectiveDate(id.efectiveDate);
        delete.setCodProvincia(id.codProvincia);
        delete.setCodActividad(id.codActividad);
        delete.setCodSubact(id.codSubact);

        PerjactSA azul = new PerjactSA();
        azul.setId(id);

        //azul.getHoras();
        //azul.setPorcentaje(BigDecimal.ONE);
        //azul.setPerjactFte(BigDecimal.ZERO);
        //azul.getFechaActividad();
        perRep.deleteById(id);
        //perRep.delete(azul);
        return new ResponseEntity(msg.delete(), HttpStatus.OK);
    }

    //ELIMINAR SUBACTIVIDAD
    @RequestMapping(value = "/deletSub/{pidm}/{posn}/{suff}/{Edate}/{codPro}/{codA}/{codS}", method = RequestMethod.DELETE)
    public ResponseEntity<PerjactSA> deleteSAct(@PathVariable int pidm, @PathVariable String posn, @PathVariable String suff, @PathVariable String Edate,
            @PathVariable String codPro, @PathVariable String codA, @PathVariable String codS) throws SQLException {
        System.out.println(pidm + "," + posn + "," + suff + "," + Edate + "," + codPro + "," + codA + "," + codS);

        PerjactSAPK delete = new PerjactSAPK();
        delete.setPidm(pidm);
        delete.setPerjactPosn(posn);
        delete.setPerjactSuff(suff);
        delete.setEfectiveDate(Edate);
        delete.setCodProvincia(codPro);
        delete.setCodActividad(codA);
        delete.setCodSubact(codS);
        perRep.deleteById(delete);
        System.out.println(pidm + "," + posn + "," + suff + "," + Edate + "," + codPro + "," + codA + "," + codS);
        return new ResponseEntity(msg.delete(), HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/editSub/{pidm}/{posn}/{suff}/{Edate}/{codPro}/{codA}/{codS}", method = RequestMethod.GET)
    public ResponseEntity<PerjactSA> EditAct(@PathVariable int pidm, @PathVariable String posn, @PathVariable String suff, @PathVariable String Edate,
            @PathVariable String codPro, @PathVariable String codA, @PathVariable String codS) throws SQLException {
        //System.out.println(pidm + "," + posn + "," + suff + "," + Edate + "," + codPro + "," + codA + "," + codS);

        PerjactSAPK editar = new PerjactSAPK();
        editar.setPidm(pidm);
        editar.setPerjactPosn(posn);
        editar.setPerjactSuff(suff);
        editar.setEfectiveDate(Edate);
        editar.setCodProvincia(codPro);
        editar.setCodActividad(codA);
        editar.setCodSubact(codS);
        
        PerjactSA objeto =  perRep.findByid(editar);
        //Optional<PerjactSA> objeto1 = perRep.findById(editar);
        System.out.println(pidm + "," + posn + "," + suff + "," + Edate + "," + codPro + "," + codA + "," + codS);
        return new ResponseEntity(objeto, HttpStatus.OK);
    }
    

    //Editar SUBACTIVIDAD
    @Transactional
    @RequestMapping(value = "/updaSub", method = RequestMethod.PUT)
    public ResponseEntity<PerjactSA> upSAct(@Valid @RequestBody PerjactSA corre) throws SQLException {

        //PerjactSAPK edit = new PerjactSAPK();
        PerjactSA sa = new PerjactSA();
        sa.getId();
        sa.setHoras(sa.getHoras());
        sa.setPorcentaje(sa.getPorcentaje());
        sa.setPerjactFte(sa.getPerjactFte());
        sa.setFechaActividad(sa.getFechaActividad());
        //corre.getId();
        //corre.getHoras();
        //perRep.save(corre);
        perRep.save(sa);
        return new ResponseEntity(corre, HttpStatus.OK);
    }

    //conteo de horas de actividades
    @RequestMapping(value = "/trueFalse/{pidm}/{codeP}", method = RequestMethod.GET)
    public ResponseEntity TrueFalse(@PathVariable int pidm, @PathVariable String codeP) throws SQLException {
        Empleado gh = emp.findByPebemplPidm(pidm);
        String codDed = gh.getCodeDedicacion();
        List<Cabecera> resp = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodo(pidm, codeP);
        int gu = 0;
        for (int i = 0; i < resp.size(); i++) {
            gu += resp.get(i).getPzptcabperjactHoras();
        }

        int tiempo = 0;
        codDed.trim();
        if ("EC".equals(codDed)) {
            tiempo = 40;
        } else if ("EP".equals(codDed)) {
            tiempo = 19;
        } else if ("EX".equals(codDed)) {
            tiempo = 20;
        }
        if (gu == tiempo) {
            return new ResponseEntity(1, HttpStatus.OK);
        } else if (gu >= (tiempo * 0.5)) {
            return new ResponseEntity(2, HttpStatus.OK);
        } else {
            return new ResponseEntity(3, HttpStatus.OK);

        }

    }

//conteo de horas de actividades
    @RequestMapping(value = "/porcen/{pidm}/{codeP}", method = RequestMethod.GET)
    public ResponseEntity porcent(@PathVariable int pidm, @PathVariable String codeP) throws SQLException {
        Empleado gh = emp.findByPebemplPidm(pidm);
        String codDed = gh.getCodeDedicacion();
        List<Cabecera> resp = cabecera.findByPzptcabperjactPidmAndPzptcabperjactPeriodo(pidm, codeP);
        int gu = 0;

        int porcen = 0;
        for (int i = 0; i < resp.size(); i++) {
            gu += resp.get(i).getPzptcabperjactHoras();
        }
        int tiempo = 0;
        codDed.trim();
        if ("EC".equals(codDed)) {
            tiempo = 40;
        } else if ("EP".equals(codDed)) {
            tiempo = 19;
        } else if ("EX".equals(codDed)) {
            tiempo = 20;
        }

        porcen = ((gu * 100) / tiempo);
        
        return new ResponseEntity(porcen, HttpStatus.OK);

    }


    
}
