<?php

	include_once 'conexao.php';
	include_once 'cliente.php';

	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();

	$cliente = new Cliente($bd);

	$nomeCliente = $_GET['nomeCliente'];
	$emailCliente = $_GET['emailCliente'];
	$idSuporte = $_GET['idSuporte'];

	if($cliente->inserir($nomeCliente, $emailCliente, $idSuporte)) {

		echo '<a href="menu.php">Voltar ao Menu</a>';
		echo "Cliente cadastrado com sucesso!";

	} else {
		echo "Erro - Cliente não cadastrado";
	}

?>
