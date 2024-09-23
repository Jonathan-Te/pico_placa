export class Exception{
    id:number;
    description:string;
    startTime:number;
    endTime:number;
    applicationDate:Date|null;
    applicationDays:string|null;
    lastDigitPlates:String;

    constructor(id:number,
        description:string,
        startTime:number,
        endTime:number,
        applicationDate:Date|null,
        applicationDays:string|null,
        lastDigitPlates:String){
            this.id=id;
            this.description=description;
            this.startTime=startTime;
            this.endTime=endTime;
            this.applicationDate=applicationDate;
            this.applicationDays=applicationDays;
            this.lastDigitPlates=lastDigitPlates;
        }
}