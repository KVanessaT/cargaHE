import { Component, OnInit } from '@angular/core';
import { RestService } from 'app/service/rest.service';

declare const $: any;
// declare interface RouteInfo {
//   path: string;
//   title: string;
//   icon: string;
//   class: string;
// }

// export const ROUTES: RouteInfo[] = [
//   //{ path: '/hojaSalida', title: 'Hoja de Salida', icon: 'dashboard', class: '' },
//   //{ path: '/matriculaPac', title: 'Matrícula PAC', icon: 'person', class: '' },
//   //{ path: '/matriculaUte', title: 'Matrícula Titulación', icon: 'content_paste', class: '' },
//   /*{ path: '/typography', title: 'Typography', icon: 'library_books', class: '' },
//   { path: '/icons', title: 'Icons', icon: 'bubble_chart', class: '' },
//   { path: '/maps', title: 'Maps', icon: 'location_on', class: '' },
//   { path: '/notifications', title: 'Notifications', icon: 'notifications', class: '' },
//   { path: '/upgrade', title: 'Upgrade to PRO', icon: 'unarchive', class: 'active-pro' },*/
//   { path: '/docentes', title: 'Administrador', icon: 'dashboard', class: '' },//Ing Nelly L00012066
//   { path: '/directores', title: 'Director', icon: 'library_books', class: '' }//Ing Jaime L000012050


// ];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  usuarios: any;
datosUsuarios: any[];


  constructor(private rest: RestService) { }

  ngOnInit() {
    // this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.menuUsuario();
  }
  isMobileMenu() {
    if ($(window).width() > 991) {
      return false;
    }
    return true;
  };

  admn: string = 'L00012066';
  dir: string = 'L00012050';
  superU: string = 'L00290697';
  menuUsuario() {
    this.rest.getUsuario(this.admn + '/' + 41).subscribe(
      data => {
        this.menuItems = Array.from(
          new Set(data.opciones.map(x => x.opcion))
        ).map(datos => {
          return {
            opcion: data.opciones.find(s => s.opcion === datos).opcion,
            url: data.opciones.find(s => s.opcion === datos).url,
            icono: data.opciones.find(s => s.opcion === datos).icono,
            clase: data.opciones.find(s => s.opcion === datos).clase
          };
        });
      },
      error => {
        console.log(error);
      }
    )
  }
}
