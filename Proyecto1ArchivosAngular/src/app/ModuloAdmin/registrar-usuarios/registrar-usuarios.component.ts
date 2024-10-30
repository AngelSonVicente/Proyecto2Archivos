import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/entities/Usuario';
import { UsuarioService } from 'src/services/UsuarioService';

@Component({
  selector: 'app-registrar-usuarios',
  templateUrl: './registrar-usuarios.component.html',
  styleUrls: ['./registrar-usuarios.component.css']
})
export class RegistrarUsuariosComponent implements OnInit {



  FormularioOferta!: FormGroup;
  saved : boolean=false;

  error: boolean = false;
  UsuarioCreacion!:Usuario;
  codigoCreado!:string;

  usuario!: Usuario;


  constructor(private usuarioService: UsuarioService, private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router) { }
  ngOnInit(): void {
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario = jsonUsuario ? JSON.parse(jsonUsuario) : null;

    this.FormularioOferta = this.formBuilder.group({
      nombre: [null, [Validators.required, Validators.maxLength(60)]],
      usuario: [null, [Validators.required, Validators.maxLength(50)]],
      
      correo: [null, [Validators.required]],
      password: [null, [Validators.required,Validators.maxLength(100)]],
     

    });

 

  }

  submit(): void {
    if (this.FormularioOferta.valid) {
      this.UsuarioCreacion = this.FormularioOferta.value as Usuario;

    
      this.usuarioService.crearUsuario(this.UsuarioCreacion).subscribe({
        next: (created: Usuario) => {
          console.log("creado " + created);
        
          this.saved = true;
          this.error=false;
          this.limpiar()
        },
        error: (error: any) => {
          console.log("error");
          this.error=true;

        }
      });
    }
  }
  limpiar(): void {
    this.FormularioOferta.reset({

    });

  }



}
