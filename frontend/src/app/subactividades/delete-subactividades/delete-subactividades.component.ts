import { Component, OnInit, Inject, ɵConsole } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { RestService } from 'app/service/rest.service';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-delete-subactividades',
  templateUrl: './delete-subactividades.component.html',
  styleUrls: ['./delete-subactividades.component.scss']
})
export class DeleteSubactividadesComponent implements OnInit {

  info: any
  cabEditar: any;
  editarObj: {};
  mensaje: any

  constructor(public dialogRef: MatDialogRef<DeleteSubactividadesComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private rest: RestService,
    private spinner: NgxSpinnerService, private toastr: ToastrService) { }

  ngOnInit() {
    console.log(this.data);

  }
  


  eliminarSub() {
    this.info = + this.data.objeto.id.pidm + '/' + this.data.objeto.id.perjactPosn + '/' + this.data.objeto.id.perjactSuff + '/' + this.data.objeto.id.efectiveDate + '/' + this.data.objeto.id.codProvincia + '/' + this.data.objeto.id.codActividad + '/' + this.data.objeto.id.codSubact;
    this.rest.deleteData("deletSub/" + this.info).subscribe(data => {
      this.toastr.success(data.message, 'La subactividad');
      this.resetHorasCab();

    });
  }

  resetHorasCab() {
    this.rest.getData('cabsUPDATE/' + this.data.objeto.id.pidm + '/' + this.data.codP + '/' + this.data.descripcion.actividad).subscribe(
      data => {
        this.cabEditar = data;
        this.SetearCampoHoras();
      //  console.log(data);
        // this.dialogRef.close(this.data);
        //this.dialogRef.close(this.data);

      }
    )
  }
0.
  fileEliminar: any
  SetearCampoHoras() {
    this.fileEliminar = {

      "id": {
        "pzptcabperjactActividad": this.cabEditar.pzptcabperjactActividad,
        "pzptcabperjactFechaInicio": this.cabEditar.pzptcabperjactFechaInicio,
        "pzptcabperjactPidm": this.cabEditar.pzptcabperjactPidm,
      }, 
      "pzptcabperjactPeriodo": this.cabEditar.pzptcabperjactPeriodo,
      "pzptcabperjactHoras": this.cabEditar.pzptcabperjactHoras,
      "pzptcabperjactUnidadGestion": this.cabEditar.pzptcabperjactUnidadGestion,
      "pzptcabperjactResponsable": this.cabEditar.pzptcabperjactResponsable,
    }
    this.rest.updateData('editarSubact', this.fileEliminar).subscribe(
      data => {
        console.log(data);
        this.mensaje = data;
        this.dialogRef.close(data);
      }
    )


  }




}
