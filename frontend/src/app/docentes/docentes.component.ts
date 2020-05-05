import { Component, OnInit } from '@angular/core';
import { RestService } from '../service/rest.service';
import { NgxSpinnerService } from "ngx-spinner";
import { Router, ActivatedRoute } from "@angular/router";
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PeriodoComponent } from 'app/periodo/periodo.component';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-docentes',
  templateUrl: './docentes.component.html',
  styleUrls: ['./docentes.component.scss']
})
export class DocentesComponent implements OnInit {
  campus: any;
  departamentos: any;
  nombreCamp: any;
  nombreDep: any;
  personas: any;
  pidm: any;
  code_periodo: any;
  //fechIn: any;
  //fechFin: any
  //actividades: { code_periodo: string, pidm: number };
  //displayBasic: boolean;
  periodos: { pidm: number, code: string };
  code: any;
  cols: any[];
  constructor(private rest: RestService, private spinner: NgxSpinnerService, 
    private rutaActiva: ActivatedRoute, private router: Router, public dialog: MatDialog,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.getCampus();
    this.getDepart();
    this.cols = [
      { field: 'id_banner', header: 'ID Docente' },
      { field: 'nombres', header: 'Nombres' },
      { field: 'apellido', header: 'Apellidos' },
      { field: 'dedicacion', header: 'Dedicación' },
    ];
  }

  //Lista de campus
  getCampus() {
    this.rest.getData('allcampus').subscribe(
      data => {
        this.campus = data
        console.log(data)
      }
    );
  }

  //Lista de departamentos
  getDepart() {
    this.rest.getData('alldepts').subscribe(
      data => {
        this.departamentos = data
        console.log(data)
      }
    );
  }

  //Lista de periodos
  getPer() {
    this.rest.getData('allperiodos').subscribe(
      data => {
    //this.toastr.success(data.message, 'La subactividad');
        this.periodos = data
        console.log(data)
      }
    );
  }

  //Guarda campus seleccionado
  guardarcampus(nameCampus: string) {
    this.nombreCamp = nameCampus;
    console.log("nombre de campus es :" + this.nombreCamp);
  }

  //Guarda departamento seleccionado
  guardarDept(nameDep: string) {
    this.nombreDep = nameDep;
    console.log("nombre departamento:" + this.nombreDep);
  }

  //consulta campus y departamento mediante un pidm
  getCampDep() {
    this.spinner.show();
    this.rest.getData('idm/' + this.nombreDep + '/' + this.nombreCamp).subscribe(
      data => {
        if(data.message){
          this.toastr.warning(data.message, 'Error:')
          this.personas = []
        }else{
          this.personas = data;
        }
        this.spinner.hide();
        if (Object.keys(data).length === 0) {
        }
        (err: any) => {
          console.log(err);
        }
      }
    )
  }

  //Envía a componente de periodos
  periodoComponent(pidm: number, code: string): void {
    this.pidm = pidm;
    this.code = code;
    console.log(pidm, code);
    const dialogRef = this.dialog.open(PeriodoComponent, {
      closeOnNavigation: true,
      disableClose: true,
      data: { pidm: this.pidm, code: this.code }
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }

//Guarda periodo seleccionado
  // guardarPer(periodo: string, fecIn: string) {
  //   this.code_periodo = periodo;
  //   this.fechIn = fecIn;
  //   console.log(this.code_periodo, this.fechIn);
  // }

//Listar actividades
  // getActividades() {
  //   // this.actividades = this.rutaActiva.snapshot.params.data;
  //   this.router.navigate(['/actividades', this.code_periodo, this.pidm, this.fechIn]);
  //   console.log('get actividades', this.actividades);
  // }

  //consulta actividades
  // getPidmPer(code_periodo: string, pidm: number) {
  //   this.rest.getData('act/' + this.code_periodo + '/' + this.pidm).subscribe(
  //     data => {
  //       this.actividades = data;

  //       console.log(data);
  //       console.log('data recibida:', data);
  //     }

  //   );
  //   this.getActividades();

  //   console.log(this.pidm, this.code_periodo);

  // }
  // showBasicDialog() {
  //   this.displayBasic = true;
  // }

}
