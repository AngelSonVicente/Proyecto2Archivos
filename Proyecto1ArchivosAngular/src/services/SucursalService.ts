import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Observable, catchError, map, of } from "rxjs";
import { Productos } from "src/entities/Productos";
import { Sucursal } from "src/entities/Sucursal";

@Injectable({
    providedIn: 'root'
})
export class SucursalService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

 
    
    
  
    public getSucursales(): Observable<Sucursal[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<Sucursal[]>(this.API_URL + "Sucursal");
    }

    
 
}