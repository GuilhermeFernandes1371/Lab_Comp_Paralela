<!DOCTYPE>
<html>
	<head>
		<title> Cadastro de Clientes </title>
		<link rel="stylesheet" type="text/css" href="stilo.css">
	</head>

	<body id="Cliente">

		<h1 align="center"> Cadastro de Clientes </h1>

		<form action="cadastraCliente.php" id="cadastroCliente">

			Nome Cliente <input type="text" name="nomeCliente"><br>
			Email Cliente <input type="email" name="emailCliente"><br>

				<select name="idSuporte" form="cadastroCliente">
				
				<?php 

					include_once 'conexao.php';
					include_once 'suporte.php';	
					$bancoDeDados = new Conexao();
					$bd = $bancoDeDados->getConnection();	
					$suporte = new Suporte($bd);
					$stmt = $suporte->getAll();

					while($linha = mysqli_fetch_array($stmt)){
						echo '<option value="'. $linha['idSuporte'] .'">'.$linha['descricaoSuporte'].'</option>';
					}

				?>	

				</select>

			<input type="submit" value="Enviar"><br>
		</form>

		<img src="Imagens/cliente_fundo.png" id="imgCli">
	</body>
</html>
