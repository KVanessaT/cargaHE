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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vanessa
 */
@Entity
@Table(name = "STVASTY")
public class subActividades implements Serializable{
    @Id

    @Basic(optional = false)
    @Column(name = "STVASTY_CODE")
    private String stvastyCode;
    @Column(name = "STVASTY_DESC")
    private String stvastyDesc;
    @Column(name = "STVASTY_ACTIVITY_DATE")
    private String stvastyActivityDate;
    @Column(name = "STVASTY_SURROGATE_ID")
    private String stvastySurrogateId;
    @Column(name = "STVASTY_VERSION")
    private String stvastyVersion;
    @Column(name = "STVASTY_USER_ID")
    private String stvastyUserId;
    @Column(name = "STVASTY_DATA_ORIGIN")
    private String stvastyDataOrigin;
    @Column(name = "STVASTY_VPDI_CODE")
    private String stvastyVpdiCode;

    public String getStvastyCode() {
        return stvastyCode;
    }

    public void setStvastyCode(String stvastyCode) {
        this.stvastyCode = stvastyCode;
    }

    public String getStvastyDesc() {
        return stvastyDesc;
    }

    public void setStvastyDesc(String stvastyDesc) {
        this.stvastyDesc = stvastyDesc;
    }

    public String getStvastyActivityDate() {
        return stvastyActivityDate;
    }

    public void setStvastyActivityDate(String stvastyActivityDate) {
        this.stvastyActivityDate = stvastyActivityDate;
    }

    public String getStvastySurrogateId() {
        return stvastySurrogateId;
    }

    public void setStvastySurrogateId(String stvastySurrogateId) {
        this.stvastySurrogateId = stvastySurrogateId;
    }

    public String getStvastyVersion() {
        return stvastyVersion;
    }

    public void setStvastyVersion(String stvastyVersion) {
        this.stvastyVersion = stvastyVersion;
    }

    public String getStvastyUserId() {
        return stvastyUserId;
    }

    public void setStvastyUserId(String stvastyUserId) {
        this.stvastyUserId = stvastyUserId;
    }

    public String getStvastyDataOrigin() {
        return stvastyDataOrigin;
    }

    public void setStvastyDataOrigin(String stvastyDataOrigin) {
        this.stvastyDataOrigin = stvastyDataOrigin;
    }

    public String getStvastyVpdiCode() {
        return stvastyVpdiCode;
    }

    public void setStvastyVpdiCode(String stvastyVpdiCode) {
        this.stvastyVpdiCode = stvastyVpdiCode;
    }


}
