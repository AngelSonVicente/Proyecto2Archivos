import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Observable, catchError, map, of } from "rxjs";
import { Productos } from "src/entities/Productos";
import { Cliente } from "src/entities/Cliente";

@Injectable({
    providedIn: 'root'
})
export class ClienteService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

 
    
    
  
    public getCLiente(nit: number): Observable<Cliente> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<Cliente>(this.API_URL + "Cliente?nitCliente="+nit);
    }


    public crearCliente(cliente: Cliente): Observable<Cliente> {

        console.log('connectando con el BE: ' + cliente);
        
        return this.httpClient.post<Cliente>(this.API_URL + "Cliente", cliente);
    }
    
 
}