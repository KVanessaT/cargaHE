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
public class subactividadesVo implements Serializable{
    
    private String stvasty_code;
    private String stvasty_desc;

    public subactividadesVo() {
    }

    public subactividadesVo(String stvasty_code, String stvasty_desc) {
        this.stvasty_code = stvasty_code;
        this.stvasty_desc = stvasty_desc;
    }

    public String getStvasty_code() {
        return stvasty_code;
    }

    public void setStvasty_code(String stvasty_code) {
        this.stvasty_code = stvasty_code;
    }

    public String getStvasty_desc() {
        return stvasty_desc;
    }

    public void setStvasty_desc(String stvasty_desc) {
        this.stvasty_desc = stvasty_desc;
    }
    
    
}
