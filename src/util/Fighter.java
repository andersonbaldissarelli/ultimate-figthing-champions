package util;

public class Fighter {

	 /**
	 * Classe Fighter
	 * Usada para armazenar dados dos lutadores
	 */
		//classe POJO

			private String Nome;
			private String categoria;
			private String pais;
			private String sexo;
			
			
			public String getSexo() {
				return sexo;
			}
			public void setSexo(String sexo) {
				this.sexo = sexo;
			}
			public String getPais() {
				return pais;
			}
			public void setPais(String pais) {
				this.pais = pais;
			}
			public String getNome() {
				return Nome;
			}
			public void setNome(String nome) {
				this.Nome = nome;
			}
			public String getCategoria() {
				return categoria;
			}
			public void setCategoria(String categoria) {
				this.categoria = categoria;
			}
				
}
