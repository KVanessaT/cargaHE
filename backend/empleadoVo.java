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
public class empleadoVo implements Serializable{
     private String id_banner;
    private String apellido;
    private String nombres;

    public empleadoVo() {
    }

    public empleadoVo(String id_banner, String apellido, String nombres) {
        this.id_banner = id_banner;
        this.apellido = apellido;
        this.nombres = nombres;
    }

    public String getId_banner() {
        return id_banner;
    }

    public void setId_banner(String id_banner) {
        this.id_banner = id_banner;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    
}
