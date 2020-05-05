import { Component, OnInit, Inject, ɵConsole } from '@angular/core';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { RestService } from 'app/service/rest.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-periodo',
  templateUrl: './periodo.component.html',
  styleUrls: ['./periodo.component.scss']
})
export class PeriodoComponent implements OnInit {
  myControl = new FormControl();
  navigationSubscription
  pidm: any;
  code_periodo: any;
  fechIn: any;
  fechFin: any;
  periodos: any;
  actividades: { code_periodo: string, pidm: number };
  code: any;
  inicioFecha: any;
  allPerio: any;
  constructor(private route: ActivatedRoute, private router: Router, private Restservice: RestService, public dialogRef: MatDialogRef<PeriodoComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit() {
    //this.getPer();
    this.getAllper();
  }

  initializar() {
    if (this.route.snapshot.params.pidm) {
      this.pidm = this.route.snapshot.params.pidm;
    }
    setTimeout(() => {
    }, 500);
  }


  filteredList1: any;
  getPer(): void {
    this.Restservice.getData('per/' + this.data.pidm).subscribe(
      data => {
        this.periodos = data;
        console.log(data);
        this.filteredList1 = this.periodos;
        console.log(this.filteredList1, this.periodos);

      }
    )
  }

  getAllper() {
    this.Restservice.getData('allperiodos').subscribe(
      data => {
        this.periodos = data;
        console.log(data);
        this.filteredList1 = this.periodos;
        console.log(this.filteredList1, this.periodos);

      }
    )
  }

  guardarPer(periodo: string, end: string, inicio: string) {
    this.code_periodo = periodo;
    this.pidm = this.data.pidm;
    this.code = this.data.code;
    this.fechFin = end;
    this.inicioFecha = inicio;
  }

  //trae los periodos de un docente
  getPeriodosDocente(pidm: number) {
    this.Restservice.getData('per/' + pidm).subscribe(
      data => {
        this.pidm = pidm
      }
    )
  }

  getActividades() {
    this.actividades = this.route.snapshot.params.data;
    // this.router.navigate(['/actividades', this.code_periodo, this.pidm, this.code, this.inicioFecha, this.fechFin], { skipLocationChange: true});
    this.router.navigate(['/actividades', this.code_periodo, this.pidm, this.code, this.inicioFecha, this.fechFin], { skipLocationChange: true});

  }
}
