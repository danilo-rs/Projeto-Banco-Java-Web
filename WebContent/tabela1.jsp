<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BANCO</title>
</head>
<body>

<center>
Sistema Web - UniAteneu<br>
Administração dos Clientes

		<hr>
		<form method="post" action="web?cmd=criarRegistroTabela1">
			Nome<input type="text" name="nome" size="20"><br />
			CPF<input type="text" name="cpf" size="20"><br />
			Cartão<input type="text" name="cartao" size="20"><br />
			SALDO<input type="text" name="saldo" size="20"><br />
			<input type="submit" value="Cadastrar" size="20"><br />
		</form>
		<hr>
		<form method="post" action="web?cmd=excluirRegistroTabela1">
			Código<input type="text" name="cod" size="20"><br />
			<input type="submit" value="Excluir" size="20"><br />
		</form>
		<hr>
		<form method="post" action="web?cmd=atualizarRegistroTabela1">
			Código<input type="text" name="cod" size="20"><br>
			Nome<input type="text" name="nome" size="20"><br>
			CPF<input type="text" name="cpf" size="20"><br>
			Cartao<input type="text" name="cartao" size="20"><br>
			Saldo atual<input type="text" name="saldoatual" size="20"><br>
			Deposito<input type="text" name="Deposito" size="20"><br>
			Saque<input type="text" name="Deposito" size="20"><br>
			Total<input type="text" name="saldo" size="20"><br>
			<tr>
			<td><input type="submit" value="Depositar" size="20"></td>
			<td><input type="submit" value="SACAR" size="20"></td>
			</tr>
		</form>
		<hr>
		<form method="post" action="web?cmd=listarRegistroTabela1">
			<input type="submit" value="Listar" size="20"><br />
		</form>
		<hr>
		${res}

		<br/>
		<hr>
		<a href="sistema.jsp">Voltar</a>
	</center>

</body>
</html>