export class Student {
  private _id:number;
  private _name:string;
  private _point:number;


  constructor(id: number, name: string, point: number) {
    this._id = id;
    this._name = name;
    this._point = point;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get point(): number {
    return this._point;
  }

  set point(value: number) {
    this._point = value;
  }
}
