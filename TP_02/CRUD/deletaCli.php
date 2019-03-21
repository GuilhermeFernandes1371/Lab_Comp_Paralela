<?php
	
	include_once 'conexao.php';
	include_once 'cliente.php';

	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();

	$cliente = new Cliente($bd);

	if($cliente->deletaCliente($_GET['nomeCliente'])) {

		echo '<a href="menu.php"> Voltar ao Menu </a>';
		echo "Cliente deletado com sucesso!";

	} else {
		echo "<br>Cliente não encontrado - Tente novamente";
	}

?>