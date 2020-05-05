/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espe.edu.ec.util;
import com.google.gson.Gson;
import espe.edu.ec.carga_horaria.model.messageApi;
/**
 *
 * @author Vanessa
 */
public class mensajes {
    private final Gson gson = new Gson();
 private final messageApi mensaje = new messageApi();

 public String add() {
  String msj = "Se cre\u00f3 correctamente";
  mensaje.setMessage(msj);
  return gson.toJson(mensaje);
 }
 public String delete() {
  String msj = "Se elimin\u00f3 correctamente";
  mensaje.setMessage(msj);
  return gson.toJson(mensaje);
 }

 public String update() {
  String msj = "Se actualiz\u00f3 correctamente";
  mensaje.setMessage(msj);
  return gson.toJson(mensaje);
 }

 public String notfound() {

  String msj = "No se encontraron resultados";
  mensaje.setMessage(msj);
  return gson.toJson(mensaje);
 }

 public String ifexiste() {

  String msj = "Informacion ya Existente";
  mensaje.setMessage(msj);
  return gson.toJson(mensaje);
 }
}

