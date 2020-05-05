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
@Table(name = "BZSVEMPLEADO", schema ="BANINST1")

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
   //@SequenceGenerator(name = "UZFTPERSONP_SEQ", sequenceName = "UZFTPERSONP_SEQ", allocationSize = 1)
   @Id
   //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UZFTPERSONP_SEQ")

    @Basic(optional = false)
    @Column(name = "PEBEMPL_PIDM")
    private int pebemplPidm;
    @Column(name = "ID_BANNER")
    private String idBanner;
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "PREFIJO")
    private String prefijo;

    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Column(name = "ESTADO_CIVIL_SITH")
    private String estadoCivilSith;
    @Column(name = "NUM_CARNET")
    private String numCarnet;
    @Column(name = "IDENTIFICACION_ETNIA")
    private String identificacionEtnia;
    @Column(name = "CORREO_INSTITUCIONAL")
    private String correoInstitucional;
    @Column(name = "CORREO_PERSONAL")
    private String correoPersonal;
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "CANTON")
    private String canton;
    @Column(name = "PARROQUIA")
    private String parroquia;
    @Column(name = "DESC_TIT")
    private String descTit;
    @Column(name = "FECHA_TRABAJO")
    private String fechaTrabajo;
    @Column(name = "TIPO_CONTRATO")
    private String tipoContrato;
    @Column(name = "DEDICACION")
    private String dedicacion;
    @Column(name = "TIPO_EMPLEADO")
    private String tipoEmpleado;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SECCION")
    private String seccion;
    @Column(name = "UBICACION")
    private String ubicacion;
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "CAMPUS")
    private String campus;
    @Column(name = "DESC_PUESTO")
    private String descPuesto;
    @Column(name = "SW_DOCENTE")
    private String swDocente;
    @Column(name = "CODE_DEDICACION")
    private String codeDedicacion;
    @Column(name = "CODE_PUESTO")
    private String codePuesto;

    public int getPebemplPidm() {
        return pebemplPidm;
    }

    public void setPebemplPidm(int pebemplPidm) {
        this.pebemplPidm = pebemplPidm;
    }

    public String getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(String idBanner) {
        this.idBanner = idBanner;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }



    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

   
   
    public String getEstadoCivilSith() {
        return estadoCivilSith;
    }

    public void setEstadoCivilSith(String estadoCivilSith) {
        this.estadoCivilSith = estadoCivilSith;
    }

   
    public String getNumCarnet() {
        return numCarnet;
    }

    public void setNumCarnet(String numCarnet) {
        this.numCarnet = numCarnet;
    }

   
    public String getIdentificacionEtnia() {
        return identificacionEtnia;
    }

    public void setIdentificacionEtnia(String identificacionEtnia) {
        this.identificacionEtnia = identificacionEtnia;
    }

   
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

   
    public String getDescTit() {
        return descTit;
    }

    public void setDescTit(String descTit) {
        this.descTit = descTit;
    }

    public String getFechaTrabajo() {
        return fechaTrabajo;
    }

    public void setFechaTrabajo(String fechaTrabajo) {
        this.fechaTrabajo = fechaTrabajo;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getDescPuesto() {
        return descPuesto;
    }

    public void setDescPuesto(String descPuesto) {
        this.descPuesto = descPuesto;
    }

    public String getSwDocente() {
        return swDocente;
    }

    public void setSwDocente(String swDocente) {
        this.swDocente = swDocente;
    }

    public String getCodeDedicacion() {
        return codeDedicacion;
    }

    public void setCodeDedicacion(String codeDedicacion) {
        this.codeDedicacion = codeDedicacion;
    }

    public String getCodePuesto() {
        return codePuesto;
    }

    public void setCodePuesto(String codePuesto) {
        this.codePuesto = codePuesto;
    }

  

   

    
}
