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


  constructor(private usuarioService : UsuarioService, private router:Router){


  }

  ngOnInit(): void {



    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    


  
    
    
    this.usuarioService.getUsuario(this.usuario.usuario).subscribe({

      next: (clienteBD: User) => {

        this.usuarioCompleto=clienteBD;

        
        
      
        
      },
      error: (error: any) => {

      
      }
    });



 
  }

  abrirCarpeta(carpeta:Carpeta){

    this.router.navigate(['/detalle-carpeta', carpeta._id], { state: { carpeta } });



  }



}
