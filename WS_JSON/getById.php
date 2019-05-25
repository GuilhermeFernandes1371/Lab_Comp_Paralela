<?php
	include_once 'conexao.php';
	include_once 'pessoa.php';
	
	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();
	
	$pessoa = new Pessoa($bd);
	
	$stmt = $pessoa->getById(6);
	
	$nlinhas = $stmt->num_rows;

	if($nlinhas > 0){
		$clientes = array();
		$clientes['registros'] = array();
		
		while($linha = mysqli_fetch_array($stmt)){
			extract($linha);
			$cliEncontrado = array(
					"id" => $CODPESSOA,
					"nome" =>$NOME,
					"email" =>$EMAIL,	
					"telefone" =>$TELEFONE,
			);
			array_push($clientes["registros"], $cliEncontrado);
		}
		echo json_encode($clientes);

		$teste =json_encode($clientes);
		
	} else {
		echo json_encode(
				array("mensagem" => "Nenhum Cliente Encontrado!")
			);
	}
	
	