import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {ProgressBarModule} from 'primeng/progressbar';
import {ChartModule} from 'primeng/chart';

import {
  MatButtonModule,
  MatInputModule,
  MatRippleModule,
  MatFormFieldModule,
  MatTooltipModule,
  MatSelectModule,
  MatIconModule,
  MatDialogModule
} from '@angular/material';
import { MatSelectFilterModule } from 'mat-select-filter';

import { PacComponent } from 'app/pages/pac/pac.component';
import { DatosPersonalesComponent } from 'app/pages/secciones/datos-personales/datos-personales.component';
import { DatosAcademicosComponent } from 'app/pages/secciones/datos-academicos/datos-academicos.component';
import { DocentesComponent } from 'app/docentes/docentes.component';
import { ActividadesComponent } from 'app/actividades/actividades.component';
import { SubactividadesComponent } from 'app/subactividades/subactividades.component';
import { AddActividadesComponent } from 'app/actividades/add-actividades/add-actividades.component';
import { EditActividadesComponent } from 'app/actividades/edit-actividades/edit-actividades.component';
import { DeleteActividadesComponent } from 'app/actividades/delete-actividades/delete-actividades.component';
import { AddSubactividadesComponent } from 'app/subactividades/add-subactividades/add-subactividades.component';
import { EditSubactividadesComponent } from 'app/subactividades/edit-subactividades/edit-subactividades.component';
import { DeleteSubactividadesComponent } from 'app/subactividades/delete-subactividades/delete-subactividades.component';
import { PeriodoComponent } from 'app/periodo/periodo.component';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { DirectoresComponent } from 'app/directores/directores.component';
import { CamDepDocentesComponent } from 'app/cam-dep-docentes/cam-dep-docentes.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatRippleModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatTooltipModule,
    MatSelectFilterModule,
    TableModule,
    MatIconModule,
    DialogModule,
    ButtonModule,
    DropdownModule,
    MatDialogModule,
    ScrollingModule,
    MatProgressBarModule,
    ProgressBarModule,
    ChartModule

  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    PacComponent,
    DatosPersonalesComponent,
    DatosAcademicosComponent,
    TableListComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,
    DocentesComponent,
    ActividadesComponent,
    SubactividadesComponent,
    AddActividadesComponent,
    EditActividadesComponent,
    DeleteActividadesComponent,
    AddSubactividadesComponent,
    EditSubactividadesComponent,
    DeleteSubactividadesComponent,
    PeriodoComponent,
    DirectoresComponent,
    CamDepDocentesComponent

  ],
  entryComponents: [
    AddActividadesComponent,
    EditActividadesComponent,
    DeleteActividadesComponent,
    AddSubactividadesComponent,
    EditSubactividadesComponent,
    DeleteSubactividadesComponent,
    PeriodoComponent,
    SubactividadesComponent,
    ActividadesComponent

  ]
})

export class AdminLayoutModule {}
