import { Archivo } from "./Archivo";

export class Carpeta{

    _id!:string;
    nombre!:string;
    archivos!:Archivo[];
    subcarpetas!:Carpeta[];


    
}