
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @authors aleika, ana_r, danielly
 */
public class main {

    public static void main(String[] args) {
        Dispositivo pc1 = new Dispositivo(0, "PC1", 20);
        Dispositivo pc2 = new Dispositivo(1, "PC2", 30);
        Dispositivo pc3 = new Dispositivo(2, "PC3", 25);
        
        Dispositivo roteador1 = new Dispositivo(3, "ROUTER1", 38);
        Dispositivo roteador2 = new Dispositivo(4, "ROUTER2", 32);

        Dispositivo servidor1 = new Dispositivo(5, "SERVER1", 22);

        // ---------------------- Links do PC1: -------------------------
        //PC1 e Roteadores
        Link link_r11 = new Link(pc1, roteador1, 5, 'T');
        Link link_r12 = new Link(pc1, roteador2, 25, 'T');
        

        //PC1 e Servidores
        Link link_s11 = new Link(pc1, servidor1, 39, 'C');
        

        //PC1 e demais PCs
        Link link_pc12 = new Link(pc1, pc2, 50, 'T');
        Link link_pc13 = new Link(pc1, pc3, 99, 'T');
        

        // ---------------------- Links do PC2: -------------------------
        //PC2 e Roteadores
        Link link_r21 = new Link(pc2, roteador1, 14, 'T');
        Link link_r22 = new Link(pc2, roteador2, 7, 'T');
        
        //PC2 e Servidores
        Link link_s21 = new Link(pc2, servidor1, 45, 'C');
        

        //PC2 e demais PCs
        Link link_pc23 = new Link(pc2, pc3, 49 , 'T');
        
        // ---------------------- Links do PC3: -------------------------
        //PC3 e Roteadores
        Link link_r31 = new Link(pc3, roteador1, 2, 'T');
        Link link_r32 = new Link(pc3, roteador2, 21, 'T');
        
        //PC3 e Servidores
        Link link_s31 = new Link(pc3, servidor1, 32, 'C');
               
               
        // ---------------------- Links do Roteador 1: -------------------------
        Link link_rt11 = new Link(roteador1, roteador2, 4, 'O');
        Link link_rt12 = new Link(roteador1, servidor1, 34, 'O');
        
       
        // ---------------------- Links do Roteador 2: -------------------------
        Link link_rt21 = new Link(roteador2, servidor1, 17, 'O');           
                        
        //---------------- Criação de Topologia ---------------------------
        Topologia t = new Topologia(6);

        t.addLink(link_r11);
        t.addLink(link_r12);
        
        t.addLink(link_r21);
        t.addLink(link_r22);
        
        t.addLink(link_r31);
        t.addLink(link_r32);
        
        t.addLink(link_rt11);
        t.addLink(link_rt12);
                
        t.addLink(link_rt21);
                
        t.addLink(link_s11);
        
        t.addLink(link_s21);
        
        t.addLink(link_s31);
                
        t.addLink(link_pc12);
        t.addLink(link_pc13);

        t.addLink(link_pc23);
        
        Roteamento r = new Roteamento(t);
        r.SimulatedAnnealing(pc1, pc2);
        System.out.println("Rota: ");
        System.out.print(r.rota_final.getFirst().getNome());
        for (int i = 1; i < r.rota_final.size(); i++) {
            System.out.print(" -> " + r.rota_final.get(i).getNome());
        }
        System.out.println("");
                
        System.out.println("Custo:" + r.custo_final);
    }

}
