package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecao.ExcecaoDeDominio;

public class ProgPrincipal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		// PARTE I - RESERVA
		System.out.print("Entre com numero do Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Entre com  Data de entrada (dd/MM/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Entre com  Data de saída (dd/MM/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());		
		Reserva reserva = new Reserva(numQuarto, dataEntrada, dataSaida);
		System.out.println("Reserva: " + reserva);
		
		//PARTE II - ATUALIZAÇÃO DA RESERVA
		
		System.out.println();
		System.out.println("Entre com as datas para atualizar a reserva:");
		System.out.print("Entre com  Data de entrada (dd/MM/yyyy): ");
		dataEntrada = sdf.parse(sc.next());
		System.out.print("Entre com  Data de saída (dd/MM/yyyy): ");
		dataSaida = sdf.parse(sc.next());
		reserva.updateDatas(dataEntrada, dataSaida);
		System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e){
			System.out.println("Data com formato invalido!!!");
		}
		catch (ExcecaoDeDominio e) {
			System.out.println("ERRO NA RESERVA: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!!!");
		}
		
		
		sc.close();
		
	}

}
