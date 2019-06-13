package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import DAO.Conexao;
import util.Dados;

public class main {
	
	static final Logger logger = Logger.getLogger(main.class);
	
	public static void main(String[] args) throws InterruptedException {
		new Thread();
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Iniciando a conexao com o banco de dados");
		
		System.out.println("###### ULTIMATE FIGHTING CHAMPIONSHIP #####");
		Thread.sleep(1000L);
	
		Conexao con = new Conexao();
		con.getConexao();
		Dados d = new Dados();
		d.inicia();	
	}
}
