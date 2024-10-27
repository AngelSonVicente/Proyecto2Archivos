import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Usuario} from 'src/entities/Usuario';
import { Venta } from "src/entities/Venta";
@Injectable({
    providedIn: 'root'
})
export class VentaSerivice {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public realizarVenta(venta: Venta): Observable<Venta> {

        console.log('connectando con el BE: ' + venta);
        
        return this.httpClient.post<Venta>(this.API_URL + "Venta", venta);
    }

 
}