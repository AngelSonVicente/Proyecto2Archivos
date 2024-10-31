import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Archivo } from 'src/entities/Archivo';
import { ArchivoActualizar } from 'src/entities/ArchivoActualizar';
import { CrearCarpeta } from 'src/entities/CrearCarpeta';
import { Usuario } from 'src/entities/Usuario';
import { ArchivosService } from 'src/services/ArchivosService';
import { SubCarpetaService } from 'src/services/SubCarpetaService';

@Component({
  selector: 'app-visor-archivo',
  templateUrl: './visor-archivo.component.html',
  styleUrls: ['./visor-archivo.component.css']
})
export class VisorArchivoComponent implements OnInit{
 
  codigoCarpeta!:string;
  codigoArchivo!:string;
 
  archivo!:Archivo;
  


  FormularioOferta!: FormGroup;
  saved : boolean=false;


  error: boolean = false;
  
  codigoCreado!:string;

  archivoActualizar!:ArchivoActualizar;
  usuario!: Usuario;


  constructor( private formBuilder: FormBuilder, 
    private route: ActivatedRoute, private router: Router, private archivoService:ArchivosService) { }


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.codigoCarpeta = params['codigoCarpeta'];
      this.codigoArchivo = params['codigoArchivo'];


      console.log(this.codigoCarpeta); // Aquí tienes el valor de userRole
    });


    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario = jsonUsuario ? JSON.parse(jsonUsuario) : null;

       

    

    this.archivoService.getArchivoRaiz(this.usuario.codigo, this.codigoArchivo,this.codigoCarpeta).subscribe({
      next: (oferta: Archivo) => {

        this.archivo=oferta;
        
        this.FormularioOferta = this.formBuilder.group({
        
          contenido: [oferta.contenido],
        
          

        });
      }
    });




    this.FormularioOferta = this.formBuilder.group({
      contenido: [null],
  
      

    });



 

  }

  submit(): void {
    
      this.archivoActualizar = this.FormularioOferta.value as ArchivoActualizar;
      
      this.archivoActualizar.codigoUsuario=this.usuario.codigo;
      this.archivoActualizar.carpetaPadre=this.codigoCarpeta;
      this.archivoActualizar._id=this.codigoArchivo;

    
      this.archivoService.actualizarArchivo(this.archivoActualizar).subscribe({
        next: (created: Archivo) => {
          console.log("creado " + created);
        
          this.saved = true;
          this.error=false;
         // this.limpiar()
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




