/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "STVCAMP")
public class Campus implements Serializable{
     @SequenceGenerator(name = "ST_STVCAMP_SURROGATE_ID", sequenceName = "ST_STVCAMP_SURROGATE_ID", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ST_STVCAMP_SURROGATE_ID")

    @Basic(optional = false)
    @Column(name = "STVCAMP_CODE")
    private String stvcampCode;
    @Column(name = "STVCAMP_DESC")
    private String stvcampDesc;
    @Column(name = "STVCAMP_ACTIVITY_DATE")
    private String stvcampActivityDate;
    @Column(name = "STVCAMP_DICD_CODE")
    private String stvcampDicdCode;
    @Column(name = "STVCAMP_SURROGATE_ID")
    private String stvcampSurrogateId;
    @Column(name = "STVCAMP_VERSION")
    private String stvcampVersion;
    @Column(name = "STVCAMP_USER_ID")
    private String stvcampUserId;
    @Column(name = "STVCAMP_DATA_ORIGIN")
    private String stvcampDataOrigin;
    @Column(name = "STVCAMP_VPDI_CODE")
    private String stvcampVpdiCode;
    @Column(name = "STVCAMP_UTC_OFFSET")
    private String stvcampUtcOffset;

    public String getStvcampCode() {
        return stvcampCode;
    }

    public void setStvcampCode(String stvcampCode) {
        this.stvcampCode = stvcampCode;
    }

    public String getStvcampDesc() {
        return stvcampDesc;
    }

    public void setStvcampDesc(String stvcampDesc) {
        this.stvcampDesc = stvcampDesc;
    }

    public String getStvcampActivityDate() {
        return stvcampActivityDate;
    }

    public void setStvcampActivityDate(String stvcampActivityDate) {
        this.stvcampActivityDate = stvcampActivityDate;
    }

    public String getStvcampDicdCode() {
        return stvcampDicdCode;
    }

    public void setStvcampDicdCode(String stvcampDicdCode) {
        this.stvcampDicdCode = stvcampDicdCode;
    }

    public String getStvcampSurrogateId() {
        return stvcampSurrogateId;
    }

    public void setStvcampSurrogateId(String stvcampSurrogateId) {
        this.stvcampSurrogateId = stvcampSurrogateId;
    }

    public String getStvcampVersion() {
        return stvcampVersion;
    }

    public void setStvcampVersion(String stvcampVersion) {
        this.stvcampVersion = stvcampVersion;
    }

    public String getStvcampUserId() {
        return stvcampUserId;
    }

    public void setStvcampUserId(String stvcampUserId) {
        this.stvcampUserId = stvcampUserId;
    }

    public String getStvcampDataOrigin() {
        return stvcampDataOrigin;
    }

    public void setStvcampDataOrigin(String stvcampDataOrigin) {
        this.stvcampDataOrigin = stvcampDataOrigin;
    }

    public String getStvcampVpdiCode() {
        return stvcampVpdiCode;
    }

    public void setStvcampVpdiCode(String stvcampVpdiCode) {
        this.stvcampVpdiCode = stvcampVpdiCode;
    }

    public String getStvcampUtcOffset() {
        return stvcampUtcOffset;
    }

    public void setStvcampUtcOffset(String stvcampUtcOffset) {
        this.stvcampUtcOffset = stvcampUtcOffset;
    }
    
    
    
}
