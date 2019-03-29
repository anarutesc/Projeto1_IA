
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
    
    public void addLink(Link link){
        topologia.get(link.getA().getId()).add(link);
        topologia.get(link.getB().getId()).add(link);
        nLinks+=2;
    }
    
    public void removerLink(Link link){
        topologia.get(link.getA().getId()).remove(link);
        topologia.get(link.getB().getId()).remove(link);
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
