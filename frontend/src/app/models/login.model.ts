export class Login {
    email:string = ""
    passw:string=""
    recordarme:boolean=true

    constructor(email: string,passw: string, recordame:boolean){
        this.email=email
        this.passw=passw
        this.recordarme=recordame
    }
}