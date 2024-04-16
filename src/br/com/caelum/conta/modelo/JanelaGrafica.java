package br.com.caelum.conta.modelo;

import javax.swing.JOptionPane;

public class JanelaGrafica {
	public static void main(String[] args) {

		// capitura os dados da conta para criar uma nova conta
		String titular = JOptionPane.showInputDialog("Digite o nome do titular da conta");
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta"));
		String agencia = JOptionPane.showInputDialog("Digite o número da agência");
		int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "iforme o dia de criação da conta"));
		int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o mes de criação da conta "));
		int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano de criação da conta"));

		// instância de objeto
		Conta conta = new Conta(titular, agencia, numero, new Data(dia, mes, ano));
//		conta.setTitular(titular);
//		conta.setNumero(numero);
//		conta.setAgencia(agencia);

		// depósito inicial
		double depositoInicial = Double.parseDouble(JOptionPane.showInputDialog("Qual será o deposito inicial"));
		conta.deposita(depositoInicial);

		// Menu de operações

		String menu = "Escolha uma operação:\n";
		menu += "1. Consulta saldo\n";
		menu += "2. Realizar deposito\n";
		menu += "3. Realizar saque\n";
		menu += "4. Transferir valor para outra conta\n";
		menu += "5. Vizualizar dados da conta\n";
		menu += "6. Sair";

		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcao) {
			case 1:
				JOptionPane.showMessageDialog(null, "Saldo atual: " + conta.getSaldo());
				break;

			case 2:
				double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito:"));
				conta.deposita(valorDeposito);
				JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");
				break;

			case 3:
				double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
				if (conta.saca(valorSaque))
					;

				JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
				break;
				// Transferência para outra conta (necessário implementar)
			case 4:

				double valorTransfere = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da transferência:"));
				conta.transferePara(conta, valorTransfere);
				JOptionPane.showMessageDialog(null,"Transferência reaizada com sucesso!");
				break;

			case 5:
				// JOptionPane.showMessageDialog(null, "Menu");
				JOptionPane.showMessageDialog(null, "Dados da  Conta: " + conta.recuperarDadosParaimpressao());
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Saindo!");
				break;
			}

		} while (opcao != 6);

	}
}
