/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.Actividades;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Vanessa
 */
public interface ActividadesRepository extends CrudRepository <Actividades, Long>{
       @Query(value="select * from payroll.PTVJACT",nativeQuery=true)
    List<Actividades> findAllActividades();
}