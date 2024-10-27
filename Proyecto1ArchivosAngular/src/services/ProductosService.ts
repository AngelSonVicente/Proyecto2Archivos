import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Observable, catchError, map, of } from "rxjs";
import { Productos } from "src/entities/Productos";
import { Cliente } from "src/entities/Cliente";
import { Producto } from "src/entities/Producto";

@Injectable({
    providedIn: 'root'
})
export class ProductoService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

 
    
    
  
    public getProductos(): Observable<Productos[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<Productos[]>(this.API_URL + "Productos");
    }

    public crearProducto(producto: Productos): Observable<Productos> {

        console.log('connectando con el BE: ' + producto);
        
        return this.httpClient.post<Productos>(this.API_URL + "Productos", producto);
    }


    
    
 
}