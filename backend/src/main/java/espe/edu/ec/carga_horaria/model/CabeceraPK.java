/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vanessa
 */
@Embeddable
public class CabeceraPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(name = "PZPTCABPERJACT_ACTIVIDAD")
    public String pzptcabperjactActividad;

    //@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PZPTCABPERJACT_FECHA_INICIO")
   // @JsonFormat(pattern="dd-MM-yyyy")
    public Date pzptcabperjactFechaInicio;

    //@NotNull
    @Column(name = "PZPTCABPERJACT_PIDM")
    public int pzptcabperjactPidm;

//    @NotNull
//    @Column(name = "PZPTCABPERJACT_PERIODO")
//    public String pzptcabperjactPeriodo;
    public CabeceraPK() {
    }

    public CabeceraPK(String pzptcabperjactActividad, Date pzptcabperjactFechaInicio, int pzptcabperjactPidm) {
        this.pzptcabperjactActividad = pzptcabperjactActividad;
        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
        this.pzptcabperjactPidm = pzptcabperjactPidm;
    }

    
    
    public String getPzptcabperjactActividad() {
        return pzptcabperjactActividad;
    }

    public void setPzptcabperjactActividad(String pzptcabperjactActividad) {
        this.pzptcabperjactActividad = pzptcabperjactActividad;
    }

    public Date getPzptcabperjactFechaInicio() {
        return pzptcabperjactFechaInicio;
    }

    public void setPzptcabperjactFechaInicio(Date pzptcabperjactFechaInicio) {
        this.pzptcabperjactFechaInicio = pzptcabperjactFechaInicio;
    }

    public long getPzptcabperjactPidm() {
        return pzptcabperjactPidm;
    }

    public void setPzptcabperjactPidm(int pzptcabperjactPidm) {
        this.pzptcabperjactPidm = pzptcabperjactPidm;
    }

@Override
    public int hashCode()
    {
        int hash = 0;
        hash += (pzptcabperjactActividad != null ? pzptcabperjactActividad.hashCode() : 0);
        hash += (pzptcabperjactFechaInicio != null ? pzptcabperjactFechaInicio.hashCode() : 0);
        hash += (int) pzptcabperjactPidm;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof CabeceraPK))
        {
            return false;
        }
        CabeceraPK other = (CabeceraPK) object;
        if((this.pzptcabperjactActividad == null && other.pzptcabperjactActividad != null) || (this.pzptcabperjactActividad != null && !this.pzptcabperjactActividad.equals(other.pzptcabperjactActividad)))
        {
            return false;
        }
        if((this.pzptcabperjactFechaInicio == null && other.pzptcabperjactFechaInicio != null) || (this.pzptcabperjactFechaInicio != null && !this.pzptcabperjactFechaInicio.equals(other.pzptcabperjactFechaInicio)))
        {
            return false;
        }
        if(this.pzptcabperjactPidm != other.pzptcabperjactPidm)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CabeceraPK{" + "pzptcabperjactActividad=" + pzptcabperjactActividad + ", pzptcabperjactFechaInicio=" + pzptcabperjactFechaInicio + ", pzptcabperjactPidm=" + pzptcabperjactPidm + '}';
    }

}
