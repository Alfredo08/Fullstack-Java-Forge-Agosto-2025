package clases;

import interfaces.FiguraGeometrica;

public class Circulo implements FiguraGeometrica {
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public double getRadio(){
        return this.radio;
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public double perimetro(){
        return 2 * Math.PI * this.radio;
    }

        @Override
    public void imprimeInformacion(){
        System.out.println("Figura geométrica: Cuadrado");
        System.out.println("Longitud: " + this.radio);
        System.out.println("Area: " + this.area());
        System.out.println("Perímetro: " + this.perimetro());
    }
}
