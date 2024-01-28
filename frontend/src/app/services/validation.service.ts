import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ValidationRequest } from '../models/validationRequest.model';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class ValidationService {
    constructor(public httpClient: HttpClient) { }

    validarConBackend (validationRequest: ValidationRequest): Observable<Object> {
        const url: string = "http://localhost:8080/validar";
        return this.httpClient.post(url, validationRequest);

    }
}