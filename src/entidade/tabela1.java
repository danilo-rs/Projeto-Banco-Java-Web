//==============================
// ATENEU - Projeto Ateneu - 2019
// Professor: Stênio Oliveira da Silva
//==============================

package entidade;

public class tabela1 {

	private int id_tabela1;
	private String nome;
	private String cpf;
	private String cartao;
	private int saldo;
	
	public tabela1() {
		
	}
	

	@Override
	public String toString() {
		return "tabela1 [id_tabela1=" + id_tabela1 + "," + nome + ","
				+ cpf + "," + cartao + ", R$"+ saldo + "]";
	}

	public tabela1(int id_tabela1, String nome, String cpf, String cartao,
			int saldo) {
		super();
		this.id_tabela1 = id_tabela1;
		this.nome = nome;
		this.cpf = cpf;
		this.cartao = cartao;
		this.saldo = saldo;
	}


	public int getId_tabela1() {
		return id_tabela1;
	}


	public void setId_tabela1(int id_tabela1) {
		this.id_tabela1 = id_tabela1;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCartao() {
		return cartao;
	}


	public void setCartao(String cartao) {
		this.cartao = cartao;
	}


	public int getSaldo() {
		return saldo;
		
		
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

}
