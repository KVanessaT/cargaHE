import { Component, OnInit, Inject } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { RestService } from 'app/service/rest.service';
import { DatePipe } from '@angular/common';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-add-subactividades',
  templateUrl: './add-subactividades.component.html',
  styleUrls: ['./add-subactividades.component.scss']
})
export class AddSubactividadesComponent implements OnInit {
  subactividades: any;
  guardar: any;
  code_act: any
  codS: string;
  descS: string;
  period: any;
  error: boolean;
  activar: boolean;
  hora: number;
  horaActivar: boolean;
  periodo: any
  pipe = new DatePipe('en-US');
  now = Date.now();
  myFormattedDate = this.pipe.transform(this.now, 'dd-MM-yyyy');
  efec = this.data.FechaIni;
  efecDate = this.pipe.transform(this.efec, 'dd-MM-yyyy');
  posicion: any;
  posn: any;
  objectoeditar: any;
  maxHora: boolean;
  mensaje: any;
  constructor(public dialogRef: MatDialogRef<AddSubactividadesComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private rest: RestService, 
    private spinner: NgxSpinnerService, private toastr: ToastrService) {
    this.activar = false;
    this.error = false;
    this.horaActivar = false;
    this.maxHora = false;
  }

  ngOnInit() {
    this.getSubactividades();
    this.getPosn();
  }

  subact(codAct: string) {
    this.code_act = codAct;
  }

  getSubactividades() {
    this.rest.getData('sub/' + this.data.code_act).subscribe(
      data => {
        this.subactividades = data;
      }
    )
  }

  getPosn() {
    this.rest.getData('posn/' + this.data.pidm).subscribe(
      data => {
        this.posicion = data[0].nbrjobsPosn;

      }
    )
  }

  catchSub(codeSub: string, descripcionSub: string) {
    this.codS = codeSub;
    this.descS = descripcionSub;
    this.period = this.data.periodo;
  }

  comprobarSub() {
    this.spinner.show();
    this.rest.getData('su/' + this.data.pidm + '/' + this.data.periodo + '/' + this.codS).subscribe(
      data => {
        this.spinner.hide();
        if (data == true) {
          this.error = false
          this.activar = true;
          this.horaActivar = true;
        } else {
          this.activar = false;
          this.error = true;
        }
      }
    )
  }

  //cerrar mat-dialog
  onNoClick(): void {
    this.dialogRef.close();
  }

 

  sumaHorasSub() {
    this.rest.getData('subActividad/' + this.data.pidm + '/' + this.period + '/' + this.data.code_act + '/' + this.hora).subscribe(
      data => {
        if (data == true) {
          this.guardarM();
        } else {
          this.maxHora = true;
        }
      }
    )
  }

   guardarM() {
    this.guardar = {
      "id": {
        "pidm": this.data.pidm,
        "perjactPosn": this.posicion,
        "perjactSuff": "00",
        "efectiveDate": this.efecDate,
        "codProvincia": "17",
        "codActividad": this.data.code_act,
        "codSubact": this.codS,

      },
      "horas": this.hora,
      "porcentaje": 99,
      "perjactFte": "1",
      "fechaActividad": this.myFormattedDate
    }
    console.log(this.guardar)

    this.rest.addData(this.guardar, "perjact").subscribe(
      data => {
        this.toastr.success(data.message, 'La Subactividad');
        this.getSubactividades();
        this.updCab();
      },
      error => {
        console.log("error al guardar", error);
      }
    )
  }
  //objectoeditar:any;
  updCab() {
    this.spinner.show();
    this.rest.getData('cabsUPDATE/' + this.data.pidm + '/' + this.period + '/' + this.data.code_act).subscribe(
      data => {
        this.objectoeditar = data;
        this.updCabAct();
        this.spinner.hide();

      },
      error => {
      }
    )
  }
  modeloedit: any
  updCabAct() {
    console.log(this.guardar);
    this.modeloedit = {
      "id": {
        "pzptcabperjactActividad": this.objectoeditar.pzptcabperjactActividad,
        "pzptcabperjactFechaInicio": this.objectoeditar.pzptcabperjactFechaInicio,
        "pzptcabperjactPidm": this.objectoeditar.pzptcabperjactPidm,
      },
      "pzptcabperjactPeriodo":this.objectoeditar.pzptcabperjactPeriodo,
      "pzptcabperjactHoras": this.objectoeditar.pzptcabperjactHoras,
      "pzptcabperjactUnidadGestion": this.objectoeditar.pzptcabperjactUnidadGestion,
      "pzptcabperjactResponsable": this.objectoeditar.pzptcabperjactResponsable,
    }

    this.rest.updateData('editarSubact',this.modeloedit).subscribe(
      data => {
        this.mensaje = data;
        this.dialogRef.close(data);
      },
      error => {
      }
    )
  }
}


