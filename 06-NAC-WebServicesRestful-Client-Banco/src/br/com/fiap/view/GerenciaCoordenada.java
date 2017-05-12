package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.CoordenadaRepository;
import br.com.fiap.to.CoordenadaTO;

public class GerenciaCoordenada {

	public static void main(String[] args) {
		Scanner tc = new Scanner(System.in);
		int resp = 0;
		CoordenadaRepository rep = new CoordenadaRepository();
		CoordenadaTO coordenada;
		
		do{
			
			
			System.out.println("1 - Cadastrar Coordenada \n"
							 + "2 - Listar todas Coordenadas \n"
							 + "3 - Buscar Coordenada \n"
							 + "4 - Atualizar Coordenda \n"
							 + "5 - Remover Coordenada \n"
							 + "0 - Para Encerrar");
			System.out.println("O que deseja fazer?\n");
			resp = tc.nextInt();
			
			if(resp == 1){
				
				coordenada = new CoordenadaTO();
				System.out.print("Digite a Latitute: ");
				coordenada.setLatitude(tc.nextDouble());
				System.out.print("Digite a Longitude: ");
				coordenada.setLongitude(tc.nextDouble());
				System.out.print("Digite o Nome do Local: ");
				coordenada.setNomeLocal(tc.next() + tc.nextLine());
				System.out.print("Digite a Descrição: ");
				coordenada.setDescricao(tc.next() + tc.nextLine());
				
				try {
					rep.cadastrar(coordenada);
				} catch (WebServiceException e) {
					e.printStackTrace();
				}
				
			}else
				if(resp == 2){
					try {
						List<CoordenadaTO> lista = rep.listar();
						System.out.println("\n**********************************\n");
						for (CoordenadaTO c : lista) {
							
							System.out.println("Nome do Local: " + c.getNomeLocal() +
												"\nDescrição: " + c.getDescricao() +
												"\nLatitude: " + c.getLatitude() + "°" +
												"\nLongitude: " + c.getLongitude() + "°");
							System.out.println("\n**********************************\n");
							
						}
					} catch (WebServiceException e) {
						e.printStackTrace();
					}
					
				}else
					if(resp == 3){
						System.out.print("Digite o código que deseja buscar: ");
						try {
							coordenada = rep.buscar(tc.nextInt());
							
							System.out.println("Nome do Local: " + coordenada.getNomeLocal() +
									"Descrição: " + coordenada.getDescricao() +
									"Latitude: " + coordenada.getLatitude() + "°" +
									"Longitude: " + coordenada.getLongitude() + "°");
						} catch (WebServiceException e) {
							e.printStackTrace();
						}
						
					}else
						if(resp == 4){
							System.out.print("Digite o código da Coordenada a ser atualizada: ");
							
							try {
								coordenada = rep.buscar(tc.nextInt());
								
								System.out.print("Digite a Latitute: ");
								coordenada.setLatitude(tc.nextDouble());
								System.out.print("Digite a Longitude: ");
								coordenada.setLongitude(tc.nextDouble());
								System.out.print("Digite o Nome do Local: ");
								coordenada.setNomeLocal(tc.nextLine());
								System.out.print("Digite a Descrição: ");
								coordenada.setDescricao(tc.nextLine());
								
								rep.atualizar(coordenada);
							} catch (WebServiceException e) {
								e.printStackTrace();
							}
							
						}else
							if(resp ==5){
								try {
									System.out.println("Digite o código da coordenada a ser excluída");
									rep.remover(tc.nextInt());
								} catch (WebServiceException e) {
									e.printStackTrace();
								}
							}
			
			
		}while(resp != 0);

	}

}
