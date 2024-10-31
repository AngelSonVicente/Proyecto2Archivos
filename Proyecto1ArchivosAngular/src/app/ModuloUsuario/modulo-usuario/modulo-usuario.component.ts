import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carpeta } from 'src/entities/Carpeta';
import { User } from 'src/entities/User';
import { Usuario } from 'src/entities/Usuario';
import { UsuarioService } from 'src/services/UsuarioService';

@Component({
  selector: 'app-modulo-usuario',
  templateUrl: './modulo-usuario.component.html',
  styleUrls: ['./modulo-usuario.component.css']
})
export class ModuloUsuarioComponent implements OnInit{

  usuarioCompleto!:User;
  usuario!:Usuario;
  carpetas:boolean=false;
  archivos:boolean=false;



  constructor(private usuarioService : UsuarioService, private router:Router){


  }

  ngOnInit(): void {



    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    


  
    
    
    this.usuarioService.getUsuario(this.usuario.usuario).subscribe({

      next: (clienteBD: User) => {

        this.usuarioCompleto=clienteBD;

      this.usuario.codigo=this.usuarioCompleto.id;
      localStorage.setItem('usuario', JSON.stringify(this.usuario));
        
        
      
        
      },
      error: (error: any) => {

      
      }
    });



    this.verificarCarpetas();
    this.verificararchivos();



 
  }

  abrirCarpeta(carpeta:Carpeta){

    this.router.navigate(['/detalle-carpeta', carpeta._id], { state: { carpeta } });



  }
  verificarCarpetas(): void {
    this.carpetas = this.usuarioCompleto?.carpetaRaiz?.subcarpetas?.length > 0;
  }


  verificararchivos(): void {
    this.carpetas = this.usuarioCompleto?.carpetaRaiz?.archivos?.length > 0;
  }


}
