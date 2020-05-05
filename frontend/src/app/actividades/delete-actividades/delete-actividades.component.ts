import { Component, OnInit, Inject, ViewContainerRef } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { RestService } from 'app/service/rest.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-delete-actividades',
  templateUrl: './delete-actividades.component.html',
  styleUrls: ['./delete-actividades.component.scss']
})
export class DeleteActividadesComponent implements OnInit {
  error: boolean;
  activar: boolean;
  horasA: any;
  info: any;
  menssaje: any
  options: any = {
    toastLife: 3000,
    dismiss: "auto",
    showCloseButton: true
  };
  periodos: any;

  constructor(public dialogRef: MatDialogRef<DeleteActividadesComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService,
    private rest: RestService) {
    this.error = false;
    this.activar = false;

  }

  ngOnInit() {
    this.compSubActividad();
    this.getDatosPeriodo();
  }

  eliminarActividad(): void {
    this.info = + this.data.pidm + '/' + this.data.periodo + '/' + this.data.actividad;
    this.rest.deleteData("deleteAct/" + this.info).subscribe(data => {
      console.log(data);
      // this.menssaje = data;
      this.toastr.success(data.message, 'La actividad');
      this.dialogRef.close(this.data);
      console.log(this.data);
      console.log("eliminado");
    });
  }

  getDatosPeriodo() {
    this.rest.getData('codePeriodo/' + this.data.periodo).subscribe(
      data => {
        this.periodos = data;
        console.log(this.periodos.stvtermStartDate);
      }
    )
  }

  compSubActividad(): void {
    this.rest.getData('getSub/' + this.data.pidm + '/' + this.data.periodo + '/' + this.data.actividad).subscribe(data => {
      if (data == true) {
        this.activar = true;
        //this.eliminarActividad();
      } else {
        this.error = true
      }


      // this.dialogRef.close(this.data);
      console.log(this.data);
      console.log(this.data.pidm, this.data.periodo, this.data.actividad, this.data.descr);
    });
  }

  cerrarModal() {
    this.dialogRef.close();
  }

}
