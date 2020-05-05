/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Vanessa
 */
public class SubActividadesDocenteVo implements Serializable{
    private String perjact_asty_code;
    private String stvasty_desc;
    private int perjact_std_hrs_per_pay;
    private BigDecimal perjact_percent;
    private String stvasty_activity_date;
    private String suff;
    private String posn;
    private String pidm;
    private String fechae;
    private String actividad;
    private String codprovincia;




    public SubActividadesDocenteVo() {
    }

    public SubActividadesDocenteVo(String perjact_asty_code, String stvasty_desc, int perjact_std_hrs_per_pay, BigDecimal perjact_percent, String stvasty_activity_date, String suff, String posn, String pidm, String fechae, String actividad, String codprovincia) {
        this.perjact_asty_code = perjact_asty_code;
        this.stvasty_desc = stvasty_desc;
        this.perjact_std_hrs_per_pay = perjact_std_hrs_per_pay;
        this.perjact_percent = perjact_percent;
        this.stvasty_activity_date = stvasty_activity_date;
        this.suff = suff;
        this.posn = posn;
        this.pidm = pidm;
        this.fechae = fechae;
        this.actividad = actividad;
        this.codprovincia = codprovincia;
    }

    public String getPerjact_asty_code() {
        return perjact_asty_code;
    }

    public void setPerjact_asty_code(String perjact_asty_code) {
        this.perjact_asty_code = perjact_asty_code;
    }

    public String getStvasty_desc() {
        return stvasty_desc;
    }

    public void setStvasty_desc(String stvasty_desc) {
        this.stvasty_desc = stvasty_desc;
    }

    public int getPerjact_std_hrs_per_pay() {
        return perjact_std_hrs_per_pay;
    }

    public void setPerjact_std_hrs_per_pay(int perjact_std_hrs_per_pay) {
        this.perjact_std_hrs_per_pay = perjact_std_hrs_per_pay;
    }

    public BigDecimal getPerjact_percent() {
        return perjact_percent;
    }

    public void setPerjact_percent(BigDecimal perjact_percent) {
        this.perjact_percent = perjact_percent;
    }

    public String getStvasty_activity_date() {
        return stvasty_activity_date;
    }

    public void setStvasty_activity_date(String stvasty_activity_date) {
        this.stvasty_activity_date = stvasty_activity_date;
    }

    

    public String getSuff() {
        return suff;
    }

    public void setSuff(String suff) {
        this.suff = suff;
    }

    public String getPosn() {
        return posn;
    }

    public void setPosn(String posn) {
        this.posn = posn;
    }

    public String getPidm() {
        return pidm;
    }

    public void setPidm(String pidm) {
        this.pidm = pidm;
    }

    public String getFechae() {
        return fechae;
    }

    public void setFechae(String fechae) {
        this.fechae = fechae;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCodprovincia() {
        return codprovincia;
    }

    public void setCodprovincia(String codprovincia) {
        this.codprovincia = codprovincia;
    }

   
    
    
}