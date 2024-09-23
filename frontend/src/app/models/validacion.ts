export class Validacion {
    queryDate:Date = new Date ()
    queriedDate:Date= new Date()
    plate:string=""

    constructor(queryDate:Date,queriedDate:Date,plate:string=""){
        this.queryDate=queryDate
        this.queriedDate=queriedDate
        this.plate=plate
    }
}