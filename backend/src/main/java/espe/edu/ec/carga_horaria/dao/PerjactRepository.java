/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.PerjactSA;
import espe.edu.ec.carga_horaria.model.PerjactSAPK;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Vanessa
 */
public interface PerjactRepository extends CrudRepository <PerjactSA, PerjactSAPK>{
      @Query(value = "select * from payroll.perjact", nativeQuery = true)
    List<PerjactSA> findAllPeriodos();
    PerjactSA findByid(PerjactSAPK id);
   // PerjactSA findByPerjactSAPKPidmAndPerjactPosnAndPerjactSuffAndEfectiveDateAndCodProvinciaAndCodActividadAndcodSubact(int pidm);

}
