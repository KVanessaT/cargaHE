import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { PacComponent } from 'app/pages/pac/pac.component';
import { ActividadesComponent } from 'app/actividades/actividades.component';
import { DocentesComponent } from 'app/docentes/docentes.component';
import { PeriodoComponent } from 'app/periodo/periodo.component';
import { SubactividadesComponent } from 'app/subactividades/subactividades.component';
import { DirectoresComponent } from 'app/directores/directores.component';

export const AdminLayoutRoutes: Routes = [
     {
       path: '',
       children: [ {
         path: 'dashboard',
         component: DashboardComponent
     }]}, 
    //{
    // path: '',
    // children: [ {
    //   path: 'userprofile',
    //   component: UserProfileComponent
    // }]
    // }, {
    //   path: '',
    //   children: [ {
    //     path: 'icons',
    //     component: IconsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'notifications',
    //         component: NotificationsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'maps',
    //         component: MapsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'typography',
    //         component: TypographyComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'upgrade',
    //         component: UpgradeComponent
    //     }]
    // }
    { path: 'hojaSalida',      component: DashboardComponent },
    { path: 'matriculaPac',   component: PacComponent },
    { path: 'matriculaUte',     component: TableListComponent },
    { path: 'typography',     component: TypographyComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'notifications',  component: NotificationsComponent },
    { path: 'upgrade',        component: UpgradeComponent },
    //{ path: 'actividades/:code_periodo/:pidm/:fechIn', component: ActividadesComponent }
    { path: 'docentes', component: DocentesComponent},
    { path: 'actividades/:code_periodo/:pidm/:code/:inicioFecha/:fechFin', component: ActividadesComponent },
    { path: 'subactividades/:pidm/:code_periodo/:code_actividad', component: SubactividadesComponent },
    { path: 'directores', component: DirectoresComponent }

];
