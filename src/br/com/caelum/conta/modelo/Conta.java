package br.com.caelum.conta.modelo;

//import java.lang.Object;
//import java.lang.Number;
//import java.lang.Math;

public class Conta {

	private String agencia;
	private Data dataDeAbertura;
	private String titular;
	private long numero;
	private double saldo;
	private double rendimento;
	// private double valor;
	private static int totalDeContas;
	// private PessoaFisica pf;

	// método construtor
	//public class BigInteger extends Number
	



	public Conta(String titular, String agencia, int numero,Data data) {

		this.setTitular(titular);
		this.setAgencia(agencia);
		this.setDataDeAbertura(data);
		this.setNumero(numero);

		Conta.totalDeContas = Conta.totalDeContas + 1;

	}

	public int getTotalDeContas() {
		return Conta.totalDeContas;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public long getNumero() {
		return this.numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public Data getDataDeAbertura() {
		return this.dataDeAbertura;
	}

	public void setDataDeAbertura(Data DataDeAbertura) {
		this.dataDeAbertura = DataDeAbertura;
	}

	// método transfere para
	public boolean transferePara(Conta destino, double valor) {
		boolean retirou = this.saca(valor);
		if (retirou == false) {
			return false;
		} else {
			destino.deposita(valor);
			return true;
		}
	}

	// método sacar
	public boolean saca(double valor) {
		if (this.saldo < valor) {
			return false;
		} else {
			this.saldo = this.saldo - valor;
			return true;

		}
	}

	// método depositar
	public void deposita(double quantidade) {
		this.saldo += quantidade;
	}

	// Método calcula rendimento

	public void calculaRendimentos() {

		double rendimento = 0.1 * this.saldo;
		this.rendimento = rendimento + this.rendimento;
		// return rendimento;

	}

	// Métodos recupera Dados para impressão

	public String recuperarDadosParaimpressao() {
		String dados = "\nTitular:" + this.titular;
		dados += "\nNúmero: " + this.numero;
		dados += "\nAgência: " + this.agencia;
		dados += "\nSaldo: " + this.saldo;
		dados += "\nRendimento:" + this.rendimento;
		dados += "\nData de abertura: " + this.dataDeAbertura.formataData();
		return dados;

	}

}// fim
