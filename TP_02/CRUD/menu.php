<!DOCTYPE>
<html>
	<head>
		<title> Menu CRUD </title>
		<link rel="stylesheet" type="text/css" href="stilo.css">
	</head>
	<body id="Menu">

		<h1 align="center"> Menu CRUD </h1>

		<a href="formularioSuporte.php"> Cadastrar Suporte </a> <br>
		<a href="formularioCliente.php"> Cadastrar Cliente </a> <br>

		<form action="getCli.php">

			Exibir todos Clientes <input type="submit" value="Exibir Clientes"><br>		

		</form>

		<form action="deletaCli.php">

			<div>
				Digite o nome de um cliente: <input type="text" name="nomeCliente">
				<input type="submit" value="Deletar">
			</div>
				
		</form>

	</body>
</html>
