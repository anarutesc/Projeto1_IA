/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @authors aleika, ana_r, danielly
 */
public class Link {

    private Dispositivo a, b;
    private int distancia;
    public int custo = 0;
    private char cabo;

    public Link(Dispositivo a, Dispositivo b, int distancia, char cabo) {
        this.a = a;
        this.b = b;
        this.distancia = distancia;
        this.cabo = cabo;
        this.custo();
    }

    public Dispositivo getA() {
        return a;
    }

    public void setA(Dispositivo a) {
        this.a = a;
    }

    public Dispositivo getB() {
        return b;
    }

    public void setB(Dispositivo b) {
        this.b = b;
    }
    
    public void setDistancia(int distancia){
        this.distancia = distancia;
    }
    
    public int getDistancia(){
        return distancia;
    }
    
    public void setCabo(char cabo){
        this.cabo = cabo;
    }
    
    public char getCabo(){
        return cabo;
    }

    public void custo() {
        switch (cabo) {
            case 'O':
                custo = distancia + 1 + a.getPotencia();
            case 'C':
                custo = distancia + 10 + a.getPotencia();
            case 'T':
                custo = distancia + 20 + a.getPotencia();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Link other = (Link) obj;
        if (this.a == other.getA() && this.b == other.getB()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + this.a + "," + this.b + "|" + this.custo + ") ";
    }

}
