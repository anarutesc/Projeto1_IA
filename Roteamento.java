
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

    public Topologia t;
    public LinkedList<Dispositivo> rota_final;
    public int custo_final;
    public ArrayList<LinkedList<Dispositivo>> rota_geral;
    public LinkedList<Integer> custo;

    public Roteamento(Topologia t) {
        this.t = t;
    }

    private int fatorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * fatorial(num - 1);
    }

    public int nRotas() {
        int n_fatorial = fatorial(t.nDispositivos - 2);

        int total = 0;

        for (int i = 1; i <= t.nDispositivos - 2; i++) {
            int fat = fatorial(t.nDispositivos - 2 - i);
            int aux = n_fatorial / fat;
            total += aux;
        }

        return total;
    }

    public void Rotas(Dispositivo origem, Dispositivo destino) {
        custo = new LinkedList<Integer>();
        int custo_aux;
        rota_geral = new ArrayList<LinkedList<Dispositivo>>();

        int i = 0;
        while (i < nRotas()) {
            custo_aux = 0;
            Dispositivo atual = origem;
            LinkedList<Dispositivo> aux = new LinkedList<Dispositivo>();
            while (atual != destino) {
                Random rand = new Random();
                int r = rand.nextInt(t.getNeighbours(atual.getId()).size());
                aux.add(atual);
                atual = t.getNeighbours(atual.getId()).get(r).getB();
                custo_aux += t.getNeighbours(atual.getId()).get(r).custo;
            }
            aux.add(atual);

            if (!rota_geral.contains(aux)) {
                rota_geral.add(aux);
                custo.add(custo_aux);
                i++;
            }
        }

    }

    public void SimulatedAnnealing(Dispositivo origem, Dispositivo destino) {
        double Ti = 100;
        double alfa = 0.95;
        double Tf = 1;
        int L = 3;
        double T_atual = Ti;

        Rotas(origem, destino);
        custo_final = custo.getFirst();
        rota_final = rota_geral.get(0);

        int custo_aux;
        int valor_max = custo.size();

        while (T_atual > Tf) {
            for (int i = 0; i < L; i++) {
                Random r = new Random();
                int pos = r.nextInt(valor_max);
                custo_aux = custo.get(pos);
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
    }
}
