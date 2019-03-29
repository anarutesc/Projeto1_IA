/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ana_r
 */
public class Link {

    private Dispositivo a, b;
    private int custo;
    
    public Link(Dispositivo a, Dispositivo b, int custo) {
        this.a = a;
        this.b = b;
        this.custo = custo;
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

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
 
    @Override
	public boolean equals(Object obj) {
		Link other = (Link)obj;
		if(this.a == other.getA() && this.b == other.getB()){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "("+this.a+","+this.b+"|"+this.custo+") ";
	}

}
