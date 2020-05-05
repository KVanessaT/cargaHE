import { Component, OnInit, Inject, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { RestService } from 'app/service/rest.service';
import { MatDialog } from '@angular/material';
import { AddActividadesComponent } from './add-actividades/add-actividades.component';
import { EditActividadesComponent } from './edit-actividades/edit-actividades.component';
import { DeleteActividadesComponent } from './delete-actividades/delete-actividades.component';
import { EditSubactividadesComponent } from 'app/subactividades/edit-subactividades/edit-subactividades.component';
import { DeleteSubactividadesComponent } from 'app/subactividades/delete-subactividades/delete-subactividades.component';
import { AddSubactividadesComponent } from 'app/subactividades/add-subactividades/add-subactividades.component';
import { NgxSpinnerService } from "ngx-spinner";
import { Docentes } from 'app/models/docentes.model';
import { PeriodoComponent } from 'app/periodo/periodo.component';
import { Location } from '@angular/common';
import { DatePipe } from '@angular/common';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-actividades',
  templateUrl: './actividades.component.html',
  styleUrls: ['./actividades.component.scss']
})
export class ActividadesComponent implements OnInit {

  navigationSubscription
  public menssaje: any;
  period: any;
  pidm: any;
  fechaIni: any;
  fechaFin: any;
  actividades: any;
  cols: any[];
  horasActividad: any;
  subactividad: any;
  code_act: any;
  code: any;
  error: boolean;
  options: any = {
    toastLife: 3000,
    dismiss: "auto",
    showCloseButton: true
  };
  des: any;
  docente: Docentes = {
    nombres: '',
    apellido: '',
    pebemplPidm: 0,
    idBanner: '',
    numeroDocumento: '',
    prefijo: '',
    fechaNacimiento: '',
    nacionalidad: '',
    sexo: '',
    tipoSangre: '',
    estadoCivilSith: '',
  };
  periodos: any
  horSub: any;
  horAct: any;
  guardar: any;
  modificarDataSub: any
  datosEditSub: any
  pipe = new DatePipe('en-US');
  myFormattedDate: any
  alertR: boolean;
  alertA: boolean;
  alertM: boolean
  porcentaje: number;
  value: number = 0;
  dona: any
  hourD: number[]
  descripcionD: string[];
  constructor(private route: ActivatedRoute, private router: Router, private location: Location, private spinner: NgxSpinnerService,
    private rest: RestService, public dialog: MatDialog, private toastr: ToastrService) {
    this.navigationSubscription = this.router.events.subscribe((e: any) => {
      if (e instanceof NavigationEnd) {
        this.initializar();
      }
    });
  }

  ngOnInit() {
    this.initializar();
    this.getActiv();
    this.cols = [
      { field: 'pzptcabperjact_actividad', header: 'COD. Actividad' },
      { field: 'pzptcabperjact_actividad', header: 'Descripción' },
      { field: 'pzptcabperjact_horas', header: 'Horas' },
      { field: 'pzptcabperjact_unidad_gestion', header: 'Unidad' },
      { field: 'pzptcabperjact_responsable', header: 'Responsable' },
    ];
    this.getDatosDoc();
    //    this.getHoraAct();
    this.alertA = false;
    this.alertR = false;

  }

  initializar() {
    if ((this.route.snapshot.params.code_periodo) && (this.route.snapshot.params.pidm) && (this.route.snapshot.params.code)
      && (this.route.snapshot.params.inicioFecha) && (this.route.snapshot.params.fechFin)) {
      this.period = this.route.snapshot.params.code_periodo;
      this.pidm = this.route.snapshot.params.pidm;
      this.code = this.route.snapshot.params.code;
      this.fechaIni = this.route.snapshot.params.inicioFecha;
      this.fechaFin = this.route.snapshot.params.fechFin;
    }
    setTimeout(() => {
    }, 500);
  }

