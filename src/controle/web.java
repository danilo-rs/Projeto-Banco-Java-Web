package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auxiliar.*;
import auxiliar.dao.*;
import entidade.*;

/**
 * Servlet implementation class web
 */
@WebServlet("/web")
public class web extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public web() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("cmd"); //Recebe o comando enviado pela página
		
		//ACESSO
		if (comando.equalsIgnoreCase("acessar")){
			acessarBanco(request, response);
		}
		
		//TABELA 1
		if (comando.equalsIgnoreCase("criarRegistroTabela1")){
			criarRegistroTabela1(request, response);
		}
		if (comando.equalsIgnoreCase("excluirRegistroTabela1")){
			excluirRegistroTabela1(request, response);
		}
		if (comando.equalsIgnoreCase("atualizarRegistroTabela1")){
			atualizarRegistroTabela1(request, response);
		}
		
		if (comando.equalsIgnoreCase("listarRegistroTabela1")){
			listarRegistroTabela1(request, response);
		}
	}

    //=======================================================================================
    // ACESSO AO BANCO DE DADOS
    //=======================================================================================
	
	protected void acessarBanco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome_usuario = request.getParameter("nome"); //Usuário
		String senha_usuario = request.getParameter("senha"); //Senha
		
		usuarios usu = new usuarios();
		usu.setNome(nome_usuario);
		usu.setSenha(senha_usuario);
		try{
			String u = new usuarioDao().acessar(usu);
			
			if (u.equalsIgnoreCase("1")){

				request.setAttribute("res", u);

				HttpSession sessao = request.getSession();
				
				response.sendRedirect("tabela1.jsp");
				System.out.println("Sucesso");
				
			}else{
				System.out.println("Cadastro não existe!");
				response.sendRedirect("index.jsp");
			}
		}catch(Exception e){
			System.out.println("Erro 2 :"+e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
   
	    //=======================================================================================
	    // TABELA 1
	    //=======================================================================================
		
		protected void criarRegistroTabela1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String cartao = request.getParameter("cartao");
			int saldo = Integer.parseInt(request.getParameter("saldo"));
			
			tabela1 tbl1 = new tabela1();
			tbl1.setNome(nome);
			tbl1.setCpf(cpf);
			tbl1.setCartao(cartao);
			tbl1.setSaldo(saldo);
			
			try{
				new tabela1Dao().criar(tbl1);
				
			
				
				HttpSession sessao = request.getSession();
			
				
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
				System.out.println("Sucesso");
				
			}catch(Exception e){
				System.out.println("Erro :"+e.getMessage());
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}
		}
		
		protected void excluirRegistroTabela1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id_usuario = new Integer(request.getParameter("cod"));
			
			try{
				new  tabela1Dao().excluir(id_usuario);
				System.out.println("Sucesso");
			
				
				HttpSession sessao = request.getSession();
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}catch(Exception e){
				System.out.println("Erro :"+e.getMessage());
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}
		}
		
		protected void atualizarRegistroTabela1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String cartao = request.getParameter("cartao");
			int saldo = Integer.parseInt(request.getParameter("saldo"));
			int id_tabela1 = new Integer(request.getParameter("cod"));
			
			tabela1 tbl1 = new tabela1();
			tbl1.setNome(nome);;
			tbl1.setCpf(cpf);
			tbl1.setCartao(cartao);
			tbl1.setSaldo(saldo);
			tbl1.setId_tabela1(id_tabela1);
			
			
			try{
				new tabela1Dao().atualizar(tbl1);
				System.out.println("Sucesso");
			
				HttpSession sessao = request.getSession();
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}catch(Exception e){
				System.out.println("Erro :"+e.getMessage());
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}
		}
			protected void listarRegistroTabela1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try{
				System.out.println("Sucesso");
				
				request.setAttribute("res", new tabela1Dao().listarDados());
				HttpSession sessao = request.getSession();
				
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}catch(Exception e){
				System.out.println("Erro :"+e.getMessage());
				request.getRequestDispatcher("tabela1.jsp").forward(request, response);
			}
		}	
}
