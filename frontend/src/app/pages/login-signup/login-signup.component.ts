import { Component } from '@angular/core';
import { Login } from '../../models/login.model';
import { SignUp } from '../../models/signup.model';
import { trigger, style, animate, transition } from '@angular/animations';
import { AuthenticationService } from '../../services/auth.services';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-signup',
  templateUrl: './login-signup.component.html',
  styleUrl: './login-signup.component.scss',
})
export class LoginSignupComponent {
  login: Login 
  signup: SignUp
  constructor(private authenticationService:AuthenticationService, private router:Router){
    
    this.login=new Login("","",false)
    this.signup=new SignUp("","","","",false)

  }
  showLogin:boolean=true
  cambiarLoginsignup(){
    this.showLogin=!this.showLogin
  }

  execLogIn(){
    console.log(this.login.passw)
    console.log(this.login.email)
    this.authenticationService.login(this.login).subscribe((response)=> {
        console.log("Inicio sesion con exito "+response)
        this.router.navigate(["/principal"])
    }, (error)=> {
      console.log("Error: "+error)
    })


  }

  execSignUp(){
    this.authenticationService.signup(this.signup).subscribe((response)=> {
        console.log("Se registro con exito "+response)
    }, (error)=> {
      console.log("Error: "+error)
    })


  }

  validatedNoLogin(){
    this.router.navigate(["/principal"])
  }

}

