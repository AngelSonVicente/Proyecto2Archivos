import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/entities/Usuario';
import { LoginService } from 'src/services/LoginService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  usuario!: Usuario;
  invitado!: boolean;

  
  error: boolean = false;



  userRole!: string;



  constructor( private formBuilder: FormBuilder, private route: ActivatedRoute, private loginService: LoginService, private router: Router) {


    this.usuario = new Usuario;


  }

  ngOnInit(): void {
    // Obtener el parámetro de la ruta 'userRole'
    this.route.params.subscribe(params => {
      this.userRole = params['userRole'];
      console.log(this.userRole); // Aquí tienes el valor de userRole
    });
  }




  onSubmit() {

    this.usuario.tipo = this.userRole;
    this.loginService.logear(this.usuario).subscribe(
      usuario => {


        if (usuario) {
          localStorage.setItem('usuario', JSON.stringify(usuario));
          this.invitado = false;
          console.log("Tipo de Usuario en el Local Storage: " + usuario.tipo);
        
          

          if (usuario.tipo == "usuario") {
          
              this.router.navigate(['Proyecto2/Modulo/Usuario']);
            
          }

          if (usuario.tipo == "admin") {
          
              this.router.navigate(['Proyecto2/Modulo/Admin']);
            
          }


          
     










        } else {
          this.error = true;
        }
      },
      error => {
        console.log('Error: ', error);
        this.error = true;
      }
    );
  }







}
