<?php
	include_once 'conexao.php';
	include_once 'cliente.php';
	
	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();
	
	$cliente = new Cliente($bd);
	
	$stmt = $cliente->getCli();
	
	while($dados = $stmt->fetch_array()){

		echo "ID: " .$dados["idCliente"]."<br>";
		echo "Nome Cliente: " .$dados["nomeCliente"]."<br>";
		echo "Email Cliente: " .$dados["emailCliente"]."<br>";
	}
	
	echo '<a href="menu.php"> Voltar ao Menu </a><br>';
	echo '<a href="formularioAtualizaCli.php"> Deseja atualizar o nome e email de algum cliente: </a>'
?>
	
	