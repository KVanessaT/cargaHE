/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.vo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author Vanessa
 */

public class  empleadoVo implements Serializable{
    
    private String id_banner;
    private String nombres;
    private String apellido;
     private String prefijo;
    private String dedicacion;
    private int pebempl_pidm;
    private String code;

 

    public empleadoVo() {
    }

    public empleadoVo(String id_banner, String nombres, String apellido, String prefijo, String dedicacion, int pebempl_pidm, String code) {
        this.id_banner = id_banner;
        this.nombres = nombres;
        this.apellido = apellido;
        this.prefijo = prefijo;
        this.dedicacion = dedicacion;
        this.pebempl_pidm = pebempl_pidm;
        this.code = code;
    }

    public String getId_banner() {
        return id_banner;
    }

    public void setId_banner(String id_banner) {
        this.id_banner = id_banner;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public int getPebempl_pidm() {
        return pebempl_pidm;
    }

    public void setPebempl_pidm(int pebempl_pidm) {
        this.pebempl_pidm = pebempl_pidm;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
