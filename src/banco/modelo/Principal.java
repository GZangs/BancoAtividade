package banco.modelo;
import java.util.ArrayList;
import java.util.Scanner;

import banco.dao.ClienteDao;
import banco.dao.ContaDao;


public class Principal {

	public static void main(String[] args) {
		ArrayList<Conta> banco = new ArrayList<>();

		System.out.println("Agência Bancária");
			
		contas(banco);
		
		for (Conta c : banco) {
			System.out.println("Conta corrente: ");
			System.out.println(c);
		}

	}
		
	private static void contas(ArrayList<Conta> banco) {
		Scanner entrada = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		
		System.out.print("Entre o nome do cliente, ou deixe em branco para terminar: ");
		cliente.setNome(entrada.nextLine());
		
		while (!cliente.getNome().isEmpty()) {		
			Conta conta;
						
			System.out.print("Entre o cpf do cliente: ");
			cliente.setCpf(entrada.nextLong());
			entrada.nextLine();
			
			System.out.print("Entre o rg do cliente: ");
			cliente.setRg(entrada.nextLong());
			entrada.nextLine();
			
			System.out.print("Entre o endereço do cliente: ");
			cliente.setEndereco(entrada.nextLine());
			
			System.out.print("Entre o telefone do cliente: ");
			cliente.setTelefone(entrada.nextLong());
			entrada.nextLine();
			
			System.out.print("Entre a renda mensal do cliente: ");
			cliente.setRendaMensal(entrada.nextDouble());
			entrada.nextLine();
			
			System.out.print("Entre a agência da conta bancária: ");
			int agencia = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("Entre o número da conta bancária: ");
			int numero = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("Entre o saldo inicial: ");
			double saldo = entrada.nextDouble();
			entrada.nextLine();
						
			ClienteDao clientDao = new ClienteDao();
			clientDao.insert(cliente);
			
			conta = new Conta(agencia, numero, cliente, saldo);
			
			ContaDao contaDao = new ContaDao();
			contaDao.insert(conta);
						
			System.out.print("Entre o nome do cliente, ou deixe em branco para terminar: ");
			cliente.setNome(entrada.nextLine());
		}
		
		entrada.close();

	}
}