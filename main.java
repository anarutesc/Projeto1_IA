/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class main {

    public static void main(String[] args) {
        Dispositivo pc1 = new Dispositivo(0, "PC1", 20);
        Dispositivo pc2 = new Dispositivo(1, "PC2", 30);
        Dispositivo pc3 = new Dispositivo(2, "PC3", 25);
        Dispositivo pc4 = new Dispositivo(3, "PC4", 35);
        Dispositivo pc5 = new Dispositivo(4, "PC5", 15);
        Dispositivo pc6 = new Dispositivo(5, "PC6", 10);

        Dispositivo roteador1 = new Dispositivo(7, "ROUTER1", 15);
        Dispositivo roteador2 = new Dispositivo(8, "ROUTER2", 38);
        Dispositivo roteador3 = new Dispositivo(9, "ROUTER3", 12);

        Dispositivo servidor1 = new Dispositivo(10, "SERVER1", 32);
        Dispositivo servidor2 = new Dispositivo(11, "SERVER2", 43);

        // ---------------------- Links do PC1: -------------------------
        
        //PC1 e Roteadores
        Link link_r11 = new Link(pc1, roteador1, 10, 'O');
        Link link_r12 = new Link(pc1, roteador2, 17, 'T');
        Link link_r13 = new Link(pc1, roteador3, 22, 'C');

        //PC1 e Servidores
        Link link_s11 = new Link(pc1, servidor1, 39, 'T');
        Link link_s12 = new Link(pc1, servidor2, 49, 'O');

        //PC1 e demais PCs
        Link link_pc12 = new Link(pc1, pc2, 100, 'O');
        Link link_pc13 = new Link(pc1, pc3, 101, 'T');
        Link link_pc14 = new Link(pc1, pc4, 103, 'T');
        Link link_pc15 = new Link(pc1, pc5, 110, 'C');
        Link link_pc16 = new Link(pc1, pc6, 120, 'T');

        // ---------------------- Links do PC2: -------------------------
        
        //PC2 e Roteadores
        Link link_r21 = new Link(pc2, roteador1, 14, 'T');
        Link link_r22 = new Link(pc2, roteador2, 7, 'T');
        Link link_r23 = new Link(pc2, roteador3, 32, 'O');

        //PC2 e Servidores
        Link link_s21 = new Link(pc2, servidor1, 39, 'C');
        Link link_s22 = new Link(pc2, servidor2, 49, 'O');

        //PC2 e demais PCs
        Link link_pc21= new Link(pc2, pc1, 100, 'O');
        Link link_pc23 = new Link(pc2, pc3, 10, 'T');
        Link link_pc24 = new Link(pc2, pc4, 103, 'C');
        Link link_pc25 = new Link(pc2, pc5, 110, 'O');
        Link link_pc26 = new Link(pc2, pc6, 120, 'C');
        
        // ---------------------- Links do PC3: -------------------------
        
        //PC3 e Roteadores
        Link link_r31 = new Link(pc3, roteador1, 24, 'C');
        Link link_r32 = new Link(pc3, roteador2, 34, 'O');
        Link link_r33 = new Link(pc3, roteador3, 43, 'C');
        
        //PC3 e Servidores
        Link link_s31 = new Link(pc3, servidor1, 32, 'C');
        Link link_s32 = new Link(pc3, servidor2, 21, 'T');
        
        //PC3 e demais PCs
        Link link_pc31= new Link(pc3, pc1, 100, 'O');
        Link link_pc33 = new Link(pc3, pc2, 10, 'T');
        Link link_pc34 = new Link(pc3, pc4, 103, 'C');
        Link link_pc35 = new Link(pc3, pc5, 110, 'O');
        Link link_pc36 = new Link(pc3, pc6, 120, 'C');
        
        // ---------------------- Links do PC4: -------------------------
        
        //PC4 e Roteadores
        Link link_r41 = new Link(pc4, roteador1, 23, 'C');
        Link link_r42 = new Link(pc4, roteador2, 32, 'T');
        Link link_r43 = new Link(pc4, roteador3, 43, 'C');
        
        //PC4 e Servidores
        Link link_s41 = new Link(pc4, servidor1, 23, 'C');
        Link link_s42 = new Link(pc4, servidor2, 25, 'T');
        
        //PC4 e demais PCs
        Link link_pc41= new Link(pc4, pc1, 145, 'O');
        Link link_pc43 = new Link(pc4, pc2, 102, 'T');
        Link link_pc44 = new Link(pc4, pc3, 43, 'T');
        Link link_pc45 = new Link(pc4, pc5, 123, 'T');
        Link link_pc46 = new Link(pc4, pc6, 121, 'C');
        
        // ---------------------- Links do PC5: -------------------------
        
        //PC5 e Roteadores
        Link link_r51 = new Link(pc5, roteador1, 12, 'T');
        Link link_r52 = new Link(pc5, roteador2, 12, 'T');
        Link link_r53 = new Link(pc5, roteador3, 23, 'O');
        
        //PC5 e Servidores
        Link link_s51 = new Link(pc5, servidor1, 33, 'C');
        Link link_s52 = new Link(pc5, servidor2, 35, 'T');
        
        //PC5 e demais PCs
        Link link_pc51= new Link(pc5, pc1, 135, 'O');
        Link link_pc53 = new Link(pc5, pc2, 82, 'T');
        Link link_pc54 = new Link(pc5, pc3, 93, 'T');
        Link link_pc55 = new Link(pc5, pc4, 103, 'O');
        Link link_pc56 = new Link(pc5, pc6, 111, 'C');
        
        // ---------------------- Links do PC6: -------------------------
        
        //PC6 e Roteadores
        Link link_r61 = new Link(pc6, roteador1, 23, 'C');
        Link link_r62 = new Link(pc6, roteador2, 41, 'C');
        Link link_r63 = new Link(pc6, roteador3, 22, 'O');
        
        //PC6 e Servidores
        Link link_s61 = new Link(pc6, servidor1, 13, 'C');
        Link link_s62 = new Link(pc6, servidor2, 45, 'T');
        
        //PC6 e demais PCs
        Link link_pc61= new Link(pc6, pc1, 105, 'O');
        Link link_pc63 = new Link(pc6, pc2, 92, 'T');
        Link link_pc64 = new Link(pc6, pc3, 63, 'T');
        Link link_pc65 = new Link(pc6, pc4, 53, 'O');
        Link link_pc66 = new Link(pc6, pc5, 100, 'C');
        
        //---------------- Criação de Topologia ---------------------------
        
        Topologia t = new Topologia();
        
        t.addLink(link_s62);
        
        
    }
    
}
