export class SignUp {
    name: string = ""
    email: string = ""
    passw: string = ""
    confirmPassword: string = ""
    recuerdame: boolean = false

    constructor(name: string,
        email: string,
        passw: string,
        confirmPassword: string,
        recuerdame: boolean){
            this.name=name
            this.email=email
            this.passw=passw
            this.confirmPassword=confirmPassword
            this.recuerdame=recuerdame
        }
}