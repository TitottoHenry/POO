package exercicio04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    // variáveis globais da aplicação
    static Scanner sc = new Scanner(System.in);
    static Funcionario[] funcionario = new Funcionario[5];
    static int index = 0; // indica qual a última posição preenchida

    public static void main(String[] args) {

        int opcao;


        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Pesquisar");
            System.out.println("3. Listar");
            System.out.println("4. Finalizar");
            opcao = sc.nextInt();
            if(opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida");
            }
            else {
                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        listar();
                        break;
                }
            }
            System.out.println();
        } while(opcao != 4);
    }

    public static void cadastrar() {
        String nome, cargo;
        double salario;

        if(index < funcionario.length) {
            System.out.print("Nome: ");
            nome = sc.next();
            System.out.print("Cargo: ");
            cargo = sc.next();
            System.out.print("Salário: R$ ");
            salario = sc.nextDouble();
            funcionario[index] = new Funcionario(nome, cargo, salario);
            index++;
        }
        else {
            System.out.println("Não há espaço disponível");
        }
    }

    public static void pesquisar() {
        String pesquisar;
        System.out.println("digite o funcionario que esta procurando: ");
        pesquisar = sc.next();

        for(int i =0; i<index; i++){
            if(funcionario[i].nome.equalsIgnoreCase(pesquisar)){
                System.out.println(pesquisar + " foi encontrado na base de dados");
            return;
            }
        }
        System.out.println(pesquisar +" nao foi encontrado na base de dados");
    }

    public static void listar() {
        DecimalFormat df = new DecimalFormat( "0.00");
        System.out.println("lista dos usuarios cadastrados");
        for(int i=0; i<index; i++){
            System.out.println("nome: "+ funcionario[i].nome+"\n cargo: "+funcionario[i].cargo+"\n salario: "+ df.format(funcionario[i].salario));
        }
    }



}
