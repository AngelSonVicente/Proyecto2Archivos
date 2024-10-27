import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/services/LoginService';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  bases:string[]=[];

  constructor(private loginService: LoginService){

  }

  ngOnInit(): void {
 
    this.loginService.getbases().subscribe({

      next: (clienteBD: string[]) => {

        this.bases=clienteBD;
        
      
        
      },
      error: (error: any) => {
      
      }
    });
 
 
  }



}
