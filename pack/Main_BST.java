package pack;

import java.util.Scanner;

public class Main_BST {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        BST bst = new BST();

        int menu = 0;

        while(menu != 6){
            System.out.println("|=========== MENU ==========|");
            System.out.println("|1 -    Inserir valor       |");
            System.out.println("|2 -    Acessar valor       |");
            System.out.println("|3 -    Alterar valor       |");
            System.out.println("|4 -       InOrder          |");
            System.out.println("|5 -     DFS ou BFS         |");
            System.out.println("|6 -        Fechar          |");
            menu = sc.nextInt();

            if(menu == 1){
                System.out.println("Digite um número como chave: ");
                int key = sc.nextInt();
                System.out.println("Digite o valor que deseja setar no nó: ");
                String value = sc.next();
                bst.insert(key, value);

            }else if(menu == 2){
                System.out.println("Digite a chave do nó que deseja acessar: ");
                int key = sc.nextInt();
                System.out.println("Valor: " + bst.get(key));

            }else if(menu ==3){
                System.out.println("Digite a chave do nó que deseja alterar: ");
                int key = sc.nextInt();
                System.out.println("Digite o valor que deseja setar no nó: ");
                String value = sc.next();
                bst.set(key,value);

            }else if(menu == 4){
                bst.inOrder();

            }else if(menu == 5){
                System.out.println("dgite 1 para DFS(Busca em profundidade)");
                System.out.println("dgite 2 para bFS(Busca em largura)");
                int option = sc.nextInt();

                if(option == 1){
                    System.out.println("Digite a chave que deseja encontrar: ");
                    int key = sc.nextInt();
                    bst.BuscaProfundidade(key);
                }
                if (option == 2){
                    System.out.println("Digite a chave que deseja encontrar: ");
                    int key = sc.nextInt();
                    bst.BuscaLargura(key);
                }
                
            }else if(menu == 6) {
                System.out.println("Close");

            }else{
                System.out.println("Valor negado!!");
            }
        }
        sc.close();
    }
}