import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Observable, catchError, map, of } from "rxjs";
import { Productos } from "src/entities/Productos";
import { Bodega } from "src/entities/Bodega";

@Injectable({
    providedIn: 'root'
})
export class BodegaService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

 
    
    
  
    public getBodegas(): Observable<Bodega[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<Bodega[]>(this.API_URL + "Bodega");
    }

    
 
}