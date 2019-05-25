<?php

	include_once 'conexao.php';
	include_once 'pessoa.php';

	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();

	$pessoa = new Pessoa($bd);

	$nome = $_POST['nome'];
	$email = $_POST['email'];
	$telefone = $_POST['telefone'];
	$cpf = $_POST['cpf'];
	$rg = $_POST['rg'];
	$rua = $_POST['rua'];
	$numero = $_POST['numero'];

	if($pessoa->inserir($nome, $email, $telefone, $cpf, $rg, $rua, $numero)) {

		echo '<a href="menu.php"> Voltar ao Menu Principal </a> <br>';
		echo "Pessoa cadastrado com sucesso!";

	} else {
		echo "Erro - Pessoa não cadastrada";
	}

?>
