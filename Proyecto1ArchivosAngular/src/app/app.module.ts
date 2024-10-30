import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';





import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ModuloUsuarioComponent } from './ModuloUsuario/modulo-usuario/modulo-usuario.component';
import { SubCarpetaUsuarioComponent } from './ModuloUsuario/sub-carpeta-usuario/sub-carpeta-usuario.component';
import { VisorArchivoComponent } from './ModuloUsuario/visor-archivo/visor-archivo.component';
import { ModuloAdminComponent } from './ModuloAdmin/modulo-admin/modulo-admin.component';
import { RegistrarUsuariosComponent } from './ModuloAdmin/registrar-usuarios/registrar-usuarios.component';







@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    ModuloUsuarioComponent,
    SubCarpetaUsuarioComponent,
    VisorArchivoComponent,
    ModuloAdminComponent,
    RegistrarUsuariosComponent,

    
    
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
