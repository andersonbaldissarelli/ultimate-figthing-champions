package DAO;
import java.*;

import java.sql.*;
import org.apache.log4j.Logger;
import main.main;

public class Conexao {
	
	    private String host;
	    private String usuario;
	    private String senha;
	    private String banco;
	    
	    static final Logger logger = Logger.getLogger(main.class);

	    //construtor 
	    public Conexao() {
	        this.banco = "127.0.0.1";
            this.host = "ufc";
	        this.usuario = "root";
	        this.senha = "root";
	    }

	    public Connection getConexao() {
	    	try {
	    		String url = "jdbc:mysql://localhost:3306/"+ this.host+"?autoReconnect=true&useSSL=false";
	    		return DriverManager.
	    	    getConnection(url, usuario, senha);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            logger.warn("Erro SQL Exception");
	        }
	        return null;
	    }

}
