/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "STVTERM", schema ="SATURN")
public class Periodo implements Serializable{
     private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "STVTERM_SURROGATE_ID_SEQUENCE", sequenceName = "STVTERM_SURROGATE_ID_SEQUENCE", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STVTERM_SURROGATE_ID_SEQUENCE")

     @Basic(optional = false)
    @Column(name = "STVTERM_CODE")
    private String stvtermCode;

    @Column(name = "STVTERM_DESC")
    private String stvtermDesc;
    
    @Column(name = "STVTERM_START_DATE")
  @Temporal(TemporalType.TIMESTAMP)
   // @JsonFormat(pattern="dd-MM-yyyy")
    private Date stvtermStartDate;
    
    @Column(name = "STVTERM_END_DATE")
   @Temporal(TemporalType.TIMESTAMP)
      //  @JsonFormat(pattern="dd-MM-yyyy")
    private Date stvtermEndDate;
    
    @Column(name = "STVTERM_FA_PROC_YR")
    private String stvtermFaProcYr;
    
    @Column(name = "STVTERM_ACTIVITY_DATE")
    private String stvtermActivityDate;
    
    @Column(name = "STVTERM_FA_TERM")
    private String stvtermFaTerm;
    
    @Column(name = "STVTERM_FA_PERIOD")
    private String stvtermFaPeriod;
    
    @Column(name = "STVTERM_FA_END_PERIOD")
    private String stvtermFaEndPeriod;
    
    @Column(name = "STVTERM_ACYR_CODE")
    private String stvtermAcyrCode;
    
    @Column(name = "STVTERM_HOUSING_START_DATE")
    private String stvtermHousingStartDate;
    
    @Column(name = "STVTERM_HOUSING_END_DATE")
    private String stvtermHousingEndDate;
    
    @Column(name = "STVTERM_SYSTEM_REQ_IND")
    private String stvtermSystemReqInd;
    
    @Column(name = "STVTERM_TRMT_CODE")
    private String stvtermTrmtCode;
    
    @Column(name = "STVTERM_FA_SUMMER_IND")
    private String stvtermFaSummerInd;
    
    @Column(name = "STVTERM_SURROGATE_ID")
    private String stvtermSurrogateId;
    
    @Column(name = "STVTERM_VERSION")
    private String stvtermVersion;
    
    @Column(name = "STVTERM_USER_ID")
    private String stvtermUserId;
    
    @Column(name = "STVTERM_DATA_ORIGIN")
    private String stvtermDataOrigin;
    
    @Column(name = "STVTERM_VPDI_CODE")
    private String stvtermVpdiCode;

    public Periodo() {
    }

    public String getStvtermCode() {
        return stvtermCode;
    }

    public void setStvtermCode(String stvtermCode) {
        this.stvtermCode = stvtermCode;
    }

    public String getStvtermDesc() {
        return stvtermDesc;
    }

    public void setStvtermDesc(String stvtermDesc) {
        this.stvtermDesc = stvtermDesc;
    }

    public Date getStvtermStartDate() {
        return stvtermStartDate;
    }

    public void setStvtermStartDate(Date stvtermStartDate) {
        this.stvtermStartDate = stvtermStartDate;
    }

    public Date getStvtermEndDate() {
        return stvtermEndDate;
    }

    public void setStvtermEndDate(Date stvtermEndDate) {
        this.stvtermEndDate = stvtermEndDate;
    }

    public String getStvtermFaProcYr() {
        return stvtermFaProcYr;
    }

    public void setStvtermFaProcYr(String stvtermFaProcYr) {
        this.stvtermFaProcYr = stvtermFaProcYr;
    }

    public String getStvtermActivityDate() {
        return stvtermActivityDate;
    }

    public void setStvtermActivityDate(String stvtermActivityDate) {
        this.stvtermActivityDate = stvtermActivityDate;
    }

    public String getStvtermFaTerm() {
        return stvtermFaTerm;
    }

    public void setStvtermFaTerm(String stvtermFaTerm) {
        this.stvtermFaTerm = stvtermFaTerm;
    }

    public String getStvtermFaPeriod() {
        return stvtermFaPeriod;
    }

    public void setStvtermFaPeriod(String stvtermFaPeriod) {
        this.stvtermFaPeriod = stvtermFaPeriod;
    }

    public String getStvtermFaEndPeriod() {
        return stvtermFaEndPeriod;
    }

    public void setStvtermFaEndPeriod(String stvtermFaEndPeriod) {
        this.stvtermFaEndPeriod = stvtermFaEndPeriod;
    }

    public String getStvtermAcyrCode() {
        return stvtermAcyrCode;
    }

    public void setStvtermAcyrCode(String stvtermAcyrCode) {
        this.stvtermAcyrCode = stvtermAcyrCode;
    }

    public String getStvtermHousingStartDate() {
        return stvtermHousingStartDate;
    }

    public void setStvtermHousingStartDate(String stvtermHousingStartDate) {
        this.stvtermHousingStartDate = stvtermHousingStartDate;
    }

    public String getStvtermHousingEndDate() {
        return stvtermHousingEndDate;
    }

    public void setStvtermHousingEndDate(String stvtermHousingEndDate) {
        this.stvtermHousingEndDate = stvtermHousingEndDate;
    }

    public String getStvtermSystemReqInd() {
        return stvtermSystemReqInd;
    }

    public void setStvtermSystemReqInd(String stvtermSystemReqInd) {
        this.stvtermSystemReqInd = stvtermSystemReqInd;
    }

    public String getStvtermTrmtCode() {
        return stvtermTrmtCode;
    }

    public void setStvtermTrmtCode(String stvtermTrmtCode) {
        this.stvtermTrmtCode = stvtermTrmtCode;
    }

    public String getStvtermFaSummerInd() {
        return stvtermFaSummerInd;
    }

    public void setStvtermFaSummerInd(String stvtermFaSummerInd) {
        this.stvtermFaSummerInd = stvtermFaSummerInd;
    }

    public String getStvtermSurrogateId() {
        return stvtermSurrogateId;
    }

    public void setStvtermSurrogateId(String stvtermSurrogateId) {
        this.stvtermSurrogateId = stvtermSurrogateId;
    }

    public String getStvtermVersion() {
        return stvtermVersion;
    }

    public void setStvtermVersion(String stvtermVersion) {
        this.stvtermVersion = stvtermVersion;
    }

    public String getStvtermUserId() {
        return stvtermUserId;
    }

    public void setStvtermUserId(String stvtermUserId) {
        this.stvtermUserId = stvtermUserId;
    }

    public String getStvtermDataOrigin() {
        return stvtermDataOrigin;
    }

    public void setStvtermDataOrigin(String stvtermDataOrigin) {
        this.stvtermDataOrigin = stvtermDataOrigin;
    }

    public String getStvtermVpdiCode() {
        return stvtermVpdiCode;
    }

    public void setStvtermVpdiCode(String stvtermVpdiCode) {
        this.stvtermVpdiCode = stvtermVpdiCode;
    }
    
    
}
