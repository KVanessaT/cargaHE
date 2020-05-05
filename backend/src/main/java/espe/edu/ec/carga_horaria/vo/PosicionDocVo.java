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
public class PosicionDocVo implements Serializable {

    private int NBRJOBS_PIDM;
    private String nbrjobsPosn;
    private Date NBRJOBS_EFFECTIVE_DATE;
    private String NBRJOBS_ECLS_CODE;
    private String NBRJOBS_PICT_CODE;

    public PosicionDocVo() {
    }

    public PosicionDocVo(int NBRJOBS_PIDM, String nbrjobsPosn, Date NBRJOBS_EFFECTIVE_DATE, String NBRJOBS_ECLS_CODE, String NBRJOBS_PICT_CODE) {
        this.NBRJOBS_PIDM = NBRJOBS_PIDM;
        this.nbrjobsPosn = nbrjobsPosn;
        this.NBRJOBS_EFFECTIVE_DATE = NBRJOBS_EFFECTIVE_DATE;
        this.NBRJOBS_ECLS_CODE = NBRJOBS_ECLS_CODE;
        this.NBRJOBS_PICT_CODE = NBRJOBS_PICT_CODE;
    }

    public int getNBRJOBS_PIDM() {
        return NBRJOBS_PIDM;
    }

    public void setNBRJOBS_PIDM(int NBRJOBS_PIDM) {
        this.NBRJOBS_PIDM = NBRJOBS_PIDM;
    }

    public String getNbrjobsPosn() {
        return nbrjobsPosn;
    }

    public void setNbrjobsPosn(String nbrjobsPosn) {
        this.nbrjobsPosn = nbrjobsPosn;
    }

    public Date getNBRJOBS_EFFECTIVE_DATE() {
        return NBRJOBS_EFFECTIVE_DATE;
    }

    public void setNBRJOBS_EFFECTIVE_DATE(Date NBRJOBS_EFFECTIVE_DATE) {
        this.NBRJOBS_EFFECTIVE_DATE = NBRJOBS_EFFECTIVE_DATE;
    }

    public String getNBRJOBS_ECLS_CODE() {
        return NBRJOBS_ECLS_CODE;
    }

    public void setNBRJOBS_ECLS_CODE(String NBRJOBS_ECLS_CODE) {
        this.NBRJOBS_ECLS_CODE = NBRJOBS_ECLS_CODE;
    }

    public String getNBRJOBS_PICT_CODE() {
        return NBRJOBS_PICT_CODE;
    }

    public void setNBRJOBS_PICT_CODE(String NBRJOBS_PICT_CODE) {
        this.NBRJOBS_PICT_CODE = NBRJOBS_PICT_CODE;
    }

    
}
