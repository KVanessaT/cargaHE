/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "PERJACT", schema = "PAYROLL")
public class Perjact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_PIDM")
    private int perjactPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PERJACT_POSN")
    private String perjactPosn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PERJACT_SUFF")
    private String perjactSuff;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_EFFECTIVE_DATE")
    //@Temporal(TemporalType.TIMESTAMP)
    private String perjactEffectiveDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PERJACT_DICD_CODE")
    private String perjactDicdCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PERJACT_JACT_CODE")
    private String perjactJactCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PERJACT_ASTY_CODE")
    private String perjactAstyCode;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_STD_HRS_PER_PAY")
    private int perjactStdHrsPerPay;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_PERCENT")
    private BigDecimal perjactPercent;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_FTE")
    private BigDecimal perjactFte;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERJACT_ACTIVITY_DATE")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date perjactActivityDate;

    public Perjact() {
    }

    public Perjact(int perjactPidm, String perjactPosn, String perjactSuff, String perjactEffectiveDate, String perjactDicdCode, String perjactJactCode, String perjactAstyCode, int perjactStdHrsPerPay, BigDecimal perjactPercent, BigDecimal perjactFte, Date perjactActivityDate) {
        this.perjactPidm = perjactPidm;
        this.perjactPosn = perjactPosn;
        this.perjactSuff = perjactSuff;
        this.perjactEffectiveDate = perjactEffectiveDate;
        this.perjactDicdCode = perjactDicdCode;
        this.perjactJactCode = perjactJactCode;
        this.perjactAstyCode = perjactAstyCode;
        this.perjactStdHrsPerPay = perjactStdHrsPerPay;
        this.perjactPercent = perjactPercent;
        this.perjactFte = perjactFte;
        this.perjactActivityDate = perjactActivityDate;
    }

    public int getPerjactPidm() {
        return perjactPidm;
    }

    public void setPerjactPidm(int perjactPidm) {
        this.perjactPidm = perjactPidm;
    }

    public String getPerjactPosn() {
        return perjactPosn;
    }

    public void setPerjactPosn(String perjactPosn) {
        this.perjactPosn = perjactPosn;
    }

    public String getPerjactSuff() {
        return perjactSuff;
    }

    public void setPerjactSuff(String perjactSuff) {
        this.perjactSuff = perjactSuff;
    }

    public String getPerjactEffectiveDate() {
        return perjactEffectiveDate;
    }

    public void setPerjactEffectiveDate(String perjactEffectiveDate) {
        this.perjactEffectiveDate = perjactEffectiveDate;
    }

    public String getPerjactDicdCode() {
        return perjactDicdCode;
    }

    public void setPerjactDicdCode(String perjactDicdCode) {
        this.perjactDicdCode = perjactDicdCode;
    }

    public String getPerjactJactCode() {
        return perjactJactCode;
    }

    public void setPerjactJactCode(String perjactJactCode) {
        this.perjactJactCode = perjactJactCode;
    }

    public String getPerjactAstyCode() {
        return perjactAstyCode;
    }

    public void setPerjactAstyCode(String perjactAstyCode) {
        this.perjactAstyCode = perjactAstyCode;
    }

    public int getPerjactStdHrsPerPay() {
        return perjactStdHrsPerPay;
    }

    public void setPerjactStdHrsPerPay(int perjactStdHrsPerPay) {
        this.perjactStdHrsPerPay = perjactStdHrsPerPay;
    }

    public BigDecimal getPerjactPercent() {
        return perjactPercent;
    }

    public void setPerjactPercent(BigDecimal perjactPercent) {
        this.perjactPercent = perjactPercent;
    }

    public BigDecimal getPerjactFte() {
        return perjactFte;
    }

    public void setPerjactFte(BigDecimal perjactFte) {
        this.perjactFte = perjactFte;
    }

    public Date getPerjactActivityDate() {
        return perjactActivityDate;
    }

    public void setPerjactActivityDate(Date perjactActivityDate) {
        this.perjactActivityDate = perjactActivityDate;
    }

}
