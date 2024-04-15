import java.util.Scanner;

public class gerenciaBanco {
  public static void main(String[] args) {
    Scanner dados = new Scanner(System.in);
    System.out.println("Informe seu nome: ");
    String nome = dados.nextLine();
    System.out.println("Informe seu sobrenome: ");
    String sobrenome = dados.nextLine();
    System.out.println("Informe seu CPF: ");
    String cpf = dados.nextLine();

    cliente cliente1 = new cliente(nome, sobrenome, cpf);

    boolean continuar = true;

    while (continuar) {
      System.out.print("\nO que você deseja?\n");
      System.out.print("1- Consultar saldo\n");
      System.out.print("2- Fazer deposito\n");
      System.out.print("3- Realizar saque\n");
      System.out.print("4- Finalizar aplicação\n");

      int choice = dados.nextInt();

      switch (choice) {
        case 1:
          cliente1.consultarSaldo();
          break;
        case 2:
          System.out.println("Informe o valor a ser depositado: ");
          double valorDeposito = dados.nextDouble();
          cliente1.deposito(valorDeposito);
          break;
        case 3:
          System.out.println("Informe o valor a ser sacado: ");
          double valorSaque = dados.nextDouble();
          cliente1.sacar(valorSaque);
          break;
        case 4:
          continuar = false;
          System.out.println("Obrigado e volte sempre!");
          break;
        default:
          System.out.println("Opção invalida tente novamente!");
          break;
      }
      
    }
    dados.close();
  }
}

class cliente {
  private String nome;
  private String sobrenome;
  private String cpf;
  private double saldo;

  public cliente(String nome, String sobrenome, String cpf) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    this.saldo = 0.00;
  }

  public void consultarSaldo() {
    System.out.println("Seu saldo é R$ " + saldo);
  }

  public void deposito(double valor) {
    if (valor > 0) {
      saldo += valor;
      System.out.println("O valor R$ " + valor + " foi depositado com sucesso!");
      System.out.println("O valor atual do seu saldo é de R$ " + saldo);
    } else {
      System.out.println("Valor do deposito invalodo!");
    }
  }

  public void sacar(double valor) {
    if (valor <= saldo && valor > 0) {
      saldo -= valor;
      System.out.println("O saque no valor de R$ " + valor + " foi realizado com sucesso!");
      System.out.println("O valor atual do seu saldo é de R$ " + saldo);
    } else {
      System.out.print("Saldo insuficiente ou valor do saque invalido!");
    }
  }

}

