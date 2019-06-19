package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numQuarto, Date dataEntrada, Date dataSaida) {
		this.numQuarto = numQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao () {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public String updateDatas(Date dataEntrada, Date dataSaida) {
		
		Date agora = new Date();
		
		if (dataEntrada.before(agora) || dataSaida.before(agora)) {
			return "ERRO NA RESERVA: As datas de reserva para atualização devem ser datas futuras!!!";
		}
		
		if (!dataSaida.after(dataEntrada)) {
			return "ERRO NA RESERVA: A data de saida tem que ser posterior a data de entrada!!!";
		}
		
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;	
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			   + numQuarto
			   + ", Data de entrada: "
			   + sdf.format(dataEntrada)
			   + ", Data de saída: "
			   + sdf.format(dataSaida)
			   + ", "
			   + duracao()
			   + " noites.";
	}
	
}
