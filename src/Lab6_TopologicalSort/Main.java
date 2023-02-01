package Lab6_TopologicalSort;

import java.sql.SQLOutput;

class Main {
    public static void main(String args[]) {
        // A graph
        Graph g1 = new Graph(6);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(5, 2);
        g1.addEdge(5, 4);

        // A graph that contains a cycle
        Graph g2 = new Graph(6);
        g2.addEdge(1, 2);
        g2.addEdge(2, 5);
        g2.addEdge(5, 0);
        g2.addEdge(5, 1);
        g2.addEdge(3, 4);
        g2.addEdge(4, 5);

        //Question 1:
        System.out.println("Question 1");

        g1.topologicalSort();
        System.out.println("*****************************************************");


//        Question 2:
        System.out.println("Question 2");

        System.out.println("G1");
        g1.topologicalSort();

        System.out.println("G2");
        g2.topologicalSort();
        System.out.println("*****************************************************");

//        Question 3
        System.out.println("Question 3");
        System.out.println("G1");
        g1.topologicalSortStackImpl();

        System.out.println("G2");
        g2.topologicalSortStackImpl();


        System.out.println();
        System.out.println("*****************************************************");
        System.out.println("Question 4");


        // Question 4: Comment here
        /*
        Difference between stack implementation and queue implementation is:
        Stack using first in last out, queue use first in first out.
        this difference makes the output not same. the order will change depends on the data structure we use.
         */


    }
}