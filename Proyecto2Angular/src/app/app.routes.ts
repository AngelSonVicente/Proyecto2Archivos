import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [


    {
        path: "",
        redirectTo: "/Proyecto2/Menu",
        pathMatch: "full"
      },
      {
        path: "Proyecto2/Menu",
        title: "Menu",
        component: LoginComponent
      },
];
