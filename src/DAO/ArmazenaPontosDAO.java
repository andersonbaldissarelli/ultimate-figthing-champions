package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import main.main;
import util.ArmazenaPontos;



public class ArmazenaPontosDAO {
	
	static final Logger logger = Logger.getLogger(main.class);

	public ArrayList<ArmazenaPontos> selecionarTodos(){
		ArrayList<ArmazenaPontos> ArraYArmazenaPontoss = new ArrayList<ArmazenaPontos>();
		try{
		Connection conexao = new Conexao().getConexao();
		
		ResultSet result = conexao.prepareStatement("select * from vencedor;").executeQuery();
		logger.info("Seleciona informacoes do vencedor");
		
		ArmazenaPontos ArmazenaPontos;
		while (result.next()) {
			ArmazenaPontos= new ArmazenaPontos();
			ArmazenaPontos.setIdluta( result.getString("idluta"));
		    ArmazenaPontos.setVencedor(result.getString("vencedor"));
		    ArmazenaPontos.setPontos( result.getInt("vencedorpts"));
		    ArmazenaPontos.setAdversario( result.getString("adversario"));
		    ArmazenaPontos.setPontos2( result.getInt("aversariopts"));
		    ArmazenaPontos.setAno( result.getInt("ano"));

		    
		    ArraYArmazenaPontoss.add(ArmazenaPontos);
		}
		conexao.close();
		}catch( SQLException e){
			e.printStackTrace();
			logger.warn("Erro SQL Exception");
		}
		return ArraYArmazenaPontoss;
	}
	

	public boolean inserir(ArmazenaPontos ArmazenaPontos){
	 int valor=0;
		try{
			Connection conexao = new Conexao().getConexao();
	        
			PreparedStatement result = conexao.prepareStatement("insert into vencedor (idluta, vencedor, vencedorpts, adversario, adversariopts, ano) values (?,?,?,?,?,?);" );
			
			result.setString(1, ArmazenaPontos.getIdluta());
			result.setString(2, ArmazenaPontos.getVencedor());
			result.setInt(3, ArmazenaPontos.getPontos());
			result.setString(4, ArmazenaPontos.getAdversario());
			result.setInt(5, ArmazenaPontos.getPontos2());
			result.setInt(6, ArmazenaPontos.getAno());
			valor =result.executeUpdate();    
			conexao.close();
			    
			}catch( SQLException e){
				e.printStackTrace();
				logger.warn("Erro SQL Exception");
			}
        if(valor==1 )
        	return true;
        else 
        	return false;
	
	}

}
