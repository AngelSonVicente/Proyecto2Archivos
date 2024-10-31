import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Usuario} from 'src/entities/Usuario';
import { User } from "src/entities/User";
import { Carpeta } from "src/entities/Carpeta";
import { CrearCarpeta } from "src/entities/CrearCarpeta";
import { CrearArchivo } from "src/entities/CrearArchivo";
import { Archivo } from "src/entities/Archivo";
import { ArchivoActualizar } from "src/entities/ArchivoActualizar";
@Injectable({
    providedIn: 'root'
})
export class ArchivosService {

    readonly API_URL = "http://localhost:8080/proyecto2_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public crearArchivo(arch: CrearArchivo): Observable<Archivo> {

      
        return this.httpClient.post<Archivo>(this.API_URL + "Archivos", arch );
    }


    public actualizarArchivo(arch: ArchivoActualizar): Observable<Archivo> {

      
        return this.httpClient.put<Archivo>(this.API_URL + "Archivos", arch );
    }




     public getArchivoRaiz(codigoUsuario: string, codigoArchivo:string): Observable<Archivo> {
        
      
        return this.httpClient.get<Archivo>(this.API_URL + "Archivo?codigoUsuario="+ codigoUsuario+"&codigoArchivo="+codigoArchivo);
    }



 
}