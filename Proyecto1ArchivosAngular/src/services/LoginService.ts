import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Usuario} from 'src/entities/Usuario';
@Injectable({
    providedIn: 'root'
})
export class LoginService {

    readonly API_URL = "http://localhost:8080/proyecto2_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public logear(usuario: Usuario): Observable<Usuario> {

        console.log('connectando con el BE: ' + usuario);
        console.log('Tipo: ' + usuario.tipo);
        return this.httpClient.post<Usuario>(this.API_URL + "login", usuario);
    }

    public getbases(): Observable<string[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<string[]>(this.API_URL + "login");
    }
 
}