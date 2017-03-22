package app;

import java.math.BigDecimal;

public class ContaMagica {

	public String nome;
	public BigDecimal saldo;
	public Categorias status;

	public ContaMagica(String nome) {
		this.nome = nome;
		this.status = Categorias.SILVER;
		this.saldo = new BigDecimal("0.00");
		;
	}

	public String getNomeCliente() {
		return nome;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Categorias getStatus() {
		return status;
	}

	public void deposito(BigDecimal valor) {
		switch (status) {
		case SILVER:
			saldo.add(valor);
			if(saldo.compareTo(new BigDecimal("50000.00")) == 1){
				status = Categorias.GOLD;
			}
			break;
		case GOLD:
			saldo.add(valor.add(valor.multiply(new BigDecimal("0.01"))));
			if(saldo.compareTo(new BigDecimal("200000.00")) == 1){
				status = Categorias.GOLD;
			}
			break;
		case PLATINUM:
			saldo.add(valor.add(valor.multiply(new BigDecimal("0.025"))));
			break;
		default:
			break;
		}
	}

	public void retirada(BigDecimal valor) {
		switch (status) {
		case SILVER:
			saldo.subtract(valor);
			break;
		case GOLD:
			saldo.subtract(valor);
			if(saldo.compareTo(new BigDecimal("25000.00")) == -1){
				status = Categorias.SILVER;
			}
			break;
		case PLATINUM:
			saldo.subtract(valor);
			if(saldo.compareTo(new BigDecimal("100000.00")) == -1){
				status = Categorias.SILVER;
			}
			break;
		default:
			break;
		}
	}
}