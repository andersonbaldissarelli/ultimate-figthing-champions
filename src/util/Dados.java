package util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import DAO.DadosDAO;
import DAO.FighterDAO;
import main.main;
 
public class Dados {
		
	static final Logger logger = Logger.getLogger(main.class);
		
	  public void inicia() {
		  
	  FighterDAO fDAO = new FighterDAO();
	  DadosDAO dao = new DadosDAO();
	  Fighter fit = new Fighter();
	  Fighter fit2 = new Fighter();
	  ArrayList<FightScope> fitarray = new ArrayList<FightScope>();
	  ArrayList<FightScope> fit2array = new ArrayList<FightScope>();
	  FightScope fs = new FightScope();
	  FightScope fs2 = new FightScope();
	  Fight f = new Fight();
	
	  
	  int cont=0, cont2=0;

	  System.out.printf("\nConte�do do arquivo texto:\n");
    try {
      FileReader arq = new FileReader("C:/Users/Harry/Desktop/liga2013.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); 
      logger.info("Le as linhas do arquivo");
      
      // l� a primeira linha
// a vari�vel "linha" recebe o valor "null" quando o processo
// de repeti��o atingir o final do arquivo texto
      String parts[] = linha.split(";");
      
      if(cont==0) { //armazenar os 2 lutadores
    	   fit.setNome(parts[3]);
    	   fit.setCategoria(parts[4]);
    	   fit.setPais(parts[5]);
    	   fit.setSexo(parts[6]);
    	   fit2.setNome(parts[13]);
    	   fit2.setCategoria(parts[14]);
    	   fit2.setPais(parts[15]);
    	   fit2.setSexo(parts[16]);
    	   fDAO.inserir(fit);
    	   fDAO.inserir(fit2);
    	   
    	  fs.setIdluta(parts[2]);
 	      fs.setLutador(parts[3]);
 	      fs.setCategoria(parts[4]);
 	      fs.setDefesa(parts[7]);
 	      fs.setAtaque(parts[8]);
 	      fs.setSoco(parts[9]);
 	      fs.setChute(parts[10]);
 	      fs.setPoder(parts[11]);
 	      fs.setModalidade(parts[12]);
 	      fitarray.add(fs);
 	      //fit2array
 	      fs2.setLutador(parts[13]);
 	      fs2.setCategoria(parts[14]);
 	      fs2.setDefesa(parts[17]);
 	      fs2.setAtaque(parts[18]);
 	      fs2.setSoco(parts[19]);
 	      fs2.setChute(parts[20]);
 	      fs2.setPoder(parts[21]);
 	      fs2.setModalidade(parts[22]);
    	   dao.inserir2(fs, fs2);
    	   cont++;
      }
     /* for (String part : parts) {
          System.out.println(part);
      }*/

      
      while (linha != null) {
    	  
    	  String linha1 = lerArq.readLine(); 
    	  logger.info("Le as linha do arquivo");
    	  
    	  // l� a primeira linha
    	// a vari�vel "linha" recebe o valor "null" quando o processo
    	// de repeti��o atingir o final do arquivo texto
    	  String parts1[] = linha1.split(";");

    	      fs.setIdluta(parts1[2]);
    	      fs.setLutador(parts1[3]);
    	      fs.setCategoria(parts1[4]);
    	      fs.setDefesa(parts1[7]);
    	      fs.setAtaque(parts1[8]);
    	      fs.setSoco(parts1[9]);
    	      fs.setChute(parts1[10]);
    	      fs.setPoder(parts1[11]);
    	      fs.setModalidade(parts1[12]);
    	      fitarray.add(fs);
    	      //fit2array
    	      fs2.setLutador(parts1[13]);
    	      fs2.setCategoria(parts1[14]);
    	      fs2.setDefesa(parts1[17]);
    	      fs2.setAtaque(parts1[18]);
    	      fs2.setSoco(parts1[19]);
    	      fs2.setChute(parts1[20]);
    	      fs2.setPoder(parts1[21]);
    	      fs2.setModalidade(parts1[22]);
    	      fit2array.add(fs2);
    	      dao.inserir2(fs, fs2);
    	         
    	        	  
    	        	  // funcao pra testar quem ganhou a luta e lan�ar no bd
    	      
    	    			cont++;
    	    	     if(cont==19) {
    	    	    	 f.Win(fitarray,fit2array);
    	    	    	 fitarray.clear();
    	    	    	 fit2array.clear();
    	    	     }
    	    	     else if(cont>19) {
    	    	    	 
    	    	    	 cont2++;
    	    	    	 if(cont2==1) {
    	    	    	   fit.setNome(parts1[3]);
    	    	      	   fit.setCategoria(parts1[4]);
    	    	      	   fit.setPais(parts1[5]);
    	    	      	   fit.setSexo(parts1[6]);
    	    	      	   fit2.setNome(parts1[13]);
    	    	      	   fit2.setCategoria(parts1[14]);
    	    	      	   fit2.setPais(parts1[15]);
    	    	      	   fit2.setSexo(parts1[16]);
    	    	      	   fDAO.inserir(fit);
    	    	      	   fDAO.inserir(fit2);
    	    	    	 }
    	    	    	 else if(cont2==20) {
    	    	    		 f.Win(fitarray,fit2array);
        	    	    	 fitarray.clear();
        	    	    	 fit2array.clear();
        	    	    	 cont2=0;
    	    	    	 }
    	    	     }
    	    	    	 
      }
      
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        logger.warn("Erro na abertura do arquivo");
    }
 
  }
}