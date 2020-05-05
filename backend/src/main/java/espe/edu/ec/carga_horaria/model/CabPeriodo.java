/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "PZPTCABPERJACT", schema = "PAYROLL")
public class CabPeriodo {
    
    @EmbeddedId
    public CabPeriodoPK id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "PZPTCABPERJACT_FECHA_INICIO")
    private Date pzptcabperjactFechaInicio;
    
    @Basic(optional = false)
    @Column(name = "PZPTCABPERJACT_HORAS")
    private BigDecimal pzptcabperjactHoras;
    
    @Column(name = "PZPTCABPERJACT_UNIDAD_GESTION")
    private String pzptcabperjactUnidadGestion;
    
    //@Size(max = 30)
    @Column(name = "PZPTCABPERJACT_RESPONSABLE")
    private String pzptcabperjactResponsable;

    public CabPeriodo() {
    }

    public CabPeriodo(Date pzptcabperjactFechaInicio, BigDecimal pzptcabperjactHoras, String pzptcabperjactUnidadGestion, String pzptcabperjactResponsable) {
        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
        this.pzptcabperjactHoras = pzptcabperjactHoras;
        this.pzptcabperjactUnidadGestion = pzptcabperjactUnidadGestion;
        this.pzptcabperjactResponsable = pzptcabperjactResponsable;
    }

    public CabPeriodoPK getId() {
        return id;
    }

    public void setId(CabPeriodoPK id) {
        this.id = id;
    }

    public Date getPzptcabperjactFechaInicio() {
        return pzptcabperjactFechaInicio;
    }

    public void setPzptcabperjactFechaInicio(Date pzptcabperjactFechaInicio) {
        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
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

   
}
