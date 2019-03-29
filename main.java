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
        Link link_pc31= new Link(pc3, pc1, 101, 'T');
        Link link_pc32 = new Link(pc3, pc2, 10, 'T');
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
        Link link_pc41= new Link(pc4, pc1, 103, 'T');
        Link link_pc42 = new Link(pc4, pc2, 103, 'C');
        Link link_pc43 = new Link(pc4, pc3, 103, 'C');
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
        Link link_pc51= new Link(pc5, pc1, 110, 'C');
        Link link_pc52 = new Link(pc5, pc2, 110, 'O');
        Link link_pc53 = new Link(pc5, pc3, 110, 'O');
        Link link_pc54 = new Link(pc5, pc4, 123, 'T');
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
        Link link_pc61 = new Link(pc6, pc1, 120, 'T');
        Link link_pc62 = new Link(pc6, pc2, 120, 'C');
        Link link_pc63 = new Link(pc6, pc3, 120, 'C');
        Link link_pc64 = new Link(pc6, pc4, 121, 'C');
        Link link_pc65 = new Link(pc6, pc5, 111, 'C');
        
	// ---------------------- Links do Roteador 1: -------------------------
     
	Link link_rt11 = new Link(roteador1, pc1 , 10, 'O');
	Link link_rt12 = new Link(roteador1, pc2 , 14, 'T');
	Link link_rt13 = new Link(roteador1, pc3, 24, 'C');
	Link link_rt14 = new Link(roteador1, pc3 , 23, 'C');
	Link link_rt15 = new Link(roteador1, pc5, 12, 'T');
	Link link_rt16 = new Link(roteador1, pc6, 23, 'C');


	// ---------------------- Links do Roteador 2: -------------------------
	     
	Link link_rt21 = new Link(roteador2, pc1 , 17, 'T');
	Link link_rt22 = new Link(roteador2, pc2, 7, 'T');
	Link link_rt23 = new Link(roteador2, pc3, 34, 'O');
	Link link_rt24 = new Link(roteador2, pc4, 32, 'T');
	Link link_rt25 = new Link(roteador2, pc5 , 12, 'T');
	Link link_rt26 = new Link(roteador2, pc6 , 41, 'C');

	// ---------------------- Links do Roteador 3: -------------------------
	     
	Link link_rt31 = new Link(roteador3, pc1 , 22, 'C');
	Link link_rt32 = new Link(roteador3, pc2, 32, 'O');
	Link link_rt33 = new Link(roteador3, pc3, 43, 'C');
	Link link_rt43 = new Link(roteador3, pc4, 43, 'C');
	Link link_rt35 = new Link(roteador3, pc5, 23, 'O');
	Link link_rt36 = new Link(roteador3, pc6, 22, 'O');


	// ---------------------- Links do Servidor 1: -------------------------
	     
	Link link_sr11 = new Link(servidor1, pc1 , 39, 'T');
	Link link_sr12 = new Link(servidor1, pc2, 39, 'C');
	Link link_sr13 = new Link(servidor1, pc3, 32, 'C');
	Link link_sr14 = new Link(servidor1, pc4, 23, 'C');
	Link link_st15 = new Link(servidor1, pc5 , 33, 'C');
	Link link_sr16 = new Link(servidor1,pc6 , 13, 'C');


	// ---------------------- Links do Servidor 2: -------------------------
	     
	Link link_sr21 = new Link(servidor2, pc1 , 49, 'O');
	Link link_sr22 = new Link(servidor2, pc2, 49, 'O');
	Link link_sr23 = new Link(servidor2, pc3, 21, 'T');
	Link link_sr24 = new Link(servidor2, pc4, 25, 'T');
	Link link_sr25 = new Link(servidor2, pc5, 35, 'T');
	Link link_sr26 = new Link(servidor2, pc6, 45, 'T');

	//---------------- Criação de Topologia ---------------------------
        
        Topologia t = new Topologia();
        
        t.addLink(link_r11);
        t.addLink(link_r12);
        t.addLink(link_r13);

        t.addLink(link_r21);
        t.addLink(link_r22);
        t.addLink(link_r23);

        t.addLink(link_r31);
        t.addLink(link_r32);
        t.addLink(link_r33);
        
	t.addLink(link_r41);
        t.addLink(link_r42);
        t.addLink(link_r43);

        t.addLink(link_r51);
        t.addLink(link_r52);
        t.addLink(link_r53);

        t.addLink(link_r61);
        t.addLink(link_r62);
        t.addLink(link_r63);

        t.addLink(link_rt11);
 	t.addLink(link_rt12);
	t.addLink(link_rt13);
	t.addLink(link_rt14);
	t.addLink(link_rt15);
	t.addLink(link_rt16);

	t.addLink(link_rt21);
 	t.addLink(link_rt22);
	t.addLink(link_rt23);
	t.addLink(link_rt24);
	t.addLink(link_rt25);
	t.addLink(link_rt26);

	t.addLink(link_rt31);
 	t.addLink(link_rt32);
	t.addLink(link_rt33);
	t.addLink(link_rt34);
	t.addLink(link_rt35);
	t.addLink(link_rt36);

	t.addLink(link_s11);
 	t.addLink(link_s12);

	t.addLink(link_s21);
 	t.addLink(link_s22);

	t.addLink(link_s31);
 	t.addLink(link_s32);

	t.addLink(link_s41);
 	t.addLink(link_s42);

	t.addLink(link_s51);
 	t.addLink(link_s52);

	t.addLink(link_s61);
 	t.addLink(link_s62);
	
	t.addLink(link_sr11);
	t.addLink(link_sr12);
	t.addLink(link_sr13);
	t.addLink(link_sr14);
	t.addLink(link_sr15);
	t.addLink(link_sr16);

 	t.addLink(link_sr21);
 	t.addLink(link_sr22);
 	t.addLink(link_sr23);
 	t.addLink(link_sr24);
 	t.addLink(link_sr25);
 	t.addLink(link_sr26);

	t.addLink(link_pc12);
	t.addLink(link_pc13);
	t.addLink(link_pc14);
	t.addLink(link_pc15);
	t.addLink(link_pc16);

	t.addLink(link_pc21);
	t.addLink(link_pc23);
	t.addLink(link_pc24);
	t.addLink(link_pc25);
	t.addLink(link_pc26);

	t.addLink(link_pc31);
	t.addLink(link_pc32);
	t.addLink(link_pc34);
	t.addLink(link_pc35);
	t.addLink(link_pc36);

	t.addLink(link_pc41);
	t.addLink(link_pc42);
	t.addLink(link_pc43);
	t.addLink(link_pc45);
	t.addLink(link_pc46);

	t.addLink(link_pc51);
	t.addLink(link_pc52);
	t.addLink(link_pc53);
	t.addLink(link_pc54);
	t.addLink(link_pc56);

	t.addLink(link_pc61);
	t.addLink(link_pc62);
	t.addLink(link_pc63);
	t.addLink(link_pc64);
	t.addLink(link_pc65);    
        
    }
    
}
