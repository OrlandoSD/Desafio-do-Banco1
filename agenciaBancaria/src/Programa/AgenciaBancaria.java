package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes(){
		
		System.out.println("==================================================");
		System.out.println("====== Bem Vindo a Nossa Agencia Digital =========");
		System.out.println("===***Selecione a Opção que deseja Realizar***===");
		System.out.println("---------------------------------------------------");
		System.out.println("| Opção 1 - Criar Conta |");
		System.out.println("| Opção 2 - Depositoar  |");
		System.out.println("| Opção 3 - Sacar       |");
		System.out.println("| Opção 4 - Transferir  |");
		System.out.println("| Opção 5 - Listar      |");
		System.out.println("| Opção 6 - Sair        |");
		System.out.println("---------------------------------------------------");
		
		int operacao = scan.nextInt();
		
		switch(operacao){
			case 1: 
				criarConta();
				break;
			case 2: 
				depositar();
				break;
			case 3: 
				sacar();
				break;
			case 4: 
				transferir();
				break;
			case 5: 
				listarContas();
				break;
			case 6: 
				System.out.println("Obrigado por utilizar nossos serviços");
				System.exit(0);
				
			default: 
				System.out.println("Opção Inválida!!!");
				operacoes();
				break;
				
		}
	}
	public static void criarConta(){
		
		System.out.println("\nNome: ");
		String nome = scan.next();
		
		System.out.println("\nCPF: ");
		String cpf = scan.next();
		
		System.out.println("\nEmal: ");
		String email = scan.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(0, pessoa);
		
		contasBancarias.add(conta);
		System.out.println("sua Conta foi criada com sucesso!!!");
		
		operacoes();
	} 
	
	private static Conta encontrarConta(int numeroConta){
		Conta conta = null;
		if(contasBancarias.size()> 0){
			for(Conta c: contasBancarias ){
				if(c.getNumeroConta() == numeroConta){
				conta = c;
				}
			}
		}
		return conta;
	}
	public static void depositar(){
		System.out.println("Número da Conta: ");
		int numeroConta = scan.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null){
			System.out.println("Qual valor deseja depositar?");
			Double valorDeposito = scan.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!!!");
		}else{
			System.out.println("Numero de conta Inválido, operação não foi efetuada!!");
		}
		operacoes();
	}
	
	public static void sacar(){
		System.out.println("Número da Conta: ");
		int numeroConta = scan.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null){
			System.out.println("Qual valor deseja sacar?");
			Double valorSaque = scan.nextDouble();
			conta.depositar(valorSaque);
			//System.out.println("Valor sacado com sucesso!!!");
		}else{
			System.out.println("Numero de conta Inválido, operação não foi efetuada!!");
		}
		operacoes();
	}
	public static void transferir(){
		
		System.out.println("Número da Conta do remetente: ");
		int numeroContaRemetente = scan.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null){
			System.out.println("Número da conta do Destinatário: ");
			int numeroContaDestinatario = scan.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null){
				System.out.println("Valor da transferência!!!");
				Double valor  = scan.nextDouble();
			contaRemetente.transferir(contaDestinatario, valor);
			}else{
				System.out.println("A Conta para depósito não foi encontrada!!!");
			}
			}else{
				System.out.println(" Conta para transferencia não foi encontrada!!!");
			}
			operacoes();
	}	




	public static void listarContas(){
		if(contasBancarias.size()> 0){
			for(Conta conta: contasBancarias){
				System.out.println(conta);
			}
		}else{
			System.out.println("Não há contas Cadastradas!!!");
			}
		operacoes();
		}
	
}
