import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CrearCarpeta } from 'src/entities/CrearCarpeta';
import { User } from 'src/entities/User';
import { Usuario } from 'src/entities/Usuario';
import { SubCarpetaService } from 'src/services/SubCarpetaService';
import { UsuarioService } from 'src/services/UsuarioService';

@Component({
  selector: 'app-crear-sub-carpeta-raiz',
  templateUrl: './crear-sub-carpeta-raiz.component.html',
  styleUrls: ['./crear-sub-carpeta-raiz.component.css']
})
export class CrearSubCarpetaRaizComponent implements OnInit {




  FormularioOferta!: FormGroup;
  saved : boolean=false;


  error: boolean = false;
  
  codigoCreado!:string;

  carpetaCreacion!:CrearCarpeta;
  usuario!: Usuario;


  constructor( private formBuilder: FormBuilder, 
    private route: ActivatedRoute, private router: Router, private subCarpetaService:SubCarpetaService) { }
  ngOnInit(): void {
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario = jsonUsuario ? JSON.parse(jsonUsuario) : null;

       

    


    this.FormularioOferta = this.formBuilder.group({
      nombre: [null, [Validators.required]],
  
      

    });



 

  }

  submit(): void {
    
      this.carpetaCreacion = this.FormularioOferta.value as CrearCarpeta;
      
      this.carpetaCreacion.codigoUsuario=this.usuario.codigo;
      this.carpetaCreacion.pathPadre="/raiz"+this.usuario.usuario;

    
      this.subCarpetaService.crearSubCarpeta(this.carpetaCreacion).subscribe({
        next: (created: CrearCarpeta) => {
          console.log("creado " + created);
        
          this.saved = true;
          this.error=false;
          this.limpiar()
          window.location.reload();

        },
        error: (error: any) => {
          console.log("error");
          this.error=true;

        }
      });
    
  }
  limpiar(): void {
    this.FormularioOferta.reset({

    });

  }






}
