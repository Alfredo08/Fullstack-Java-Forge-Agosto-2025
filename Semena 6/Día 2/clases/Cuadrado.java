package clases;

import interfaces.FiguraGeometrica;

public class Cuadrado implements FiguraGeometrica{
    private double longitud;

    public Cuadrado(double longitud){
        this.longitud = longitud;
    }

    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

    public double getLongitud(){
        return this.longitud;
    }

    @Override
    public double area(){
        return this.longitud * this.longitud;
    }

    @Override
    public double perimetro(){
        return this.longitud * 4;
    }

    @Override
    public void imprimeInformacion(){
        System.out.println("Figura geométrica: Cuadrado");
        System.out.println("Longitud: " + this.longitud);
        System.out.println("Area: " + this.area());
        System.out.println("Perímetro: " + this.perimetro());
    }
}
