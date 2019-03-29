
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ana_r
 */
public class Roteamento {

    Topologia t;
    LinkedList<Dispositivo> rota_final;
    int custo_final;
    ArrayList<LinkedList<Dispositivo>> rota_geral;

    public Roteamento(Topologia t) {
        this.t = t;
    }

    private int fatorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * fatorial(num - 1);
    }

    public LinkedList<Integer> Rotas(Dispositivo origem, Dispositivo destino) {
        LinkedList<Integer> custo = new LinkedList<Integer>();
        int custo_aux = 0;
        int n_fatorial = fatorial(t.nDispositivos - 2);
        LinkedList<Dispositivo> aux = new LinkedList<Dispositivo>();
        ArrayList<LinkedList<Dispositivo>> rota_geral = new ArrayList<LinkedList<Dispositivo>>();

        int i = 0;
        while (i < n_fatorial) {

            Dispositivo atual = origem;

            while (atual != destino) {
                Random rand = new Random();
                int r = rand.nextInt(t.getNeighbours(atual.getId()).size());
                aux.add(atual);
                atual = t.getNeighbours(atual.getId()).get(r).getB();
                custo_aux += t.getNeighbours(atual.getId()).get(r).getCusto();
            }
            aux.add(atual);

            if (!rota_geral.contains(aux)) {
                rota_geral.add(aux);
                custo.add(custo_aux);
                i++;
            }
        }

        return custo;
    }

    public LinkedList<Dispositivo> SimulatedAnnealing(Dispositivo origem, Dispositivo destino) {
        double Ti = 300;
        double alfa = 0.95;
        double Tf = 1;
        int L = 3;
        double T_atual = Ti;

        LinkedList<Integer> custo = Rotas(origem, destino);
        custo_final = custo.getFirst();
        int valor_max = custo.size();

        while (T_atual > Tf) {
            Random r = new Random();
            for (int i = 0; i < L; i++) {
                int pos = r.nextInt(valor_max);
                int custo_aux = custo.get(pos);
                LinkedList<Dispositivo> aux = rota_geral.get(pos);

                if (custo_aux < custo_final) {
                    custo_final = custo_aux;
                    rota_final = aux;
                } else {
                    if (r.nextDouble() < (Math.exp(-(custo_aux - custo_final) / T_atual))) {
                        custo_final = custo_aux;
                        rota_final = aux;
                    }
                }
            }

            T_atual = T_atual * alfa;
        }

        return rota_final;
    }
}
