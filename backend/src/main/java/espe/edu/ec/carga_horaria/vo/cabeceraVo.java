/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Vanessa
 */
public class cabeceraVo implements Serializable {

    private String pzptcabperjact_actividad;
    private String pzptcabperjact_periodo;
    private int pzptcabperjact_pidm;
    private String pzptcabperjact_fecha_inicio;
    private String pzptcabperjact_unidad;
    private String pzptcabperjact_responsable;
    private String pzptcabperjact_horas;

    public cabeceraVo() {
    }

    public cabeceraVo(String pzptcabperjact_actividad, String pzptcabperjact_periodo, int pzptcabperjact_pidm, String pzptcabperjact_fecha_inicio, String pzptcabperjact_unidad, String pzptcabperjact_responsable, String pzptcabperjact_horas) {
        this.pzptcabperjact_actividad = pzptcabperjact_actividad;
        this.pzptcabperjact_periodo = pzptcabperjact_periodo;
        this.pzptcabperjact_pidm = pzptcabperjact_pidm;
        this.pzptcabperjact_fecha_inicio = pzptcabperjact_fecha_inicio;
        this.pzptcabperjact_unidad = pzptcabperjact_unidad;
        this.pzptcabperjact_responsable = pzptcabperjact_responsable;
        this.pzptcabperjact_horas = pzptcabperjact_horas;
    }

    public String getPzptcabperjact_actividad() {
        return pzptcabperjact_actividad;
    }

    public void setPzptcabperjact_actividad(String pzptcabperjact_actividad) {
        this.pzptcabperjact_actividad = pzptcabperjact_actividad;
    }

    public String getPzptcabperjact_periodo() {
        return pzptcabperjact_periodo;
    }

    public void setPzptcabperjact_periodo(String pzptcabperjact_periodo) {
        this.pzptcabperjact_periodo = pzptcabperjact_periodo;
    }

    public int getPzptcabperjact_pidm() {
        return pzptcabperjact_pidm;
    }

    public void setPzptcabperjact_pidm(int pzptcabperjact_pidm) {
        this.pzptcabperjact_pidm = pzptcabperjact_pidm;
    }

    public String getPzptcabperjact_fecha_inicio() {
        return pzptcabperjact_fecha_inicio;
    }

    public void setPzptcabperjact_fecha_inicio(String pzptcabperjact_fecha_inicio) {
        this.pzptcabperjact_fecha_inicio = pzptcabperjact_fecha_inicio;
    }

    public String getPzptcabperjact_unidad() {
        return pzptcabperjact_unidad;
    }

    public void setPzptcabperjact_unidad(String pzptcabperjact_unidad) {
        this.pzptcabperjact_unidad = pzptcabperjact_unidad;
    }

    public String getPzptcabperjact_responsable() {
        return pzptcabperjact_responsable;
    }

    public void setPzptcabperjact_responsable(String pzptcabperjact_responsable) {
        this.pzptcabperjact_responsable = pzptcabperjact_responsable;
    }

    public String getPzptcabperjact_horas() {
        return pzptcabperjact_horas;
    }

    public void setPzptcabperjact_horas(String pzptcabperjact_horas) {
        this.pzptcabperjact_horas = pzptcabperjact_horas;
    }



}
