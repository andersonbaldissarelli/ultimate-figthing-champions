package util;

//usada preencher tabela vencedor
public class ArmazenaPontos {
	
	String idluta;
	String vencedor;
	int Pontos;
	String adversario;
	int Pontos2;
	int ano;

	public String getIdluta() {
		return idluta;
	}
	public void setIdluta(String idluta) {
		this.idluta = idluta;
	}
	public String getAdversario() {
		return adversario;
	}
	public void setAdversario(String adversario) {
		this.adversario = adversario;
	}
	
	public int getPontos() {
		return Pontos;
	}
	public void setPontos(int pontos) {
		Pontos = pontos;
	}
	public int getPontos2() {
		return Pontos2;
	}
	public void setPontos2(int pontos2) {
		Pontos2 = pontos2;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getVencedor() {
		return vencedor;
	}
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	
	public ArmazenaPontos Winner(String nome, int pontos1, String nome2, int pontos2) {
	
		if(pontos1>pontos2) {
			ArmazenaPontos ap = new ArmazenaPontos();
			ap.setVencedor(nome);
			ap.setPontos(pontos1);
			ap.setAdversario(nome2);
			ap.setPontos2(pontos2);
			return ap;
		}
		else {
			ArmazenaPontos ap = new ArmazenaPontos();
			ap.setVencedor(nome2);
			ap.setPontos(pontos2);
			ap.setAdversario(nome);
			ap.setPontos2(pontos1);
			return ap;
		}
	}
}
