/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.dao;

import espe.edu.ec.carga_horaria.model.Periodo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Vanessa
 */
public interface PeriodoRepository extends CrudRepository <Periodo, Long>{
      @Query(value="select * from saturn.stvterm order by stvterm_desc",nativeQuery=true)
    List<Periodo> findAllPeriodos();
    
    Periodo findByStvtermCode(String codeP);
    
    Periodo findByStvtermStartDate(Date FechaInicio);

    //public Date findByStvtermStartDate();
}
