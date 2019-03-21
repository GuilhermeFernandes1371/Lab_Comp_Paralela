<?php
	
	include_once 'conexao.php';
	include_once 'cliente.php';

	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();

	$cliente = new Cliente($bd);

	if($cliente->atualizaCliente($_GET['idCliente'], $_GET['nomeCliente'], $_GET['emailCliente'])) {

		echo '<a href="menu.php"> Voltar ao Menu </a>';
		echo "Cliente atualizado com sucesso!";

	} else {
		echo "<br>Cliente não encontrado - Tente novamente";
	}

?>