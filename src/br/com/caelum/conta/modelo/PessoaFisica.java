package br.com.caelum.conta.modelo;
public class PessoaFisica {

	public boolean validarCPF(String cpf) {
		// Remover caracteres especiais e espaços em branco
		cpf = cpf.replaceAll("[^0-9]", "");

		// Verificar se o CPF possui 11 dígitos
		if (cpf.length() != 11)
			return false;

		// Verificar se todos os dígitos são iguais, o que invalidaria o CPF
		if (cpf.matches("(\\d)\\1{10}"))
			return false;

		// Calcular e verificar os dígitos verificadores
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}

		// Verificar o primeiro dígito verificador
		int digito1 = 11 - (soma % 11);
		if (digito1 > 9) {
			digito1 = 0;
		}

		if (Character.getNumericValue(cpf.charAt(9)) != digito1) {
			return false;
		}

		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}
		int digito2 = 11 - (soma % 11);
		if (digito2 > 9) {
			digito2 = 0;
		}

		// Verificar o segundo dígito verificador
		if (Character.getNumericValue(cpf.charAt(10)) != digito2) {
			return false;
		}
		// se todas as verificações passaram, o cpf é válido.
		return true;

	}
}