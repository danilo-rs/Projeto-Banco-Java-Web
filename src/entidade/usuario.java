package entidadeA;

public class usuario {

}
//==============================
//ATENEU - Projeto Ateneu - 2019
//Professor: Stênio Oliveira da Silva
//==============================

package entidade;

public class usuarios {
	
	private int id_usuario;
	private String nome;
	private String senha;
	
	public usuarios() {
		
	}
		
	@Override
	public String toString() {
		return "usuarios [id_usuario=" + id_usuario + ", nome=" + nome
				+ ", senha=" + senha + "]";
	}


	public usuarios(int id_usuario, String nome, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.senha = senha;
	}


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

}
