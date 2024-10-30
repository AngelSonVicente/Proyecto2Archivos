import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { ModuloUsuarioComponent } from './ModuloUsuario/modulo-usuario/modulo-usuario.component';
import { SubCarpetaUsuarioComponent } from './ModuloUsuario/sub-carpeta-usuario/sub-carpeta-usuario.component';
import { VisorArchivoComponent } from './ModuloUsuario/visor-archivo/visor-archivo.component';
import { ModuloAdminComponent } from './ModuloAdmin/modulo-admin/modulo-admin.component';
import { RegistrarUsuariosComponent } from './ModuloAdmin/registrar-usuarios/registrar-usuarios.component';






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
    title: "Carpeta",
    component: SubCarpetaUsuarioComponent
  },  
  {
    path: "Proyecto2/Usuario/Archivo/:id",
    title: "Visor",
    component: VisorArchivoComponent
  },
  



    {
    path: "Proyecto2/Modulo/Admin",
    title: "Modulo",
    component: ModuloAdminComponent
  },
  {
    path: "Proyecto2/Admin/RegistrarUsuarios",
    title: "Registrar Usuario",
    component: RegistrarUsuariosComponent
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
