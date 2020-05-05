import { Component, OnInit, Inject, ɵConsole } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { RestService } from 'app/service/rest.service';
import { ToastrService } from 'ngx-toastr';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-edit-subactividades',
  templateUrl: './edit-subactividades.component.html',
  styleUrls: ['./edit-subactividades.component.scss']
})


export class EditSubactividadesComponent implements OnInit {
  datosSubactividades: any
  info: any;
  pipe = new DatePipe('en-US');
  now = Date.now();
  f1:any;
  f2:any;
  mensaje: any;
  maxHora: boolean;
  activar: boolean;
  objectoeditar: any;
  
  constructor(public dialogRef: MatDialogRef<EditSubactividadesComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private rest: RestService,
    private spinner: NgxSpinnerService, private toastr: ToastrService) {
      this.maxHora = false;
      this.activar = false;

  }

  ngOnInit() {
    
  }

  sumaHorasSub() {
    this.rest.getData('horasEditar/' + this.data.objeto.id.pidm + '/' + this.data.codP + '/' + this.data.objeto.id.codActividad + '/' + this.data.descripcion.perjact_std_hrs_per_pay + '/'+this.data.objeto.horas).subscribe(
      data => {
        if (data == true) {
         // this.activar = true
          this.updObjeto();
        } else {
          this.maxHora = true;
        }
      }
    )
  }

  updObjeto() {
     this.f1 =this.pipe.transform(this.data.objeto.id.efectiveDate, 'dd-MM-yyyy');
     this.f2 = this.pipe.transform(this.data.objeto.fechaActividad, 'dd-MM-yyyy');

     this.data.objeto.id.efectiveDate =this.f1;
     this.data.objeto.fechaActividad = this.f2;
    this.rest.updateData('editarSAc' ,this.data.objeto).subscribe(
      data => {
        this.toastr.success(data.message, 'La subactividad');
        console.log(data);
        this.updCab();
       // this.mensaje = data;
        //this.dialogRef.close(data);
      }
    )
  }


  updCab() {
    this.spinner.show();
    this.rest.getData('cabsUPDATE/' + this.data.objeto.id.pidm + '/' + this.data.codP + '/' + this.data.objeto.id.codActividad).subscribe(
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
