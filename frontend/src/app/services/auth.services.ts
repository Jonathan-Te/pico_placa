import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login.model';
import { SignUp } from '../models/signup.model';

@Injectable({
    providedIn: 'root'
})

export class AuthenticationService{

    isLogged: boolean=false;

    baseUrl: string ="http://localhost:8080"
    constructor(public httpClient: HttpClient) { }

    login(login: Login): Observable<Object>{
        const url: string = this.baseUrl+"/login"
        this.isLogged=true;
        return this.httpClient.post(url,login)
    }

    signup(signup: SignUp): Observable<Object>{
        const url: string = this.baseUrl+"/signup"
        return this.httpClient.post(url,signup)
    }

    logout(): Observable<Object>{
        const url: string = this.baseUrl+"/logout"
        this.isLogged=false;
        return this.httpClient.get(url)
        
    }
}
