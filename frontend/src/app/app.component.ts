import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //template: '<p>Holi</p>',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  title = 'frontend';
  constructor(
    public router: Router
  ){

  }
  ngOnInit(): void {
     /* const links: Array<String> =['admin','login_signup','consulta']
      var contador = 0
      setInterval(()=>{
        this.router.navigate([links[contador%3]])
        contador++
      },3000)*/
      
  }
}

