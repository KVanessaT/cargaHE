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
public class periodoVo implements Serializable {

    private String stvterm_code;
    private String stvterm_desc;

    private Date stvterm_start_date;
         

    private Date stvterm_end_date;

    public periodoVo() {
    }

    public periodoVo(String stvterm_code, String stvterm_desc, Date stvterm_start_date, Date stvterm_end_date) {
        this.stvterm_code = stvterm_code;
        this.stvterm_desc = stvterm_desc;
        this.stvterm_start_date = stvterm_start_date;
        this.stvterm_end_date = stvterm_end_date;
    }

    public String getStvtermCode() {
        return stvterm_code;
    }

    public void setStvtermCode(String stvterm_code) {
        this.stvterm_code = stvterm_code;
    }

    public String getStvtermDesc() {
        return stvterm_desc;
    }

    public void setStvtermDesc(String stvterm_desc) {
        this.stvterm_desc = stvterm_desc;
    }

    public Date getStvtermStartDate() {
        return stvterm_start_date;
    }

    public void setStvtermStartDate(Date stvterm_start_date) {
        this.stvterm_start_date = stvterm_start_date;
    }

    public Date getStvtermEndDate() {
        return stvterm_end_date;
    }

    public void setStvtermEndDate(Date stvterm_end_date) {
        this.stvterm_end_date = stvterm_end_date;
    }
    
    
    

}
