
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Color;
import java.util.Random;

public class Hierholzer {

    static private Graph graph, graph_aux;
    private LinkedList<Integer> eulerianCycle;
    private LinkedList<Integer> rota_final;
    private LinkedList<Integer> rota_aux;
    private int custo_atual;

    static void slow() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Color getRadomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    private void InsertCycle(LinkedList<Integer> newCycle, int index) {
        this.eulerianCycle.addAll(index, newCycle);
    }

    private int SearchCycle(Edge rua_inicial) {
        LinkedList<Integer> rota = new LinkedList<Integer>();
        LinkedList<Integer> visited = new LinkedList<Integer>();

        rota.add(rua_inicial.getU());
        int atual = rua_inicial.getU();
        visited.add(atual);

        int peso_Total = 0;

        System.out.println("N arestas:" + graph_aux.nEdges);
        while (graph_aux.existEdges()) {
            Random rand = new Random();

            int valor_max = graph_aux.getNeighbours(atual).size();
            Edge aresta;
            int random;

            if (valor_max > 1) {

                random = rand.nextInt(valor_max);
                aresta = graph_aux.getNeighbours(atual).get(random);
                
                peso_Total += aresta.getWeight();

                int novo = aresta.getV();
                rota.add(novo);
                visited.add(novo);

                System.out.println("Aresta que vai remover " + aresta.getU() + " -> " + aresta.getV());
                System.out.println("Aresta que vai remover " + aresta.getV() + " -> " + aresta.getU());
                graph_aux.removeEdge(aresta);
                atual = novo;

            } else {
                if (valor_max == 1) {
                    aresta = graph_aux.getNeighbours(atual).getFirst();
                    peso_Total += aresta.getWeight();

                    int novo = aresta.getV();
                    rota.add(novo);
                    visited.add(novo);

                    System.out.println("Aresta que vai remover " + aresta.getU() + " > " + aresta.getV());
                    System.out.println("Aresta que vai remover " + aresta.getV() + " > " + aresta.getU());

                    graph_aux.removeEdge(aresta);
                    atual = novo;
                } else {
                    break;
                }
            }
        }

        rota_aux = rota;

        return peso_Total;
    }

    public LinkedList<Integer> SearchEulerianCycle(int startVertice) {

//        if (!graph.isEulerian()) {
//            graph.turnEulerian();
//        }
//
//        eulerianCycle = SearchCycle(startVertice);
//
//        int i = 0;
//
//        while (graph.nEdges > 0) {
//            i++;
//            if (!graph.getNeighbours(eulerianCycle.get(i)).isEmpty()) {
//                LinkedList<Integer> novoCiclo = SearchCycle(eulerianCycle.get(i));
//                novoCiclo.removeLast();
//                InsertCycle(novoCiclo, i);
//            }
//
//        }
        return eulerianCycle;
    }

    public LinkedList<Integer> SimulatedAnnealing(int startVertice) {
        double Ti = 100;
        double alfa = 0.8;
        double Tf = 10;
        int L = 1;
        double T_atual = Ti;

        int atual = startVertice;

        graph_aux = graph;

        LinkedList<Edge> vizinhos = graph_aux.getNeighbours(atual);

        Random rand = new Random();
        int valor_max = graph_aux.getNeighbours(atual).size();

        int random = rand.nextInt(valor_max);
        System.out.println("RAND:" + rand.nextInt(valor_max));

        custo_atual = SearchCycle(vizinhos.get(random));
        rota_final = rota_aux;

        int custo;

        while (T_atual > Tf) {
            for (int i = 0; i < L; i++) {

                graph_aux = graph;
                vizinhos = graph_aux.getNeighbours(atual);
                valor_max = vizinhos.size();

                if (valor_max > 1) {
                    random = rand.nextInt(valor_max);
                    custo = SearchCycle(vizinhos.get(random));
                    System.out.println("CUSTO:" + custo);
                } else if (valor_max == 1) {
                    System.out.println("VALOR MAXIMO == 1");
                    custo = SearchCycle(vizinhos.getFirst());
                } else {
                    continue;
                }

                if (custo <= custo_atual) {
                    rota_final = rota_aux;
                    custo_atual = custo;
                } else {
                    Random r = new Random();
                    if (r.nextDouble() < (Math.exp(-(custo - custo_atual) / T_atual))) {
                        rota_final = rota_aux;
                        custo_atual = custo;
                    }
                }
            }

            T_atual = T_atual * alfa;
        }

        return rota_final;
    }

