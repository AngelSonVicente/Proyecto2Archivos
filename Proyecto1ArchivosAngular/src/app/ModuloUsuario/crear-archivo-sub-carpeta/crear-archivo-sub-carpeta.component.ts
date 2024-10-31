import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Archivo } from 'src/entities/Archivo';
import { CrearArchivo } from 'src/entities/CrearArchivo';
import { Usuario } from 'src/entities/Usuario';
import { ArchivosService } from 'src/services/ArchivosService';

@Component({
  selector: 'app-crear-archivo-sub-carpeta',
  templateUrl: './crear-archivo-sub-carpeta.component.html',
  styleUrls: ['./crear-archivo-sub-carpeta.component.css']
})
export class CrearArchivoSubCarpetaComponent implements OnInit{
  @Input() codigoCarpeta!: string;








  FormularioOferta!: FormGroup;
  saved : boolean=false;

  ArchivoCreado!:Archivo;

  error: boolean = false;
  
  codigoCreado!:string;

  archivoCreacion!:CrearArchivo;
  usuario!: Usuario;


  constructor( private formBuilder: FormBuilder, 
    private route: ActivatedRoute, private router: Router, private archivoService:ArchivosService) { }
  ngOnInit(): void {
    let jsonUsuario = localStorage.getItem('usuario');
    this.usuario = jsonUsuario ? JSON.parse(jsonUsuario) : null;

       

    


    this.FormularioOferta = this.formBuilder.group({
      nombre: [null, [Validators.required]],
      tipo: [null, [Validators.required]],
  
      

    });



 

  }

  submit(): void {
    
      this.archivoCreacion = this.FormularioOferta.value as CrearArchivo;
      
      this.archivoCreacion.codigoUsuario=this.usuario.codigo;
      this.archivoCreacion.path="/raiz/";
      this.archivoCreacion.codigoCarpeta=this.codigoCarpeta;

    
      this.archivoService.crearArchivo(this.archivoCreacion).subscribe({
        next: (created: Archivo) => {
          console.log("creado " + created);
        








          this.ArchivoCreado=created;
          
          this.router.navigate(['Proyecto2/Usuario/Archivo', this.codigoCarpeta, this.ArchivoCreado._id]);
  
          
          this.saved = true;
          this.error=false;
          this.limpiar()


//          window.location.reload();

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
