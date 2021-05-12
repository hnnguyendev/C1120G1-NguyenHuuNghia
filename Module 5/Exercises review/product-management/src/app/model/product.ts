export class Product {

    private _name: string;
    private _price: number;
    private _manufactureDate: Date;
    private _quantity: number;
    private _origin: string;

    constructor(name: string, price: number, manufactureDate: Date, quantity: number, origin: string) {
        this._name = name;
        this._price = price;
        this._manufactureDate = manufactureDate;
        this._quantity = quantity;
        this._origin = origin;
    }

    public get name(): string {
        return this._name;
    }

    public set name(value: string) {
        this._name = value;
    }

    public get price(): number {
        return this._price;
    }

    public set price(value: number) {
        this._price = value;
    }

    public get manufactureDate(): Date {
        return this._manufactureDate;
    }

    public set manufactureDate(value: Date) {
        this._manufactureDate = value;
    }

    public get quantity(): number {
        return this._quantity;
    }

    public set quantity(value: number) {
        this._quantity = value;
    }

    public get origin(): string {
        return this._origin;
    }

    public set origin(value: string) {
        this._origin = value;
    }

}
