package main;

import utils.StudentValidator;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Models.Node;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        // ----------------------------------------------------------
        // Ejercicio01
        // ----------------------------------------------------------
        System.out.println("\n===== EJERCICIO 01 =====");

        InsertBST bst = new InsertBST();
        Node root = null;
        int[] valores = { 5, 3, 7, 2, 4, 6, 8 };

        System.out.print("Input: ");
        for (int v : valores) {
            System.out.print(v + " ");
            root = bst.insert(root, v);
        }
        System.out.println();

        System.out.println("Output:");
        ArbolBinario arbol = new ArbolBinario();
        arbol.setRoot(root);
        arbol.printTree();

        System.out.println("\nRaiz BST: " + root.getValue());

        // ----------------------------------------------------------
        // Ejercicio02
        // ----------------------------------------------------------

        System.out.println("\n===== EJERCICIO 02 =====");

        // Insertar los valores2 del arbol
        int[] valores2 = { 4, 2, 7, 1, 3, 6, 9 };
        InsertBST bst2 = new InsertBST();
        Node original = null;

        System.out.print("Input: ");
        for (int v : valores2) {
            System.out.print(v + " ");
            original = bst2.insert(original, v);
        }
        System.out.println();

        System.out.println("\nArbol original:");
        ArbolBinario arbolOriginal = new ArbolBinario();
        arbolOriginal.setRoot(original);
        arbolOriginal.printTree();

        // Invertir el arbol
        InvertBinaryTree inverter = new InvertBinaryTree();
        Node invertido = inverter.invertTree(original);

        System.out.println("\nOutput:");
        ArbolBinario arbolInvertido = new ArbolBinario();
        arbolInvertido.setRoot(invertido);
        arbolInvertido.printTree();

        System.out.println("\nRaiz invertido: " + invertido.getValue());

        // ----------------------------------------------------------
        // Ejercicio03
        // ----------------------------------------------------------
        System.out.println("\n===== EJERCICIO 03 =====");

        /*
         * ListLevels niveles = new ListLevels();
         * List<List<Node>> lista = niveles.listLevels(invertido);
         * for (int i = 0; i < lista.size(); i++) {
         * System.out.print("Nivel " + i + ": ");
         * for (Node n : lista.get(i)) {
         * System.out.print(n.getValue() + " ");
         * }
         * System.out.println();
         * }
         */

        // Insertar valores3
        int[] valores3 = { 4, 2, 7, 1, 3, 6, 9 };
        InsertBST bst3 = new InsertBST();
        Node rootNivel = null;

        System.out.print("Input: ");
        for (int v : valores3) {
            System.out.print(v + " ");
            rootNivel = bst3.insert(rootNivel, v);
        }
        System.out.println();

        // Mostrar estructura del arbol 
        System.out.println("\nArbol:");
        ArbolBinario arbolNiveles = new ArbolBinario();
        arbolNiveles.setRoot(rootNivel);
        arbolNiveles.printTree();

        // Listar niveles con formato

        ListLevels listLevels = new ListLevels();
        List<List<Node>> niveles = listLevels.listLevels(rootNivel);
        System.out.println("");

        for (int i = 0; i < niveles.size(); i++) {
            System.out.print("Nivel " + i + ": ");
            List<Node> nivel = niveles.get(i);
            for (int j = 0; j < nivel.size(); j++) {
                System.out.print(nivel.get(j).getValue());
                if (j < nivel.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        // ----------------------------------------------------------
        // Ejercicio04
        // ----------------------------------------------------------
        System.out.println("\n===== EJERCICIO 04 =====");

        /*
         * Depth profundidad = new Depth();
         * int profundidadMaxima = profundidad.maxDepth(root);
         * System.out.println("Profundidad maxima: " + profundidadMaxima);
         */

        // Lista que se puede modificar

        
        // Insertar valoresProdundidad
        int[] valoresProfundidad5 = { 4, 2, 7, 1, 3 };
        InsertBST bstProfundidad5 = new InsertBST();
        Node rootProfundidad5 = null;

        System.out.print("Input: ");
        for (int v : valoresProfundidad5) {
            System.out.print(v + " ");
            rootProfundidad5 = bstProfundidad5.insert(rootProfundidad5, v);
        }

        // Agregar 8 manualmente como hijo izquierdo de 1
        rootProfundidad5.getLeft().getLeft().setLeft(new Node(8));
        System.out.print("8"); // Mostrar el 8 como parte del input
        System.out.println();

        System.out.println("\nArbol:");
        ArbolBinario arbolProfundidad5 = new ArbolBinario();
        arbolProfundidad5.setRoot(rootProfundidad5);
        arbolProfundidad5.printTree();

        Depth depthCalc5 = new Depth();
        int profundidadMaxima5 = depthCalc5.maxDepth(rootProfundidad5);
        System.out.println("\nProfundidad maxima: " + profundidadMaxima5);

    }
}
