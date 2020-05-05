/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.CabPeriodo;
import espe.edu.ec.carga_horaria.model.CabPeriodoPK;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vanessa
 */
@Repository

public interface CabPeriodoRepository extends CrudRepository<CabPeriodo, CabPeriodoPK> {

    @Query(value = "select * from payroll.pzptcabperjact", nativeQuery = true)

    List<CabPeriodo> findAllCabPeriodo();
}
