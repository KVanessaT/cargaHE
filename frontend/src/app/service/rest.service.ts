import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Observable } from "rxjs";

const ROL_USUARIO = 'https://servicios.espe.edu.ec:8443/adm_user-0.0.1-SNAPSHOT/adm/id/';
const API_URL = environment.url;
const http = {
  headers: new HttpHeaders({
    "Content-Type": "application/json",
    Accept: "application/json"
  })
};


@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private httpClient: HttpClient) { }

  getData(inf: String): Observable<any> {
    return this.httpClient.get<any>(API_URL + inf).pipe(
      map((data: any) => {
        return data;
      },
        error => {
          console.log('Error:', error);
        }
      )
    );
  }

  addData(item, info: String) {
    let agregarData = JSON.stringify(item);
    return this.httpClient.post(API_URL + info, agregarData, http).pipe(
      map(
        (data: any) => {
          return data;
        },
        error => {
          console.log('Error:', error);
        }
      )
    );
  }

  deleteData(info: String):Observable<any> {
    return this.httpClient.delete(API_URL + info)
    .map(res=> res );
       
  }

  updateData(info: string, item) {
    const updData = JSON.stringify(item);
    return this.httpClient.put(API_URL + info, updData, http).pipe(
      map(
        (data: any) => {
          return data;
        },
        error => {
          console.log('Error :', error);
        }
      )
    )
  }

  getUsuario(inf: String): Observable<any> {
    return this.httpClient.get<any>(ROL_USUARIO + inf).pipe(
      map((data: any) => {
        return data;
      },
        error => {
          console.log('Error:', error);
        }
      )
    );
  }



  findById(id: number, info: string) {
    return this.httpClient.get(API_URL + info + '/' + id, http).pipe
      (
        map((data: any) => {
          return data;
        },
          error => {
            console.log('Error: ', error)
          }
        )
      )
  }
}
