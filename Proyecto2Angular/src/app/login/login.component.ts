import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/LoginService';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  bases:string[] = [];

  error:boolean=false;


  constructor(private loginService: LoginService){}
  





  mostrarbases(){

    this.loginService.getDataBases().subscribe({
      next: (Data: string[]) => {
        console.log("creado " + Data);
       
       
       this.bases=Data; 
        this.error=false;
    
      },
      error: (error: any) => {
        console.log("error");
        this.error=true;
       
        
      }
    });

  }



}
