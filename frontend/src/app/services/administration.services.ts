import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restriction } from '../models/restriction.model';
import { Exception } from '../models/exception.model';

@Injectable({
    providedIn: 'root'
})

export class AdministrationService{
    baseUrl: string ="http://localhost:8080"
    constructor(public httpClient: HttpClient) { }

    addRestriction(restriction: Restriction): Observable<Object>{
        const url: string = this.baseUrl+"/restriction"
        return this.httpClient.post(url,restriction)
    }

    getRestrictions(): Observable<Object>{
        const url: string = this.baseUrl+"/restriction"
        return this.httpClient.get(url)
    }
    addException(exception: Exception): Observable<Object>{
        const url: string = this.baseUrl+"/exception"
        return this.httpClient.post(url,exception)
    }

    getExceptions(): Observable<Object>{
        const url: string = this.baseUrl+"/exception"
        return this.httpClient.get(url)
    }


}
