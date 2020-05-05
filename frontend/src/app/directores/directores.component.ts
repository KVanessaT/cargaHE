import { Component, OnInit } from '@angular/core';
import { RestService } from 'app/service/rest.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { PeriodoComponent } from 'app/periodo/periodo.component';

@Component({
  selector: 'app-directores',
  templateUrl: './directores.component.html',
  styleUrls: ['./directores.component.scss']
})
export class DirectoresComponent implements OnInit {
ncampus: any;
ndepar: any;
banner: string = "L00068841	";
personas: any;
datosDir: any;
pidm: any;
code: any;
cols: any[];

  constructor(private rest: RestService, private spinner: NgxSpinnerService, private rutaActiva: ActivatedRoute, private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.getUsuarioIdBanner();
    this.cols = [
      { field: 'id_banner', header: 'ID Docente' },
      { field: 'nombres', header: 'Nombres' },
      { field: 'apellido', header: 'Apellidos' },
      { field: 'dedicacion', header: 'Dedicación' },
    ];
  }

  getUsuarioIdBanner() {
    this.rest.getData('ban/' + this.banner).subscribe(
      data => {
        this.datosDir = data;
        console.log(data.campus, data.departamento, data.pebemplPidm);
        
        if (Object.keys(data).length === 0) {
        }
        (err: any) => {
          console.log(err);
        }

        this.ndepar = this.datosDir.departamento;
        this.ncampus= this.datosDir.campus;
      }
    )
  }

  getDocentes() {
    this.spinner.show();
    this.rest.getData('idm/' + this.ndepar + '/' + this.ncampus).subscribe(
      data => {
        this.personas = data;
        console.log(data);
        this.spinner.hide();
        if (Object.keys(data).length === 0) {
        }
        (err: any) => {
          console.log(err);
        }
      }
    )
  }
   //consulta campus y departamento mediante un pidm
  //  getCampDep() {
  //   this.spinner.show();
  //   this.rest.getData('idm/' + this.nombreDep + '/' + this.nombreCamp).subscribe(
  //     data => {
  //       this.personas = data;
  //       console.log(this.pidm);
  //       this.spinner.hide();
  //       if (Object.keys(data).length === 0) {
  //       }
  //       (err: any) => {
  //         console.log(err);
  //       }
  //     }
  //   )
  // }

   //Envía a componente de periodos
   periodoComponent(pidm: number, code: string): void {
    this.pidm = pidm;
    this.code = code;
    console.log(pidm, code);
    const dialogRef = this.dialog.open(PeriodoComponent, {
      closeOnNavigation: true,
      disableClose: true,
      width: '400px',
      data: { pidm: this.pidm, code: this.code }
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }
}
