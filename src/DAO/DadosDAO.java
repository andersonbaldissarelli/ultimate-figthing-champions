package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import main.main;
import util.FightScope;
import util.Fighter;
import util.teste;



public class DadosDAO {

	static final Logger logger = Logger.getLogger(main.class);

	public ArrayList<Fighter> selecionarTodos(){
		ArrayList<Fighter> ArraYFighters = new ArrayList<Fighter>();
		try{
		Connection conexao = new Conexao().getConexao();
		
		ResultSet result = conexao.prepareStatement("select * from Fighter;").executeQuery();
		logger.info("Seleciona informacoes da luta");
		
		Fighter Fighter;
		while (result.next()) {
			Fighter= new Fighter();
			Fighter.setNome( result.getString("Nome"));
		    Fighter.setCategoria(result.getString("categoria"));
		    Fighter.setPais(result.getString("pais"));
		    Fighter.setSexo(result.getString("sexo"));
		    
		    ArraYFighters.add(Fighter);
		    logger.info("Adiciona informacoes do array na luta ");
		}
		conexao.close();
		}catch( SQLException e){
			e.printStackTrace();
			logger.warn("Erro SQL Exception");
		}
		return ArraYFighters;
	}
	
	
	public teste selecionar2(teste fs2){
			teste Fighter=new teste();
			try{
				Connection conexao = new Conexao().getConexao();
				ResultSet result = conexao.prepareStatement("select * from lutas where lutador1="+fs2.getLutador() ).executeQuery();
				
				while(result.next()){
					Fighter.setLutador( result.getString("lutador1"));
					Fighter.setCategoria(result.getString("categoria"));
					Fighter.setDefesa(result.getString("defesa"));
					Fighter.setAtaque(result.getString("ataque"));
					Fighter.setSoco(result.getString("soco"));
					Fighter.setChute(result.getString("chute"));
					Fighter.setPoder(result.getString("poder"));
					Fighter.setModalidade(result.getString("modalidade"));
					Fighter.setLutador( result.getString("lutador2"));
					Fighter.setCategoria(result.getString("categoria2"));
					Fighter.setDefesa(result.getString("defesa2"));
					Fighter.setAtaque(result.getString("ataque2"));
					Fighter.setSoco(result.getString("soco2"));
					Fighter.setChute(result.getString("chute2"));
					Fighter.setPoder(result.getString("poder2"));
					Fighter.setModalidade(result.getString("modalidade2"));
					System.out.println(Fighter.getLutador());
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
	        
			PreparedStatement result = conexao.prepareStatement("insert into Fighter (Nome, categoria, pais, sexo) values (?,?,?,?);" );
			
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

	//FUNCIONA FUNCIONA
	public boolean inserir2(FightScope Fighter, FightScope Fight){
		 int valor=0;
			try{
				Connection conexao = new Conexao().getConexao();
		        
				PreparedStatement result = conexao.prepareStatement("insert into lutas (idluta, lutador1, categoria, defesa, ataque, soco, chute, poder,modalidade, lutador2, categoria2, defesa2, ataque2, soco2, chute2, poder2,modalidade2 ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);" );
				
				result.setString(1, Fighter.getIdluta());
				result.setString(2, Fighter.getLutador());
				result.setString(3, Fighter.getCategoria());
				result.setString(4, Fighter.getDefesa());
				result.setString(5, Fighter.getAtaque());
				result.setString(6, Fighter.getSoco());
				result.setString(7, Fighter.getChute());
				result.setString(8, Fighter.getPoder());
				result.setString(9, Fighter.getModalidade());
				result.setString(10, Fight.getLutador());
				result.setString(11, Fight.getCategoria());
				result.setString(12, Fight.getDefesa());
				result.setString(13, Fight.getAtaque());
				result.setString(14, Fight.getSoco());
				result.setString(15, Fight.getChute());
				result.setString(16, Fight.getPoder());
				result.setString(17, Fight.getModalidade());
				
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
