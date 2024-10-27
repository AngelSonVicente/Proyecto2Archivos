import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Usuario } from 'src/entities/Usuario';
import { Venta } from "src/entities/Venta";
import { ProductosBodega } from "src/entities/ProductosBodega";
import { Productos } from "src/entities/Productos";
import { VentasGrandes } from "src/entities/VentasGrandes";
import { SucursalesIngresos } from "src/entities/SucursalesIngresos";
import { ProductosVendidos } from "src/entities/ProductosVendidos";
import { ClientesGastados } from "src/entities/ClientesGastados";
@Injectable({
    providedIn: 'root'
})
export class ReportesService {

    readonly API_URL = "http://localhost:8080/proyecto1_api/v1/";

    constructor(private httpClient: HttpClient) { }





    public getReporte2(fecha1: string, fecha2: string): Observable<VentasGrandes[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<VentasGrandes[]>(this.API_URL + "Reportes?reporte=2&fecha1=" + fecha1 + "&fecha2=" + fecha2);
    }

    public getReporte3(): Observable<SucursalesIngresos[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<SucursalesIngresos[]>(this.API_URL + "Reportes?reporte=3");
    }
    public getReporte4(): Observable<ProductosVendidos[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<ProductosVendidos[]>(this.API_URL + "Reportes?reporte=4");
    }
    public getReporte5(): Observable<ClientesGastados[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<ClientesGastados[]>(this.API_URL + "Reportes?reporte=5");
    }

}