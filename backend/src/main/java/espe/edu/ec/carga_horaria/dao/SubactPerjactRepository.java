/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.Perjact;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vanessa
 */
@Repository
public interface SubactPerjactRepository extends CrudRepository<Perjact, Long>{
     @Query(value = "select * from payroll.perjact", nativeQuery = true)
    List<Perjact> findByPerjactPidmAndPerjactEffectiveDateAndPerjactAstyCode(int pidm, Date fecha, String codSub);
//    Perjact findByPidmAndPerjactEffectiveDateAndPerjactJactCode(int pidm, Date fecha, String act);

}
