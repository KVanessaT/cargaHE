/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.vo;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vanessa
 */
@Service
public class actividadesDocentesVo {
    
    
    private static String opciones = " from payroll.Pzptcabperjact CP "
            + " INNER JOIN PAYROLL.PERJACT P ON CP.pzptcabperjact_actividad = P.perjact_jact_code "
            + " INNER JOIN PAYROLL.ptvjact PJ ON CP.PZPTCABPERJACT_actividad = pj.ptvjact_code";
    
       @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<actividadesVo> getActDoc(String q) throws SQLException {
        String opcion = "select pzptcabperjact_actividad, PTVJACT_DESC, pzptcabperjact_periodo, pzptcabperjact_horas, pzptcabperjact_unidad_gestion, pzptcabperjact_responsable, pzptcabperjact_pidm";
        return jdbcTemplate.query(opcion + opciones + q, new BeanPropertyRowMapper<>(actividadesVo.class));
    }
    
}
