/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "PERJACT", schema = "PAYROLL")
public class PerjactSA implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    
    private PerjactSAPK id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_STD_HRS_PER_PAY")
    private BigDecimal horas;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_PERCENT")
    private BigDecimal porcentaje;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_FTE")
    private BigDecimal perjactFte;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_ACTIVITY_DATE")
    //@Temporal(TemporalType.DATE)
    //@JsonFormat(pattern = "dd-MM-yyyy")
    private String fechaActividad;

    public PerjactSA() {
        id = new PerjactSAPK();
    }

    public PerjactSA(PerjactSAPK id, BigDecimal horas, BigDecimal porcentaje, BigDecimal perjactFte, String fechaActividad) {
        this.id = id;
        this.horas = horas;
        this.porcentaje = porcentaje;
        this.perjactFte = perjactFte;
        this.fechaActividad = fechaActividad;
    }

    public PerjactSA(int perjactPidm, String perjactPosn, String perjactSuff, String efectiveDate, String codProvincia, String codActividad, String codSubact) {
        this.id = new PerjactSAPK(perjactPidm, perjactPosn, perjactSuff, efectiveDate,
                codProvincia, codActividad, codSubact);
    }

    public PerjactSAPK getId() {
        return id;
    }

    public void setId(PerjactSAPK id) {
        this.id = id;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {

        this.porcentaje = porcentaje;
    }

    public BigDecimal getPerjactFte() {
        return perjactFte;
    }

    public void setPerjactFte(BigDecimal perjactFte) {
        this.perjactFte = perjactFte;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }

    public void setFechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

}
