<?php

	include_once 'conexao.php';
	include_once 'pessoa.php';

	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();

	$pessoa = new Pessoa($bd);

	$id = $_GET['id'];

	if($pessoa->deletar($id)) {

		echo '<a href="menu.php"> Voltar à tela inicial </a> <br>';
		echo "Pessoa deletada com sucesso!";

	} else {
		echo "Erro - Pessoa não cadastrado";
	}

?>
