/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "PZPTCABPERJACT", schema = "PAYROLL")
public class Cabecera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PZPTCABPERJACT_ACTIVIDAD ")
    private String pzptcabperjactActividad;
    
    @Column(name = "PZPTCABPERJACT_PERIODO ")
    private String pzptcabperjactPeriodo;
    
    @Column(name = "PZPTCABPERJACT_HORAS ")
    private int pzptcabperjactHoras;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PZPTCABPERJACT_FECHA_INICIO ")
    private Date pzptcabperjactFechaInicio;
    
    @Column(name = "PZPTCABPERJACT_UNIDAD_GESTION ")
    private String pzptcabperjactUnidadGestion;
    
    @Column(name = "PZPTCABPERJACT_RESPONSABLE ")
    private String pzptcabperjactResponsable;
    
    @Column(name = "PZPTCABPERJACT_PIDM ")
    private int pzptcabperjactPidm;

    public String getPzptcabperjactActividad() {
        return pzptcabperjactActividad;
    }

    public void setPzptcabperjactActividad(String pzptcabperjactActividad) {
        this.pzptcabperjactActividad = pzptcabperjactActividad;
    }

    public String getPzptcabperjactPeriodo() {
        return pzptcabperjactPeriodo;
    }

    public void setPzptcabperjactPeriodo(String pzptcabperjactPeriodo) {
        this.pzptcabperjactPeriodo = pzptcabperjactPeriodo;
    }

    public int getPzptcabperjactHoras() {
        return pzptcabperjactHoras;
    }

    public void setPzptcabperjactHoras(int pzptcabperjactHoras) {
        this.pzptcabperjactHoras = pzptcabperjactHoras;
    }

    public Date getPzptcabperjactFechaInicio() {
        return pzptcabperjactFechaInicio;
    }

    public void setPzptcabperjactFechaInicio(Date pzptcabperjactFechaInicio) {
        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
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

    public int getPzptcabperjactPidm() {
        return pzptcabperjactPidm;
    }

    public void setPzptcabperjactPidm(int pzptcabperjactPidm) {
        this.pzptcabperjactPidm = pzptcabperjactPidm;
    }

}
