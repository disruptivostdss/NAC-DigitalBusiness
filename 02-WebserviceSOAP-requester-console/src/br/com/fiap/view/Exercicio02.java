package br.com.fiap.view;

import javax.swing.JOptionPane;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CoordenadaBOStub;
import br.com.fiap.bo.CoordenadaBOStub.Cadastrar;
import br.com.fiap.bo.CoordenadaBOStub.Coordenada;
import br.com.fiap.bo.CoordenadaBOStub.FindById;
import br.com.fiap.bo.CoordenadaBOStub.FindByIdResponse;
import br.com.fiap.bo.CoordenadaBOStub.Listar;

public class Exercicio02 {
	
	public static void main(String[] args) throws Exception {
		
		CoordenadaBOStub bo;

		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:" 
				+ "\n 01 - Cadastrar"
				+ "\n 02 - Buscar"
				+ "\n 03 - Listar Todos"));
		
		if(opcao == 1){
			while(JOptionPane.showConfirmDialog(null, "Deseja cadastrar coordenada?","Coordenada",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0){
				try {
					bo = new CoordenadaBOStub();
					
					Coordenada param = new Coordenada();
					param.setLatidude(Double.parseDouble(JOptionPane.showInputDialog("Digite a latitude: ")));
					param.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Digite a longitude: ")));
					param.setNomeLocal(JOptionPane.showInputDialog("Digite o nome do local"));
					
					Cadastrar obj = new Cadastrar();
					obj.setC(param);
					
					bo.cadastrar(obj);
					
				} catch (AxisFault e) {
					e.printStackTrace();
				}
			}
		}else if(opcao == 2){
			int codigo =Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
			
			bo = new CoordenadaBOStub();
			
			FindById param = new FindById();
			param.setId(codigo);
			
			FindByIdResponse response = bo.findById(param);
			
			Coordenada c = response.get_return();
			
			System.out.println("Código: " + c.getCodigo());
			System.out.println("Latitude: " + c.getLatidude());
			System.out.println("Longitude: " + c.getLongitude());
			System.out.println("Nome do local: " + c.getNomeLocal());
			
		}else if(opcao == 3){
			
			bo = new CoordenadaBOStub();
			
			Listar l = new Listar();
			
			Coordenada[] coordenadas = bo.listar(l).get_return();
			
			for (Coordenada c : coordenadas) {
				System.out.println("----------------------------------");
				System.out.println("Código: " + c.getCodigo());
				System.out.println("Latitude: " + c.getLatidude());
				System.out.println("Longitude: " + c.getLongitude());
				System.out.println("Nome do local: " + c.getNomeLocal());
			}
		}else{
			System.out.println("Código inválido");
		}
		
	}

}
