<?php
	
	include_once 'conexao.php';
	include_once 'suporte.php';

	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();

	$suporte = new Suporte($bd);
	$descricaoSuporte = $_GET['descricaoSuporte'];

	if($suporte->inserir($descricaoSuporte)) {

		echo '<a href="menu.php"> Voltar ao Menu </a>';
		echo "Suporte cadastrado com sucesso!";

	} else {
		echo "Erro - Tente novamente";
	}

?>
