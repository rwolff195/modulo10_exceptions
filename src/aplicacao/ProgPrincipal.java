package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class ProgPrincipal {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com numero do Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Entre com  Data de entrada (dd/MM/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Entre com  Data de saída (dd/MM/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());
		
		if (!dataSaida.after(dataEntrada)) {
			System.out.println("ERRO NA RESERVA: A data de saida tem que ser posterior a data de entrada!!!");
		}
		else {
			
			Reserva reserva = new Reserva(numQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
				
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva:");
			System.out.print("Entre com  Data de entrada (dd/MM/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Entre com  Data de saída (dd/MM/yyyy): ");
			dataSaida = sdf.parse(sc.next());
			
			Date agora = new Date();
			
			if (dataEntrada.before(agora) || dataSaida.before(agora)) {
				System.out.println("ERRO NA RESERVA: As datas de reserva para atualização devem ser datas futuras!!!");
			}
			else if (!dataSaida.after(dataEntrada)) {
				System.out.println("ERRO NA RESERVA: A data de saida tem que ser posterior a data de entrada!!!");
			}
			else {
				reserva.updateDatas(dataEntrada, dataSaida);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		sc.close();

	}

}
