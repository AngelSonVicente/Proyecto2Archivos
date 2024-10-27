import { Productos } from "./Productos";

export class Venta {
    codigo!: number;
    nitCliente!: number;
    codigoCajero!: number;
    fecha!: string;
    total!: number;
    puntosUsados!:number;
    productos!:Productos[];
    codigoSucursal!:number;
}