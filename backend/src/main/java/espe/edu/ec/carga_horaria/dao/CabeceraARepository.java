/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.Cabecera;
import espe.edu.ec.carga_horaria.model.CabeceraA;
import espe.edu.ec.carga_horaria.model.CabeceraPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vanessa
 */
@Repository
public interface CabeceraARepository extends CrudRepository<CabeceraA, CabeceraPK> {

    @Query(value = "select * from payroll.pzptcabperjact", nativeQuery = true)
    List<CabeceraA> findAllCabecera();
    // CabeceraPK findUserBypzptcabperjactActividad(long id);

    CabeceraA findByid(CabeceraPK id);
//CabeceraA findBy
    // deleteby;
//    CabeceraA findByPzptcabperjactActividadAndPzptcabperjactPidmandPzptcabperjacPeriodo(String actividad,Long pidm, String periodo); //CabeceraA delete(CabeceraPK id);
//CabeceraA deleteByPzptcabperjactActividad(String actividad);
//CabeceraA deleteByPzptcabperjactPidm(Long pidm);
    //Long deleteBypzptcabperjactPeriodo(String periodo);

    //Long deleteByPzptcabperjactActividad(@Param("pzptcabperjactActividad") String actividad);
    //Long deleteByPzptcabperjactPidm(@Param("pzptcabperjactPidm") String pidm);
    CabeceraA deleteByid(CabeceraPK id);

    //@Modifying
    //@Query("delete from payroll.pzptcabperjact p where p.pzptcabperjactPidm=:pidm and p.pzptcabperjactPeriodo=:periodo and p.pzptcabperjactActividad=:actividad")
    //Long deleteFruits(@Param("pzptcabperjactPidm") String pidm, @Param("pzptcabperjactPeriodo") String periodo, @Param("pzptcabperjactActividad") String actividad);
}
