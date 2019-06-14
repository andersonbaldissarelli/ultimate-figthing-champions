package util;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import DAO.ArmazenaPontosDAO;
import main.main;

/**
	*Classe Fight possui as regras da luta para definir os pontos dos lutadores comparando suas ações
	* 
	* @param ap Cria um objeto do tipo ArmazenaPontos que é utilizado para armazenar os dados do vencedor e perdedor da luta com seus respecitivos pontos
	* @param resultado é usado para receber o retorno da função do tipo ArmazenaPontos que retorna os dados do vencedor e perdedor
	* @param APdao Usado para inserir os valores no banco de dados na tabela vencedor
	* @param lutador1 Arraylist do tipo FightScope que armazena os dados da luta do jogador 1
	* @param lutador2 Arraylist do tipo FightScope que armazena os dados da luta do jogador 2
	* @param valor1 armazena os pontos do lutador 1 
	* @param valor2 armazena os pontos do lutador 2
	*/

public class Fight {
	
	static final Logger logger = Logger.getLogger(main.class);
	
	ArmazenaPontos ap = new ArmazenaPontos();
	int pontos1, pontos2;
	ArmazenaPontos resultado = new ArmazenaPontos();
	ArmazenaPontosDAO APdao = new ArmazenaPontosDAO();
	ArrayList<FightScope> lutador1 = new ArrayList<FightScope>();
	ArrayList<FightScope> lutador2 = new ArrayList<FightScope>();
	
	/**
	* Win Método que possui as regras de luta para definir qual lutador faz mais pontos
	* 
	* @param i contador
	* @param valor Usado para receber o valor da conversão da String modalidade em número
	* @param valor2 Usado para receber o valor da conversão da segunda String modalidade em número
	* @param APdao Objeto usado para acessar chamar o método de acessar o banco de dados para guardar os resultados das lutas
	* @param lutador1 ArrayList para armazenar os movimentos do lutador 1
	* @param lutador2 ArrayList para armazenar os movimentos do lutador 1
	*/
	
	public void Win(ArrayList <FightScope> lutador1,ArrayList <FightScope>lutador2) {

		int i=0;
		int valor, valor2;

		for(i=0; i<lutador1.size() ; i++) {
			System.out.println("ataque lutador 1"+lutador1.get(i).soco);
			if(lutador1.get(i).ataque == "1" && lutador2.get(i).ataque== "1") {
				if(lutador1.get(i).soco == "1" && lutador2.get(i).soco== "1" || lutador1.get(i).chute == "1" && lutador2.get(i).chute== "1") {
					valor = Integer.valueOf(lutador1.get(i).modalidade);
					valor2 = Integer.valueOf(lutador2.get(i).modalidade);
					if(valor>valor2){
						//ap.setPontos(ap.getPontos()+10);
						pontos1=pontos1+10;
					}
					else {
						//ap.setPontos2(ap.getPontos2()+10);
						pontos2=pontos2+10;
					}
				}
				else if(lutador1.get(i).chute == "1" && lutador2.get(i).soco== "1") {
					//ap.setPontos(ap.getPontos()+10);
					pontos1=pontos1+10;
				}
				else if(lutador1.get(i).soco == "1" && lutador2.get(i).chute== "1") {
					//ap.setPontos2(ap.getPontos2()+10);
					pontos2=pontos2+10;
				}
				else if(lutador1.get(i).poder == "1" && lutador2.get(i).soco== "1" || lutador1.get(i).poder == "1" && lutador2.get(i).chute== "1") {
					//ap.setPontos(ap.getPontos()+30);
					pontos1=pontos1+30;
				}
				else if(lutador1.get(i).soco == "1" && lutador2.get(i).poder== "1" || lutador1.get(i).chute == "1" && lutador2.get(i).poder== "1") {
					//ap.setPontos2(ap.getPontos2()+30);
					pontos2=pontos2+30;
				}
			}
			
			else if(lutador1.get(i).defesa == "1" && lutador2.get(i).defesa== "1"){ 
				//defesa x defesa, nada acontece
			}
	}
			
	resultado = ap.Winner(lutador1.get(0).getLutador(), pontos1, lutador2.get(0).getLutador(), pontos2);
	logger.info("Resultado do vencedor da luta");
	APdao.inserir(resultado);
	//return resultado;
	
}
		
}

