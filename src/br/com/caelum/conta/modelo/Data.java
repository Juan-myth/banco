package br.com.caelum.conta.modelo;
public class Data {
	private int dia;
	private int mes;
	private int ano;

	// Método

	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String formataData() {
		return this.dia + "/" + this.mes + "/" + this.ano;

	}

	void preencheData(int dia, int mes, int ano) {
		if (!(isDataViavel(dia, mes, ano))) {
			System.out.println("A data " + dia + "/" + mes + "/" + ano + "não existe!");
		} else {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}

	}

	public boolean isDataViavel(int dia, int mes, int ano) {
		if (dia <= 0 || ano <= 0 || mes <= 0) {
			return false;
		}

		int ultimoDiaMes = 31; // por padrão

		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			ultimoDiaMes = 30;
		} else if (mes == 2) {
			if (ano % 4 == 0) {
				ultimoDiaMes = 29;
			} else {
				ultimoDiaMes = 28;
			}

		}
		if (dia > ultimoDiaMes) {
			return false;
		}

		return true;
	}
}
