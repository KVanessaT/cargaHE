/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.carga_horaria.model;

import java.io.Serializable;

/**
 *
 * @author Vanessa
 */
public class messageApi implements Serializable{
    private static final long serialVersionUID = 1L;

 private String message;

 public messageApi() {
 }

 public String getMessage() {
  return message;
 }

 public void setMessage(String message) {
  this.message = message;
 }

}
