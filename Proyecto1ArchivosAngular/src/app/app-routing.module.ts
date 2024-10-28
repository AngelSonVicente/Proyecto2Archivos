import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { ModuloUsuarioComponent } from './ModuloUsuario/modulo-usuario/modulo-usuario.component';
import { SubCarpetaUsuarioComponent } from './ModuloUsuario/sub-carpeta-usuario/sub-carpeta-usuario.component';



const routes: Routes = [
  {
    path: "",
    redirectTo: "/Proyecto2/Menu",
    pathMatch: "full"
  },
  {
    path: "Proyecto2/Menu",
    title: "Menu",
    component: MenuComponent
  },
  {
    path: 'Proyecto2/login/:userRole',
    title: "Login",
    component: LoginComponent 
  },
  {
    path: "Proyecto2/Modulo/Usuario",
    title: "Modulo",
    component: ModuloUsuarioComponent
  },
  {
    path: "Proyecto2/Usuario/Carpeta/:id",
    title: "Menu",
    component: SubCarpetaUsuarioComponent
  },
  
  


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
