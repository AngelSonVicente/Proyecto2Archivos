import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Usuario} from 'src/entities/Usuario';
import { User } from "src/entities/User";
import { Carpeta } from "src/entities/Carpeta";
import { CrearCarpeta } from "src/entities/CrearCarpeta";
@Injectable({
    providedIn: 'root'
})
export class SubCarpetaService {

    readonly API_URL = "http://localhost:8080/proyecto2_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public crearSubCarpeta(carpeta: CrearCarpeta): Observable<CrearCarpeta> {

      
        return this.httpClient.post<CrearCarpeta>(this.API_URL + "SubCarpeta", carpeta);
    }


     public getSubCarpeta(codigoUsuario: string,codigoCarptea:string): Observable<Carpeta> {
        
      
        return this.httpClient.get<Carpeta>(this.API_URL + "SubCarpeta?codigoUsuario="+ codigoUsuario+"&codigoCarpeta="+codigoCarptea);
    }



 
}