import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Observable, catchError, map, of } from "rxjs";
import { Productos } from "src/entities/Productos";
import { ProductosBodega } from "src/entities/ProductosBodega";
import { ProductosSinPrecio } from "src/entities/ProductoSinPrecio";

@Injectable({
    providedIn: 'root'
})
export class InventarioService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

 
    
    
  
    public getProductosPendientes(codigoUsuario: number): Observable<Productos[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<Productos[]>(this.API_URL + "Inventario?codigoSucursal="+codigoUsuario);
    }

    

    public actualizarPrecioPasillo(ingreso: ProductosSinPrecio): Observable<ProductosBodega> {

        console.log('connectando con el BE: ' + ingreso);
        
        return this.httpClient.post<ProductosBodega>(this.API_URL + "Inventario", ingreso);
    }
    
 
}