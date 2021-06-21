import {Person} from "./Person";

export class Student extends Person implements IPerson {
    private _point:number;


    constructor(id: number, name: string, point: number) {
        super(id, name);
        this._point = point;
    }


    get point(): number {
        return this._point;
    }

    set point(value: number) {
        this._point = value;
    }

    showInfo(): string {
        return "ID: " + this.id + "Name: " +this.name + " Point: "+ this.point;
    }

}