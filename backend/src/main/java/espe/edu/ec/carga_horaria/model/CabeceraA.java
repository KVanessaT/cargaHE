/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "PZPTCABPERJACT", schema = "PAYROLL")
public class CabeceraA implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    public CabeceraPK id;
    
   
    @Column(name = "PZPTCABPERJACT_PERIODO")
    public String pzptcabperjactPeriodo;
    
    @Basic(optional = false)
    @Column(name = "PZPTCABPERJACT_HORAS")
    private BigDecimal pzptcabperjactHoras;
    
    @Column(name = "PZPTCABPERJACT_UNIDAD_GESTION")
    private String pzptcabperjactUnidadGestion;
    
    //@Size(max = 30)
    @Column(name = "PZPTCABPERJACT_RESPONSABLE")
    private String pzptcabperjactResponsable;

   
     public CabeceraA() {
        id = new CabeceraPK();
    }
    
    public CabeceraA(String pzptcabperjactPeriodo, BigDecimal pzptcabperjactHoras, String pzptcabperjactUnidadGestion, String pzptcabperjactResponsable) {
        this.pzptcabperjactPeriodo = pzptcabperjactPeriodo;
        this.pzptcabperjactHoras = pzptcabperjactHoras;
        this.pzptcabperjactUnidadGestion = pzptcabperjactUnidadGestion;
        this.pzptcabperjactResponsable = pzptcabperjactResponsable;
    }

    
    
    public CabeceraPK getId() {
        return id;
    }

    public void setId(CabeceraPK id) {
        this.id = id;
    }

    public String getPzptcabperjactPeriodo() {
        return pzptcabperjactPeriodo;
    }

    public void setPzptcabperjactPeriodo(String pzptcabperjactPeriodo) {
        this.pzptcabperjactPeriodo = pzptcabperjactPeriodo;
    }

    public BigDecimal getPzptcabperjactHoras() {
        return pzptcabperjactHoras;
    }

    public void setPzptcabperjactHoras(BigDecimal pzptcabperjactHoras) {
        this.pzptcabperjactHoras = pzptcabperjactHoras;
    }

    public String getPzptcabperjactUnidadGestion() {
        return pzptcabperjactUnidadGestion;
    }

    public void setPzptcabperjactUnidadGestion(String pzptcabperjactUnidadGestion) {
        this.pzptcabperjactUnidadGestion = pzptcabperjactUnidadGestion;
    }

    public String getPzptcabperjactResponsable() {
        return pzptcabperjactResponsable;
    }

    public void setPzptcabperjactResponsable(String pzptcabperjactResponsable) {
        this.pzptcabperjactResponsable = pzptcabperjactResponsable;
    }
//
//

//    public CabeceraA(CabeceraPK id, Date pzptcabperjactFechaInicio, BigDecimal pzptcabperjactHoras, String pzptcabperjactUnidadGestion) {
//        this.id = id;
//        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
//        this.pzptcabperjactHoras = pzptcabperjactHoras;
//        this.pzptcabperjactUnidadGestion = pzptcabperjactUnidadGestion;
//    }
//
//    public CabeceraPK getId() {
//        return id;
//    }
//
//    public void setId(CabeceraPK id) {
//        this.id = id;
//    }
//
//    public Date getPzptcabperjactFechaInicio() {
//        return pzptcabperjactFechaInicio;
//    }
//
//    public void setPzptcabperjactFechaInicio(Date pzptcabperjactFechaInicio) {
//        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
//    }
//
//    public BigDecimal getPzptcabperjactHoras() {
//        return pzptcabperjactHoras;
//    }
//
//    public void setPzptcabperjactHoras(BigDecimal pzptcabperjactHoras) {
//        this.pzptcabperjactHoras = pzptcabperjactHoras;
//    }
//
//    public String getPzptcabperjactUnidadGestion() {
//        return pzptcabperjactUnidadGestion;
//    }
//
//    public void setPzptcabperjactUnidadGestion(String pzptcabperjactUnidadGestion) {
//        this.pzptcabperjactUnidadGestion = pzptcabperjactUnidadGestion;
//    }
//
//    public String getPzptcabperjactResponsable() {
//        return pzptcabperjactResponsable;
//    }
//
//    public void setPzptcabperjactResponsable(String pzptcabperjactResponsable) {
//        this.pzptcabperjactResponsable = pzptcabperjactResponsable;
//    }

}
