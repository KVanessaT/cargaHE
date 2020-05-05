/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.vo;

import java.io.Serializable;

/**
 *
 * @author Vanessa
 */
public class actividadesVo implements Serializable {

    private String pzptcabperjact_actividad;
    private String ptvjact_desc;
    private String pzptcabperjact_periodo;
    private String pzptcabperjact_horas;
    private String pzptcabperjact_unidad_gestion;
    private String pzptcabperjact_responsable;
    private int pzptcabperjact_pidm;

    public actividadesVo() {
    }

    public actividadesVo(String pzptcabperjact_actividad, String pzptcabperjact_periodo, String pzptcabperjact_horas, String pzptcabperjact_unidad_gestion, String pzptcabperjact_responsable, int pzptcabperjact_pidm, String ptvjact_desc) {
        this.pzptcabperjact_actividad = pzptcabperjact_actividad;
        this.pzptcabperjact_periodo = pzptcabperjact_periodo;
        this.pzptcabperjact_horas = pzptcabperjact_horas;
        this.pzptcabperjact_unidad_gestion = pzptcabperjact_unidad_gestion;
        this.pzptcabperjact_responsable = pzptcabperjact_responsable;
        this.pzptcabperjact_pidm = pzptcabperjact_pidm;
        this.ptvjact_desc = ptvjact_desc;
    }
//Ya le veo dame un momento
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

    public String getPzptcabperjact_horas() {
        return pzptcabperjact_horas;
    }

    public void setPzptcabperjact_horas(String pzptcabperjact_horas) {
        this.pzptcabperjact_horas = pzptcabperjact_horas;
    }

    public String getPzptcabperjact_unidad_gestion() {
        return pzptcabperjact_unidad_gestion;
    }

    public void setPzptcabperjact_unidad_gestion(String pzptcabperjact_unidad_gestion) {
        this.pzptcabperjact_unidad_gestion = pzptcabperjact_unidad_gestion;
    }

    public String getPzptcabperjact_responsable() {
        return pzptcabperjact_responsable;
    }

    public void setPzptcabperjact_responsable(String pzptcabperjact_responsable) {
        this.pzptcabperjact_responsable = pzptcabperjact_responsable;
    }

    public int getPzptcabperjact_pidm() {
        return pzptcabperjact_pidm;
    }

    public void setPzptcabperjact_pidm(int pzptcabperjact_pidm) {
        this.pzptcabperjact_pidm = pzptcabperjact_pidm;
    }
    
       public String getPtvjact_desc() {
        return ptvjact_desc;
    }

    public void setPtvjact_desc(String ptvjact_desc) {
        this.ptvjact_desc = ptvjact_desc;
    }
}
