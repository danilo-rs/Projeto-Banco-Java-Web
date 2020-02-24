//==============================
// ATENEU - Projeto Ateneu - 2019
// Professor: St�nio Oliveira da Silva
//==============================

package auxiliar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controle.*;
import entidade.*; 


public class dao {
	
    //=======================================================================================
    // CONEX�O COM O BANCO DE DADOS
    //=======================================================================================
	
	//Classe dao que realiza a conex�o com o banco de dados MySQL
    public static class conexao{
    	Connection con; 		//Declara a vari�vel con do tipo Connection
    	PreparedStatement st;	//Declara a vari�vel st do tipo Statement
    	ResultSet rs;			//Declara a vari�vel rs do tipo ResultSet
    	
    	//M�todo que abre a conex�o com o banco de dados
    	public void open() throws Exception{
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_de_dados","root",""); //String de conex�o com a m�quina e banco de dados
    	}
    	
    	//M�todo que fecha a conex�o com o banco de dados
    	public void close() throws Exception{
    		con.close();
    	}
    }
 
    //=======================================================================================
    // USUARIOS
    //=======================================================================================
    
    //Classe que abre a conex�o com banco de dados, insere um usu�rio/senha e fecha a conex�o
    public static class usuarioDao extends conexao{
    	
    	//Classe que realiza o acessso ao sistema utilizando o nome e senha do usu�rio
      	public String acessar(usuarios c) throws Exception{
    		String n = c.getNome();
    		String s = c.getSenha();
    		
    		String nome_tbl="";
			String senha_tbl="";
    		String a = "";
    		
    		try{
    		open();
    		String q1 = "select * from usuarios where nome='" + n + "'"; 
    		st = con.prepareStatement(q1);
    		st.execute();
			rs = st.executeQuery(q1);
			//rs.beforeFirst();
			while (rs.next()){
				nome_tbl = rs.getString("nome");
				senha_tbl = rs.getString("senha");
			}
			if ( (nome_tbl.equalsIgnoreCase("")) || (senha_tbl.equalsIgnoreCase("")) ){
				a= "0";
			}else {
				if ( (nome_tbl.equalsIgnoreCase(n)) && (senha_tbl.equalsIgnoreCase(s)) ){
					a = "1";
				}else {
					a = "0";
				}
			}
			}catch(Exception e){
				System.out.println("Falha de acesso:"+ e.getMessage());
			}	
			st.close();
			close();
			return a;
    	}
    
    }
    
    //=======================================================================================
    // TABELA 1
    //=======================================================================================
    
    //Classe que abre a conex�o com banco de dados, insere dados e fecha a conex�o
    public static class tabela1Dao extends conexao{
    	public void criar(tabela1 c) throws Exception{
    		open();
    			st = con.prepareStatement("insert into tabela1 values(null,?,?,?,?,now(),now())");
    			st.setString(1, c.getNome());
    			st.setString(2, c.getCpf());
    			st.setString(3, c.getCartao());
    			st.setInt(4, c.getSaldo());
    			st.execute();
    			st.close();
    		close();
    	}
    	
    	//Classe que abre a conex�o com banco de dados, exclui dados e fecha a conex�o	
    	public void excluir(int cod) throws Exception{
    		open();
    			st = con.prepareStatement("delete from tabela1 where id_tabela1=?");
    			st.setInt(1, cod);
    			st.execute();
    			st.close();
    		close();
    	}
    	
    	//Classe que abre a conex�o com banco de dados, altera/atualiza dados e fecha a conex�o. 
    	//Necessita do c�digo referente ao registro (id da tabela)
    	public void atualizar(tabela1 c) throws Exception{
    		open();
				st = con.prepareStatement("update tabela1 set nome=?, cpf=?, cartao=?, saldo=?, data_hora_atualizacao=now()  where id_tabela1=?");
    			st.setString(1, c.getNome());
    			st.setString(2, c.getCpf());
    			st.setString(3, c.getCartao());
    			st.setInt(4, c.getSaldo());
				st.setInt(5, c.getId_tabela1());
				st.execute();
				st.close();
			close();
    	}

       //Classe que abre a conex�o com banco de dados, lista todos os dados e fecha a conex�o.
    	public ArrayList listarDados() throws Exception{
    		ArrayList a = new ArrayList<>();
    		open();
				st = con.prepareStatement("select * from tabela1");
				rs = st.executeQuery();
				while (rs.next()){
					tabela1 c = new tabela1();
					c.setId_tabela1(rs.getInt(1));
					c.setNome(rs.getString(2));
					c.setCpf(rs.getString(3));
					c.setCartao(rs.getString(4));
					c.setSaldo(rs.getInt(5));
					a.add("C�digo ==>" + c.getId_tabela1() + " CLIENTE " + c.getNome() + " CPF " + c.getCpf() + " CART�O " + c.getCartao() + " SALDO  R$"+c.getSaldo()+"<hr>");
				}
				st.execute();
				st.close();
			close();
			return a;
    	}
    } 
}
