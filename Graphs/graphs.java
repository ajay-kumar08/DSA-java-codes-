import java.util.*;

public class graphs {
    public static int vcount=0;
    static  class Edge{
        int src;
        int dest;


        public Edge(int s, int d) {
            this.src=s;
            this.dest=d;

        }

    }


//    static void createGraph1(ArrayList<Edge> graph[]) {
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//
//        }
//        graph[0].add(new Edge(0, 1, 1));
//        graph[0].add(new Edge(0, 2, 1));
//
//        graph[1].add(new Edge(1, 0, 1));
//        graph[1].add(new Edge(1, 3, 1));
//
//        graph[2].add(new Edge(2, 0, 1));
//        graph[2].add(new Edge(2, 4, 1));
//
//        graph[3].add(new Edge(3, 1, 1));
//        graph[3].add(new Edge(3, 4, 1));
//        graph[3].add(new Edge(3, 5, 1));
//
//        graph[4].add(new Edge(4, 2, 1));
//        graph[4].add(new Edge(4, 3, 1));
//        graph[4].add(new Edge(4, 5, 1));
//
//        graph[5].add(new Edge(5, 3, 1));
//        graph[5].add(new Edge(5, 4, 1));
//        graph[5].add(new Edge(5, 6, 1));
//
//        graph[6].add(new Edge(6, 5, 1));
//
//        graph[7].add(new Edge(7, 8, 1));
//
//        graph[8].add(new Edge(8, 7, 1));
//
//
//
//    }

    static void createGraph2(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
//        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
    static void createGraph3(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if (!vis[e.dest]) {
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                    vcount++;
                    return true;

                }

            } else if (vis[e.dest] && e.dest != par) {
                vcount++;
                return true;
            }
        }
        return false;
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph,vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[],boolean vis[]) {

        Queue<Integer> q=new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr=q.remove();
            if (!vis[curr]) {
                System.out.print(curr+" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }



        }


    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph,i,vis);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean vis[]) {
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }

        }
    }

//    public static boolean isBipartite(ArrayList<Edge>[] graph) {
//        int color[] = new in
//        t[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            color[i]=-1;
//        }
//
//    }

//    public static boolean isBipartite(ArrayList<Edge>[] graph) {
//        if (!detectCycle(graph)) {
//            return true;
//        }
//        if (detectCycle(graph) && (vcount % 2 == 0)) {
//            return true;
//        }
//        return false;
//    }
    public static void main(String[] args) {
        /*graph1
                  1----------3                      8
                 /           | \                   /
                0            |   5-----6         7
                 \           |  /
                   2---------4


        */


        /* Graph2

                         0----------3
                       / |          |
                      1  |          |
                       \ |          |
                        \|          4
                         2


         */

        /*Graph3
                        0-------------2
                       /             /
                      /             /
                     1             4
                      \           /
                        \        /
                          \     /
                             3
         */
        int v=9;
        ArrayList<Edge>[] graph =new ArrayList[v];
//        createGraph2(graph);
//        bfs(graph);
        System.out.println();
//        dfs(graph);
//        System.out.println(detectCycle(graph));
//        createGraph2(graph);
//        System.out.println(isBipartite(graph));

        
    }
}
