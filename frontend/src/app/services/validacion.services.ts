import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login.model';
import { SignUp } from '../models/signup.model';
import { Validacion } from '../models/validacion';

@Injectable({
    providedIn: 'root'
})

export class ValidationService{
    baseUrl: string ="http://localhost:8080"
    constructor(public httpClient: HttpClient) { }

    validation(validacion: Validacion): Observable<Object>{
        const url: string = this.baseUrl+"/validar"
        return this.httpClient.post(url,validacion)
    }

    getHistory(): Observable<Object>{
        const url: string = this.baseUrl+"/history"
        return this.httpClient.get(url)
    }
}
