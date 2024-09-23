import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/auth.services';
import { Router } from '@angular/router';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrl: './principal.component.scss'
})
export class PrincipalComponent {

  constructor(private authenticationService: AuthenticationService, private router: Router) {

  }
  logOut() {
    this.authenticationService.logout().subscribe((response) => {
      console.log("Cerró sesion con exito " + response)
      this.router.navigate(["/"])
    }, (error) => {
      console.log("Error: " + error)
    })
  }

  
  public get authenticationServiceValue() : AuthenticationService {
    return this.authenticationService
  }
  
}

