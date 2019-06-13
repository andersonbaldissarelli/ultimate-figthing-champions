package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import main.main;
import util.Fighter;



public class FighterDAO {

	static final Logger logger = Logger.getLogger(main.class);

	public ArrayList<Fighter> selecionarTodos(){
		ArrayList<Fighter> ArraYFighters = new ArrayList<Fighter>();
		try{
		Connection conexao = new Conexao().getConexao();
		
		ResultSet result = conexao.prepareStatement("select * from fighter;").executeQuery();
		logger.info("Seleciona informacoes da tabela fighter no banco de dados");
		
		Fighter Fighter;
		while (result.next()) {
			Fighter= new Fighter();
			Fighter.setNome( result.getString("Nome"));
		    Fighter.setCategoria(result.getString("categoria"));
		    Fighter.setPais(result.getString("pais"));
		    Fighter.setSexo(result.getString("sexo"));
		    
		    ArraYFighters.add(Fighter);
		}
		conexao.close();
		}catch( SQLException e){
			e.printStackTrace();
		}
		return ArraYFighters;
	}
	
	public Fighter selecionar(Fighter lp){
		Fighter Fighter=new Fighter();
		try{
			Connection conexao = new Conexao().getConexao();
			ResultSet result = conexao.prepareStatement("Select * from fighter where nome="+lp.getNome()+"'%").executeQuery();
			
			while(result.next()){
			Fighter.setNome( result.getString("nome"));
			Fighter.setCategoria(result.getString("categoria"));
			Fighter.setPais(result.getString("pais"));
			Fighter.setSexo(result.getString("sexo"));
			}
			    conexao.close();
			}catch( SQLException e){
				e.printStackTrace();
			}
			
		return Fighter;
	}
	public boolean inserir(Fighter Fighter){
	 int valor=0;
		try{
			Connection conexao = new Conexao().getConexao();
	        
			PreparedStatement result = conexao.prepareStatement("insert into Fighter (nome, categoria, pais, sexo) values (?,?,?,?);" );
			
			result.setString(1, Fighter.getNome());
			result.setString(2, Fighter.getCategoria());
			result.setString(3, Fighter.getPais());
			result.setString(4, Fighter.getSexo());
			valor =result.executeUpdate();    
			conexao.close();
			    
			}catch( SQLException e){
				e.printStackTrace();
			}
        if(valor==1 )
        	return true;
        else 
        	return false;
	
	}
	
   public void deletar(Fighter a){
	try{
		Connection conexao = new Conexao().getConexao();
		PreparedStatement result= conexao.prepareStatement("DELETE FROM Fighter WHERE Nome = ?;");
	
        result .setString(1,a.getNome());
        result.executeUpdate();
        conexao.close();
	    }catch(Exception e){
			
		}
    	
	}
public boolean update(Fighter a){
	int valor =0;
	try{
	Connection conexao = new Conexao().getConexao();
    PreparedStatement result= 
    conexao.prepareStatement(
   "UPDATE Fighter SET pais = ?, categoria =?, sexo=? WHERE Nome = ?");

    result .setString(1, a.getNome());
    result.setString(2, a.getCategoria());
    result.setString(3, a.getPais());
    result.setString(4, a.getSexo());
    
    valor =result.executeUpdate();
    conexao.close();
	}catch(Exception e){
		
	}
    
    if(valor==1 )
    	return true;
    else 
    	return false;
    	
}

}
