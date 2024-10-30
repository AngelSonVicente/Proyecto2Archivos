import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Carpeta } from 'src/entities/Carpeta';
import { Usuario } from 'src/entities/Usuario';
import { SubCarpetaService } from 'src/services/SubCarpetaService';

@Component({
  selector: 'app-sub-carpeta-usuario',
  templateUrl: './sub-carpeta-usuario.component.html',
  styleUrls: ['./sub-carpeta-usuario.component.css']
})
export class SubCarpetaUsuarioComponent implements OnInit {

  codigoCarpeta!:string;

  usuario!:Usuario;

  carpeta!:Carpeta;


constructor( private route: ActivatedRoute, private subCarpetaService: SubCarpetaService){


}

  ngOnInit(): void {

    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario= jsonUsuario ? JSON.parse(jsonUsuario) : null;    


  
    this.route.params.subscribe(params => {
      this.codigoCarpeta = params['id'];
      console.log(this.codigoCarpeta); // Aquí tienes el valor de userRole
    });


  


  this.subCarpetaService.getSubCarpeta(this.usuario._id,this.codigoCarpeta).subscribe({

    next: (clienteBD: Carpeta) => {

      this.carpeta=clienteBD;
      
    
      
    },
    error: (error: any) => {
    
    }
  });


  }


}



