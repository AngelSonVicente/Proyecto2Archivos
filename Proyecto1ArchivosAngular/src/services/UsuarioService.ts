import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Usuario} from 'src/entities/Usuario';
import { User } from "src/entities/User";
@Injectable({
    providedIn: 'root'
})
export class UsuarioService {

    readonly API_URL = "http://localhost:8080/proyecto2_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public crearUsuario(usuario: Usuario): Observable<Usuario> {

        console.log('connectando con el BE: ' + usuario);
        console.log('Tipo: ' + usuario.tipo);
        return this.httpClient.post<Usuario>(this.API_URL + "Usuario", usuario);
    }


     public getUsuario(usuario: string): Observable<User> {
        console.log('connectando con el BE: ' + usuario);
        console.log('Tipo: ' + usuario);
        return this.httpClient.get<User>(this.API_URL + "Usuario?user="+ usuario);
    }



 
}