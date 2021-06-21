export class Student {
  private _name:string;
  private _gender:number;
  private _point:number;


  constructor(name: string, gender: number, point: number) {
    this._name = name;
    this._gender = gender;
    this._point = point;
  }


  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get gender(): number {
    return this._gender;
  }

  set gender(value: number) {
    this._gender = value;
  }

  get point(): number {
    return this._point;
  }

  set point(value: number) {
    this._point = value;
  }
}
