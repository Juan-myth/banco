package br.com.caelum.conta.main;

import br.com.caelum.conta.modelo.*;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// istancia de objeto
	
		Data d1 = new Data(27, 03, 2024);
	
		Scanner leia = new Scanner(System.in);
		Conta c0 = new Conta("João P", "37822435-4", 000, d1);
		Conta c1 = new Conta("João", "37822435-5", 001, d1);
		Conta c2 = new Conta("Sofia", "37822435-5", 002, d1);
		Conta c3 = new Conta("Carlos", "37822435-5", 003, d1);

		c0.setDataDeAbertura(d1);
		c1.setDataDeAbertura(d1);
		c2.setDataDeAbertura(d1);
		c3.setDataDeAbertura(d1);

		c1.saca(100);

		// c1.setDataDeAbertura(new Data);
		// Data d1 = new Data(27, 03, 2024);

		System.out.println(c0.recuperarDadosParaimpressao());
		System.out.println(c1.recuperarDadosParaimpressao());
		System.out.println(c2.recuperarDadosParaimpressao());
		System.out.println(c3.recuperarDadosParaimpressao());

		System.out.println("\n\nTotal de contas: " + c0.getTotalDeContas());

		// Deposita da conta 1
		System.out.print("\nQual é o valor do deposito da conta 1? ");

		c1.deposita(leia.nextDouble());

		System.out.println(c1.recuperarDadosParaimpressao());

//		// Deposita da conta 2
//		System.out.println("\nQual o valor do deposito da conta 2? ");
//
//		c2.deposita(leia.nextDouble());
//
//		System.out.println(c2.recuperarDadosParaimpressao());
//
//		// deposita da conta 3
//
//		System.out.println("Qual o valor do deposito da conta 3? ");
//
//		c3.deposita(leia.nextDouble());
//
//		System.out.println(c3.recuperarDadosParaimpressao());

		// "tansfere para" da conta 1

		System.out.println("\nQual o valor da transeferência da conta 1?");

		c1.transferePara(c2, leia.nextDouble());

		System.out.println(c1.recuperarDadosParaimpressao());
		System.out.println(c2.recuperarDadosParaimpressao());

		// transfere para da conta 2

//		System.out.println("Qual o valor do deposito da conta 2? ");
//		
//		//c2.transferePara(c1, leia.nextDouble());
//		
//		System.out.println(c2.recuperarDadosParaimpressao());
		// Tranfere para da conta 3
//		System.out.println("Qual o valor do deposito da conta 3? ");

		// c3.transferePara(c2, leia.nextDouble());

//		System.out.println(c3.recuperarDadosParaimpressao());

		// calcula rendimento da conta 1 e 2

		c1.calculaRendimentos();
		c2.calculaRendimentos();

		System.out.println(c1.recuperarDadosParaimpressao());
		System.out.println(c2.recuperarDadosParaimpressao());

		PessoaFisica pf = new PessoaFisica();
		System.out.print("Digite o CPF: ");
		leia.nextLine();
		System.out.println(pf.validarCPF(leia.nextLine()));

		leia.close();

	}

}
