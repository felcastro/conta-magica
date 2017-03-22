package app;

import java.math.BigDecimal;

public interface IContaMagica {
	public String getNomeCliente();

	public BigDecimal getSaldo();

	public Categorias getStatus();

	public void deposito(BigDecimal valor);

	public void retirada(BigDecimal valor);
}