    /**
     * ****************************************************************************************
     */
    public static String CycleToString(LinkedList<Integer> cycle) {
        String str = "";
        for (Integer integer : cycle) {
            str += integer + " -> ";
        }
        return str.substring(0, str.length() - 4);
    }

    public void test1() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 5);
        graph.addEdge(4, 1, 5);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 3, 5);

        System.out.println("Lista de adjacencia do grafo:");
        System.out.println(graph.toString());
    }

    public void test2() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 5);
        graph.addEdge(4, 1, 5);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 3, 5);

        System.out.println("Lista de adjacencia do grafo ANTES da remocao:");
        System.out.println(graph.toString());
        System.out.println();

        graph.removeEdge(new Edge(1, 4, 5));
        graph.removeEdge(new Edge(0, 4, 5));
        graph.removeEdge(new Edge(0, 2, 5));

        System.out.println("Lista de adjacencia do grafo DEPOIS da remocao:");
        System.out.println(graph.toString());
    }

    public void test3() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 5);
        graph.addEdge(4, 1, 5);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 3, 5);

        System.out.println("Vertices vizinhos do vertice 0:");
        for (Edge e : graph.getNeighbours(0)) {
            System.out.print(e.getV() + " ");
        }
        System.out.println();

        System.out.println("Vertices vizinhos do vertice 2:");
        for (Edge e : graph.getNeighbours(2)) {
            System.out.print(e.getV() + " ");
        }
        System.out.println();;
    }

    public void test4() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 5);
        graph.addEdge(4, 1, 5);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 3, 5);

        System.out.println("Lista de adjacencia do grafo 1:");
        System.out.print(graph.toString());
        System.out.println("Euleriano:" + graph.isEulerian() + "\n");

        graph = new Graph(6);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 4, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 5);

        System.out.println("Lista de adjacencia do grafo 2:");
        System.out.print(graph.toString());
        System.out.println("Euleriano: " + graph.isEulerian());
    }

    public void test5(int startVertice) {
        graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 5);
        graph.addEdge(4, 1, 5);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 3, 5);

        //LinkedList<Integer> cycle = SearchSimpleCycle(startVertice);
        System.out.println("Ciclo Simples Encontrado: comecando de " + startVertice);
        //System.out.println(CycleToString(cycle));
    }

    public void test6() {
        Hierholzer hierholzer = new Hierholzer();
        //graph = new Graph("grafo1.csv", "white.png", "Roteamento"); // Grafo nao Euleriano
        graph = new Graph("grafo2.csv", "white.png", "Roteamento"); // Grafo Euleriano
        System.out.println();
        LinkedList<Integer> eulerianCycle = hierholzer.SearchEulerianCycle(0);
        System.out.println("Ciclo␣Final: ");
        System.out.println(Hierholzer.CycleToString(eulerianCycle));
        Graph graph2 = new Graph(graph.getGraphics(), "white.png", "Rota␣Final");
        for (Integer i : eulerianCycle) {
            slow();
            slow();
            Color color = Hierholzer.getRadomColor();
            graph2.markNode(i, color);
        }

    }

    public void test7() {
        Hierholzer hierholzer = new Hierholzer();
        // hierholzer.test5(0);

        //graph = new Graph("grafo.csv", "white.png", "Roteamento");
        //graph = new Graph("grafo1.csv", "white.png", "Roteamento");
        //graph = new Graph("grafoMapa1.csv", "mapa1.png", "Roteamento");
        graph = new Graph("grafoMapa2.csv", "mapa2.png", "Roteamento");

        System.out.println();
        //LinkedList<Integer> eulerianCycle = hierholzer.SearchEulerianCycle(1);
        LinkedList<Integer> ciclo = hierholzer.SimulatedAnnealing(14);
        System.out.println("Ciclo Final:");
        System.out.println(Hierholzer.CycleToString(ciclo));
        System.out.println("Custo: " + custo_atual);

        // Graph graph2 = new Graph(graph.getGraphics(), "white.png", "Rota Final");
        //Graph graph2 = new Graph(graph.getGraphics(), "mapa1.png", "Rota Final");
        Graph graph2 = new Graph(graph.getGraphics(), "mapa2.png", "Rota Final");
        for (Integer i : ciclo) {
            slow();
            Color color = Hierholzer.getRadomColor();
            graph2.markNode(i, color);
        }
    }

    public static void main(String[] args) {
        Hierholzer instance = new Hierholzer();
        instance.test7();
    }
}
