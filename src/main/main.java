package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import DAO.Conexao;
import util.Dados;

/**
 * Date: June 13-2019
 * @author Anderson Felipe Baldissarelli
 * @version 2.0
 * link git: https://github.com/andersonbaldissarelli
 */

public class main {
	
	/**
	*Log4j é usado para gerar log de dados da aplicação.
	*@param logger
	*/
	
	static final Logger logger = Logger.getLogger(main.class);
	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		*Usado para dividir os processos, ou seja,
		*para que dois processos possam ser executados
		*simultaneamente
		*@param thread
		*/
		
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
