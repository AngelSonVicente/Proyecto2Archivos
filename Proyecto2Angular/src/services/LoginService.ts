import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    readonly API_URL = "http://localhost:8080/proyecto2_api/v1/";

    constructor(private httpClient: HttpClient) {}

    public getDataBases(): Observable<string[]> {
        console.log('connectando con el BE: ');
        return this.httpClient.get<string[]>(this.API_URL + "login?codigoBodega=1");
    }

 
}