/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Vanessa
 */
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    @Query(value = "select * from baninst1.bzsvempleado", nativeQuery = true)
    List<Empleado> findallEmpleados();

    Empleado findByIdBanner(String banner);
     Empleado findByPebemplPidm(int pidm);
     Empleado findByCodeDedicacion(String coDedi);
    //public Empleado findAllById(Long pebemplPidm);
}
