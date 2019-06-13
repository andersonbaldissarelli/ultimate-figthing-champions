package util;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import DAO.ArmazenaPontosDAO;
import main.main;

public class Fight {
	
	static final Logger logger = Logger.getLogger(main.class);
	
	/**
	* Objetos:
	* @param ap Cria um objeto do tipo ArmazenaPontos que � utilizado para armazenar os dados do vencedor e perdedor da luta com seus respecitivos pontos
	* @param pontos1 armazena os pontos do lutador 1 
	* @param pontos2 armazena os pontos do lutador 2
	* @param resultado armazena o retorno da fun��o win que fornece os dados para preencher o objeto ap
	* @param APdao Objeto usado para acessar chamar o m�todo de acessar o banco de dados para guardar os resultados das lutas
	* @param lutador1 ArrayList para armazenar os movimentos do lutador 1
	* @param lutador2 ArrayList para armazenar os movimentos do lutador 1
	*/
	ArmazenaPontos ap = new ArmazenaPontos();
	int pontos1, pontos2;
	ArmazenaPontos resultado = new ArmazenaPontos();
	ArmazenaPontosDAO APdao = new ArmazenaPontosDAO();
	ArrayList<FightScope> lutador1 = new ArrayList<FightScope>();
	ArrayList<FightScope> lutador2 = new ArrayList<FightScope>();
	
	/**
	* M�todo:
	* {@link Win() } 
	* @param i contador
	* @param valor Usado para receber o valor da convers�o da String modalidade em n�mero
	* @param valor2 Usado para receber o valor da convers�o da segunda String modalidade em n�mero
	* @param APdao Objeto usado para acessar chamar o m�todo de acessar o banco de dados para guardar os resultados das lutas
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



/*public int lutandoauto(Player play, Cpu cpu) {
	int i;
	play.setHp(100);//restaura o hp do player antes pra pr�xima luta
	for(i=0;i<1000;i++) {
		if(play.getHp()==0) {
			i=1000;
			return 1;
		}
		else if(cpu.getHp()==0) {
			i=1000;
			return 0;
		}
		
		
		else {
			
	if(playacoes.acoes.get(i).ataque == 1 && cpuacoes.acoes.get(i).ataque==1){
		if(playacoes.acoes.get(i).soco == 1 && cpuacoes.acoes.get(i).soco==1) {
			if(play.getPoints()>cpu.getPoints()) {
				cpu.setHp((cpu.getHp()-1));
				play.setPoints(play.getPoints()+10);
				System.out.print("Os 2 jogadores deram o mesmo Golpe! Incrivel luta, mas o soco do jogador foi mais forte!\n");
			}
			else if(play.getPoints()<cpu.getPoints()) {
				play.setHp((play.getHp()-1));
				System.out.print("Os 2 jogadores deram o mesmo Golpe! Incrivel luta, mas o soco da cpu foi mais forte!\n");
			}
			
		}
		else if(playacoes.acoes.get(i).chute == 1 && cpuacoes.acoes.get(i).chute==1) {
			if(play.getPoints()>cpu.getPoints()) {
				cpu.setHp((cpu.getHp()-1));
				play.setPoints(play.getPoints()+10);
				System.out.print("Os 2 jogadores deram o mesmo Golpe! Incrivel luta, mas o chute do jogador foi mais forte!\n");
			}
			else if(play.getPoints()<cpu.getPoints()) {
				play.setHp((play.getHp()-1));
				System.out.print("Os 2 jogadores deram o mesmo Golpe! Incrivel luta, mas o chute da cpu foi mais forte!\n");
			}
			
		}
		else if(playacoes.acoes.get(i).soco == 1 && cpuacoes.acoes.get(i).chute==1) {
			//play perde hp
			play.setHp((play.getHp()-1));
			System.out.print("A cpu encaixou muito bem esse chute, enquanto o jogador tentava dar um cruzado\n");
			
		}
		else if(playacoes.acoes.get(i).chute == 1 && cpuacoes.acoes.get(i).soco== 1) {
			//cpu perde hp
			cpu.setHp((cpu.getHp()-1));
			play.setPoints(play.getPoints()+10);
			System.out.print("O jogador encaixou muito bem esse chute, enquanto a cpu tentava dar um gancho\n");
			
		}
		else if(playacoes.acoes.get(i).poder==1 && cpuacoes.acoes.get(i).soco==1 || playacoes.acoes.get(i).poder==1 && cpuacoes.acoes.get(i).chute==1){
				//cpu perder hp
				cpu.setHp((cpu.getHp()-1));
				play.setPoints(play.getPoints()+30);
				
		}
		else if(playacoes.acoes.get(i).soco == 1 && cpuacoes.acoes.get(i).poder==1 || playacoes.acoes.get(i).chute==1 && cpuacoes.acoes.get(i).poder==1){
				//play perde hp
				play.setHp((play.getHp()-1));
				
		}
		else if(playacoes.acoes.get(i).poder == 1 && cpuacoes.acoes.get(i).poder==1) {
			if(play.getPoints()>cpu.getPoints()) {
				cpu.setHp((cpu.getHp()-1));
				play.setPoints(play.getPoints()+30);
			}
			else if(play.getPoints()<cpu.getPoints()) {
				play.setHp((play.getHp()-1));
				
			}
			else {
				//empate ninguem perde ponto
			}
		}
	}
	else if(playacoes.acoes.get(i).defesa == 1 && cpuacoes.acoes.get(i).ataque==1) {
		cpu.setHp(cpu.getHp());
		// ninguem perde ponto
		System.out.print("Que defesa meus amigos. Que defesa. A cpu veio com tudo, mas nao foi suficiente para acertar o jogador\n");
		
	}
	else if(playacoes.acoes.get(i).ataque == 1 && cpuacoes.acoes.get(i).defesa==1) {
		cpu.setHp(cpu.getHp());
		// ninguem perde ponto
		System.out.print("Olha essa defesa! Apenas uma maquina defenderia um ataque desses. O jogador vai ter que atacar com tudo\n");
		
	}
	else{
		cpu.setHp(cpu.getHp());
		System.out.print("Ambos estao na defensiva, nessa hora era melhor assistir o filme do Pele\n");
		// defesa vs defesa
		}
	}
}
return 999;
	
} */