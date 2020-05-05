/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vanessa
 */

@Embeddable
public class CabPeriodoPK implements Serializable{
     
    @NotNull
    @Column(name = "PZPTCABPERJACT_ACTIVIDAD")
    private String pzptcabperjactActividad;

    @NotNull
    @Column(name = "PZPTCABPERJACT_PIDM")  
    private int pzptcabperjactPidm;

    @NotNull
    @Column(name = "PZPTCABPERJACT_PERIODO")
    private String pzptcabperjactPeriodo;

    public CabPeriodoPK() {
    }

    public CabPeriodoPK(String pzptcabperjactActividad, int pzptcabperjactPidm, String pzptcabperjactPeriodo) {
        this.pzptcabperjactActividad = pzptcabperjactActividad;
        this.pzptcabperjactPidm = pzptcabperjactPidm;
        this.pzptcabperjactPeriodo = pzptcabperjactPeriodo;
    }

    public String getPzptcabperjactActividad() {
        return pzptcabperjactActividad;
    }

    public void setPzptcabperjactActividad(String pzptcabperjactActividad) {
        this.pzptcabperjactActividad = pzptcabperjactActividad;
    }

    public int getPzptcabperjactPidm() {
        return pzptcabperjactPidm;
    }

    public void setPzptcabperjactPidm(int pzptcabperjactPidm) {
        this.pzptcabperjactPidm = pzptcabperjactPidm;
    }

    public String getPzptcabperjactPeriodo() {
        return pzptcabperjactPeriodo;
    }

    public void setPzptcabperjactPeriodo(String pzptcabperjactPeriodo) {
        this.pzptcabperjactPeriodo = pzptcabperjactPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pzptcabperjactActividad);
        hash = 53 * hash + this.pzptcabperjactPidm;
        hash = 53 * hash + Objects.hashCode(this.pzptcabperjactPeriodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CabPeriodoPK other = (CabPeriodoPK) obj;
        if (this.pzptcabperjactPidm != other.pzptcabperjactPidm) {
            return false;
        }
        if (!Objects.equals(this.pzptcabperjactActividad, other.pzptcabperjactActividad)) {
            return false;
        }
        if (!Objects.equals(this.pzptcabperjactPeriodo, other.pzptcabperjactPeriodo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CabPeriodoPK{" + "pzptcabperjactActividad=" + pzptcabperjactActividad + ", pzptcabperjactPidm=" + pzptcabperjactPidm + ", pzptcabperjactPeriodo=" + pzptcabperjactPeriodo + '}';
    }
    
    
}
