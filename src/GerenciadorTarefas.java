import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    String descricao;
    boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    public String toString() {
        return (concluida ? "[✔] " : "[ ] ") + descricao;
    }
}

public class GerenciadorTarefas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n---- GERENCIADOR DE TAREFAS ----");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String desc = sc.nextLine();
                    listaTarefas.add(new Tarefa(desc));
                    break;
                case 2:
                    System.out.println("\n--- TAREFAS ---");
                    for (int i = 0; i < listaTarefas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaTarefas.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa a concluir: ");
                    int num = sc.nextInt();
                    if (num > 0 && num <= listaTarefas.size()) {
                        listaTarefas.get(num - 1).marcarConcluida();
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
