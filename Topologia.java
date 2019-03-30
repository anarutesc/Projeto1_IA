
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class Topologia {
    public int nDispositivos;
    public int nLinks;
    private ArrayList<LinkedList<Link>> topologia;
    
    public Topologia(int n) {
        this.nDispositivos = n;
        nLinks = 0;

        topologia = new ArrayList<LinkedList<Link>>();
        for (int i = 0; i < n; i++) {
            topologia.add(new LinkedList<Link>());
        }
    }
    
    public void addLink(Link link){
        topologia.get(link.getA().getId()).add(link);
        Link link_novo = new Link(link.getB(), link.getA(), link.getDistancia(), link.getCabo());
        topologia.get(link.getB().getId()).add(link_novo);
        nLinks+=2;
    }
    
    public void removerLink(Link link){
        topologia.get(link.getA().getId()).remove(link);
        Link link_novo = new Link(link.getB(), link.getA(), link.getDistancia(), link.getCabo());
        topologia.get(link.getB().getId()).remove(link_novo);
        nLinks-=2;
    }
    
    public LinkedList<Link> getNeighbours(int id) {
        return topologia.get(id);
    }
    
    public boolean existLinks() {
        if (nLinks == 0) {
            return false;
        } else {
            return true;
        }
    }
    
     @Override
    public String toString() {
        String str = "";
        for (LinkedList<Link> links : topologia) {
            for (Link l : links) {
                str += l.toString();
            }
            str += "\n";
        }
        return str;
    }
}