  getActiv(): void {
    this.spinner.show();
    // this.dialog.afterOpen.closed;
    this.rest.getData('act/' + this.period + '/' + this.pidm).subscribe(
      data => {
        this.actividades = data;
        this.getSubActiv();
        this.getHorasSub();//pidm+periodo
        //this.getHoraAct();//pidm+periodo+actividad
        this.progresBar();
        this.spinner.hide();
      }
    )
  }

  agregarAct(): void {
    const dialogRef = this.dialog.open(AddActividadesComponent, {
      closeOnNavigation: true,
      disableClose: true,
      width: '350px',
      data: { pidm: this.pidm, FechaIni: this.fechaIni, FechaFin: this.fechaFin, periodo: this.period, code: this.code }
    });
    dialogRef.afterClosed().subscribe(result => {
      this.getActiv();
      this.subactividad = [];
      //this.getHoraAct();
    });
  }

  editarAct(): void {
    const dialogRef = this.dialog.open(EditActividadesComponent, {
      data: this.actividades
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }

  guardarCodAct(codeA: string, hora: number, desAct: string) {
    this.code_act = codeA;
    this.horasActividad = hora;
    this.des = desAct;
    console.log("la actividad elegida es :" + this.code_act + "desc:" + this.des + ", Horas de la actividad: " + this.horasActividad);
  }

  eliminarAct(codeA: string, deAct: string, horas: number) {
    this.code_act = codeA;
    this.horasActividad = horas;
    this.des = deAct;
    console.log(this.code_act, this.horasActividad, this.pidm, this.period, this.code)
    const dialogRef = this.dialog.open(DeleteActividadesComponent, {
      data: { pidm: this.pidm, periodo: this.period, actividad: this.code_act, descr: this.des, code: this.code, horasAct: this.horasActividad }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.menssaje = result;

      this.getActiv();
    });
  }
  
  getSubActiv() {
    this.spinner.show();
    this.rest.getData('subA/' + this.pidm + '/' + this.period + '/' + this.code_act).subscribe(
      data => {
        this.subactividad = data;
        this.getHoraAct();
        this.spinner.hide();
        this.donut();
        this.prueb1a();
      }
    )
  }

  getSubActCodeAct(): void {
    this.dialog.afterOpen.closed;
    this.rest.getData('sub/' + this.code_act).subscribe(
      data => {
        this.actividades = data;
      }
    )
  }

  mensajeActualizar: any
  agregarSubAct(code_act: string): void {
    this.code_act = code_act;
    const dialogRef = this.dialog.open(AddSubactividadesComponent, {
      closeOnNavigation: true,
      disableClose: true,
      width: '350px',
      data: { pidm: this.pidm, FechaIni: this.fechaIni, FechaFin: this.fechaFin, periodo: this.period, code: this.code, code_act: this.code_act, horas: this.actividades.horasActividad }
    });
    dialogRef.afterClosed().subscribe(result => {
      this.mensajeActualizar = result;
      if (this.mensajeActualizar) {
       // this.toastr.success(this.mensajeActualizar.message, 'La Subactividad');
        this.getSubActiv();
        this.getActiv();
        console.log('si')
      } else {
        console.log('no')
      }
    });
  }

  info: any
  editarSubAct(subacti: any): void {
    this.myFormattedDate = this.pipe.transform(subacti.fechae, 'dd-MM-yyyy');
    this.info = + subacti.pidm + '/' + subacti.posn + '/' + subacti.suff + '/' + this.myFormattedDate + '/' + subacti.codprovincia + '/' + subacti.actividad + '/' + subacti.perjact_asty_code;
    this.rest.getData('editSub/' + this.info).subscribe(
      (data:{}) => {
        this.datosEditSub = data
        const dialogRef = this.dialog.open(EditSubactividadesComponent, {
          closeOnNavigation: true,
          disableClose: true,
         
          data: {objeto:this.datosEditSub, descripcion: subacti, actividades: this.actividades, codP: this.period}    //{ objeto: this.datosEditSub, descripcion: subacti, actividades: this.actividades }
        });
        dialogRef.afterClosed().subscribe(result => {
this.mensaje = result;
console.log(result);
if(this.mensaje){

  this.getActiv();
  this.getHorasSub();
  console.log('si')
}else{
  console.log('no')
}

        });

      }
    )

  }

  mensaje: any

  eliminarSubAct(subact: any): void {
    this.myFormattedDate = this.pipe.transform(subact.fechae, 'dd-MM-yyyy');
    this.modificarDataSub = {
      "perjactPidm": subact.pidm,
      "perjactPosn": subact.posn,
      "perjactSuff": subact.suff,
      "perjactEffectiveDate": this.myFormattedDate,
      "perjactDicdCode": subact.codprovincia,
      "perjactJactCode": subact.actividad,
      "perjactAstyCode": subact.perjact_asty_code
    }
    this.rest.updateData('getSubact', this.modificarDataSub).subscribe(
      (data: {}) => {
        this.datosEditSub = data

        const dialogRef = this.dialog.open(DeleteSubactividadesComponent, {
          closeOnNavigation: true,
          disableClose: true,
          data: { objeto: this.datosEditSub, descripcion: subact, codP: this.period }
        });
        dialogRef.afterClosed().subscribe(result => {
          this.mensaje = result
          console.log(result);
          if (this.mensaje) {

            this.getActiv();
            this.getSubActiv();
            console.log('si')
          } else {
            console.log('no')
          }
        });

      }
    )
  }

  getDatosDoc(): void {
    this.rest.getData('doc/' + this.pidm).subscribe(
      data => {
        this.docente = data;
      }
    )
  }

  //Envía a componente de periodos
  getPer() {
    const dialogRef = this.dialog.open(PeriodoComponent, {
      closeOnNavigation: true,
      disableClose: true,
      width: '400px',
      data: { pidm: this.pidm, code: this.code }
    });
    dialogRef.afterClosed().subscribe(result => {
      this.getActiv();
      this.getSubActiv();
    });
  }

  cancel() {
    this.location.back(); // <-- go back to previous location on cancel
  }

  getHoraAct() {
    this.dialog.afterOpen.closed;
    this.rest.getData('sumaH/' + this.pidm + '/' + this.period + '/' + this.code_act).subscribe(
      data => {
        this.horAct = data;
      }
    )
  }

  getHorasSub() {
    this.dialog.afterOpen.closed;
    this.rest.getData('sumaHT/' + this.pidm + '/' + this.period).subscribe(
      data => {
        this.horSub = data;
      }
    )
  }

  trueFal() {
    this.spinner.show();
    this.rest.getData('trueFalse/' + this.pidm + '/' + this.period).subscribe(
      data => {
        console.log(data)
        console.log(this.horSub);
        this.spinner.hide();
        if (data == 1) {
          this.alertA = true;
        }
        else if (data == 2) {
          this.alertM = true;
        }
        else {
          this.alertR = true
        }
      }
    )
  }

  progresBar() {
    this.rest.getData('porcen/' + this.pidm + '/' + this.period).subscribe(
      data => {
        this.value = data;
      }
    )
  }

  pp: any[] = [];
  desDona: any[] = []
  horasS: any = 0;
  horasSubDona: any;


  donut() {
    for (let numero of this.subactividad) {
      this.pp.push(numero.perjact_std_hrs_per_pay);
      this.desDona.push(numero.stvasty_desc);
    }
    this.dona = {
      labels: this.desDona,
      datasets: [
        {
          data: this.pp,
          backgroundColor: [
            "#FF6384",
            "#36A2EB",
            "#FFCE56",
            "#1ddb23",
            "#1d20db",
            "#991ddb",
            "#8cdb1d"
          ],
          hoverBackgroundColor: [
            "#FF6384",
            "#36A2EB",
            "#FFCE56",
            "#1ddb23",
            "#1d20db",
            "#991ddb",
            "#8cdb1d"
          ]
        }]
    };

  }

  prueb1a() {
    this.pp = []
    this.desDona = []
  }
}


