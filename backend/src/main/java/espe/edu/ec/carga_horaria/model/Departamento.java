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
@Table(name = "STVCOLL")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "STVCOLL_SURROGATE_ID_SEQUENCE", sequenceName = "STVCOLL_SURROGATE_ID_SEQUENCE", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STVCOLL_SURROGATE_ID_SEQUENCE")

    @Basic(optional = false)
    @Column(name = "STVCOLL_CODE")
    private String stvcollCode;
    @Column(name = "STVCOLL_DESC")
    private String stvcollDesc;
    @Column(name = "STVCOLL_ADDR_STREET_LINE1")
    private String stvcollAddrStreetLine1;
    @Column(name = "STVCOLL_ADDR_STREET_LINE2")
    private String stvcollAddrStreetLine2;
    @Column(name = "STVCOLL_ADDR_STREET_LINE3")
    private String stvcollAddrStreetLine3;
    @Column(name = "STVCOLL_ADDR_STREET_LINE4")
    private String stvcollAddrStreetLine4;
    @Column(name = "STVCOLL_ADDR_CITY")
    private String stvcollAddrCity;
    @Column(name = "STVCOLL_ADDR_STATE")
    private String stvcollAddrState;
    @Column(name = "STVCOLL_ADDR_COUNTRY")
    private String stvcollAddrCountry;
    @Column(name = "STVCOLL_ADDR_ZIP_CODE")
    private String stvcollAddrZipCode;
    @Column(name = "STVCOLL_ACTIVITY_DATE")
    private String stvcollActivityDate;
    @Column(name = "STVCOLL_SYSTEM_REQ_IND")
    private String stvcollSystemReqInd;
    @Column(name = "STVCOLL_VR_MSG_NO")
    private String stvcollVrMsgNo;
    @Column(name = "STVCOLL_STATSCAN_CDE3")
    private String stvcollStatscanCde3;
    @Column(name = "STVCOLL_DICD_CODE")
    private String stvcollDicdCode;
    @Column(name = "STVCOLL_HOUSE_NUMBER")
    private String stvcollHouseNumber;
    @Column(name = "STVCOLL_SURROGATE_ID")
    private String stvcollSurrogateId;
    @Column(name = "STVCOLL_VERSION")
    private String stvcollVersion;
    @Column(name = "STVCOLL_USER_ID")
    private String stvcollUserId;
    @Column(name = "STVCOLL_DATA_ORIGIN")
    private String stvcollDataOrigin;
    @Column(name = "STVCOLL_VPDI_CODE")
    private String stvcollVpdiCode;

    public String getStvcollCode() {
        return stvcollCode;
    }

    public void setStvcollCode(String stvcollCode) {
        this.stvcollCode = stvcollCode;
    }

    public String getStvcollDesc() {
        return stvcollDesc;
    }

    public void setStvcollDesc(String stvcollDesc) {
        this.stvcollDesc = stvcollDesc;
    }

    public String getStvcollAddrStreetLine1() {
        return stvcollAddrStreetLine1;
    }

    public void setStvcollAddrStreetLine1(String stvcollAddrStreetLine1) {
        this.stvcollAddrStreetLine1 = stvcollAddrStreetLine1;
    }

    public String getStvcollAddrStreetLine2() {
        return stvcollAddrStreetLine2;
    }

    public void setStvcollAddrStreetLine2(String stvcollAddrStreetLine2) {
        this.stvcollAddrStreetLine2 = stvcollAddrStreetLine2;
    }

    public String getStvcollAddrStreetLine3() {
        return stvcollAddrStreetLine3;
    }

    public void setStvcollAddrStreetLine3(String stvcollAddrStreetLine3) {
        this.stvcollAddrStreetLine3 = stvcollAddrStreetLine3;
    }

    public String getStvcollAddrStreetLine4() {
        return stvcollAddrStreetLine4;
    }

    public void setStvcollAddrStreetLine4(String stvcollAddrStreetLine4) {
        this.stvcollAddrStreetLine4 = stvcollAddrStreetLine4;
    }

    public String getStvcollAddrCity() {
        return stvcollAddrCity;
    }

    public void setStvcollAddrCity(String stvcollAddrCity) {
        this.stvcollAddrCity = stvcollAddrCity;
    }

    public String getStvcollAddrState() {
        return stvcollAddrState;
    }

    public void setStvcollAddrState(String stvcollAddrState) {
        this.stvcollAddrState = stvcollAddrState;
    }

    public String getStvcollAddrCountry() {
        return stvcollAddrCountry;
    }

    public void setStvcollAddrCountry(String stvcollAddrCountry) {
        this.stvcollAddrCountry = stvcollAddrCountry;
    }

    public String getStvcollAddrZipCode() {
        return stvcollAddrZipCode;
    }

    public void setStvcollAddrZipCode(String stvcollAddrZipCode) {
        this.stvcollAddrZipCode = stvcollAddrZipCode;
    }

    public String getStvcollActivityDate() {
        return stvcollActivityDate;
    }

    public void setStvcollActivityDate(String stvcollActivityDate) {
        this.stvcollActivityDate = stvcollActivityDate;
    }

    public String getStvcollSystemReqInd() {
        return stvcollSystemReqInd;
    }

    public void setStvcollSystemReqInd(String stvcollSystemReqInd) {
        this.stvcollSystemReqInd = stvcollSystemReqInd;
    }

    public String getStvcollVrMsgNo() {
        return stvcollVrMsgNo;
    }

    public void setStvcollVrMsgNo(String stvcollVrMsgNo) {
        this.stvcollVrMsgNo = stvcollVrMsgNo;
    }

    public String getStvcollStatscanCde3() {
        return stvcollStatscanCde3;
    }

    public void setStvcollStatscanCde3(String stvcollStatscanCde3) {
        this.stvcollStatscanCde3 = stvcollStatscanCde3;
    }

    public String getStvcollDicdCode() {
        return stvcollDicdCode;
    }

    public void setStvcollDicdCode(String stvcollDicdCode) {
        this.stvcollDicdCode = stvcollDicdCode;
    }

    public String getStvcollHouseNumber() {
        return stvcollHouseNumber;
    }

    public void setStvcollHouseNumber(String stvcollHouseNumber) {
        this.stvcollHouseNumber = stvcollHouseNumber;
    }

    public String getStvcollSurrogateId() {
        return stvcollSurrogateId;
    }

    public void setStvcollSurrogateId(String stvcollSurrogateId) {
        this.stvcollSurrogateId = stvcollSurrogateId;
    }

    public String getStvcollVersion() {
        return stvcollVersion;
    }

    public void setStvcollVersion(String stvcollVersion) {
        this.stvcollVersion = stvcollVersion;
    }

    public String getStvcollUserId() {
        return stvcollUserId;
    }

    public void setStvcollUserId(String stvcollUserId) {
        this.stvcollUserId = stvcollUserId;
    }

    public String getStvcollDataOrigin() {
        return stvcollDataOrigin;
    }

    public void setStvcollDataOrigin(String stvcollDataOrigin) {
        this.stvcollDataOrigin = stvcollDataOrigin;
    }

    public String getStvcollVpdiCode() {
        return stvcollVpdiCode;
    }

    public void setStvcollVpdiCode(String stvcollVpdiCode) {
        this.stvcollVpdiCode = stvcollVpdiCode;
    }

}
