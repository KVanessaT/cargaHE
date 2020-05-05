/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "PTVJACT")
public class Actividades implements Serializable {

    @Id

    @Basic(optional = false)
    @Column(name = "PTVJACT_CODE")
    private String ptvjactCode;
    @Column(name = "PTVJACT_DESC")
    private String ptvjactDesc;
    @Column(name = "PTVJACT_ACTIVITY_DATE")
    private Date ptvjactActivityDate;
    @Column(name = "PTVJACT_SURROGATE_ID")
    private Long pvtjactSurrogateId;
    @Column(name = "PTVJACT_VERSION")
    private Long ptvjactVersion;
    @Column(name = "PTVJACT_USER_ID")
    private String ptvjactUserId;
    @Column(name = "PTVJACT_DATA_ORIGIN")
    private String ptvjactDataOrigin;
    @Column(name = "PTVJACT_VPDI_CODE")
    private String ptvjactVpdiCode;

    public String getPtvjactCode() {
        return ptvjactCode;
    }

    public void setPtvjactCode(String ptvjactCode) {
        this.ptvjactCode = ptvjactCode;
    }

    public String getPtvjactDesc() {
        return ptvjactDesc;
    }

    public void setPtvjactDesc(String ptvjactDesc) {
        this.ptvjactDesc = ptvjactDesc;
    }

    public Date getPtvjactActivityDate() {
        return ptvjactActivityDate;
    }

    public void setPtvjactActivityDate(Date ptvjactActivityDate) {
        this.ptvjactActivityDate = ptvjactActivityDate;
    }

    public Long getPvtjactSurrogateId() {
        return pvtjactSurrogateId;
    }

    public void setPvtjactSurrogateId(Long pvtjactSurrogateId) {
        this.pvtjactSurrogateId = pvtjactSurrogateId;
    }

    public Long getPtvjactVersion() {
        return ptvjactVersion;
    }

    public void setPtvjactVersion(Long ptvjactVersion) {
        this.ptvjactVersion = ptvjactVersion;
    }

    public String getPtvjactUserId() {
        return ptvjactUserId;
    }

    public void setPtvjactUserId(String ptvjactUserId) {
        this.ptvjactUserId = ptvjactUserId;
    }

    public String getPtvjactDataOrigin() {
        return ptvjactDataOrigin;
    }

    public void setPtvjactDataOrigin(String ptvjactDataOrigin) {
        this.ptvjactDataOrigin = ptvjactDataOrigin;
    }

    public String getPtvjactVpdiCode() {
        return ptvjactVpdiCode;
    }

    public void setPtvjactVpdiCode(String ptvjactVpdiCode) {
        this.ptvjactVpdiCode = ptvjactVpdiCode;
    }
}
