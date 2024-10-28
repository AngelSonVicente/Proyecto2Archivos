import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-sub-carpeta-usuario',
  templateUrl: './sub-carpeta-usuario.component.html',
  styleUrls: ['./sub-carpeta-usuario.component.css']
})
export class SubCarpetaUsuarioComponent implements OnInit {

  codigoCarpeta!:string;


constructor( private route: ActivatedRoute){


}

  ngOnInit(): void {
  
    this.route.params.subscribe(params => {
      this.codigoCarpeta = params['id'];
      console.log(this.codigoCarpeta); // Aquí tienes el valor de userRole
    });
  }

  }






