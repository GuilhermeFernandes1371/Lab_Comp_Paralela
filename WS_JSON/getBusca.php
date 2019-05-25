<?php
	include_once 'conexao.php';
	include_once 'cliente.php';
	
	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();
	
	$cliente = new Cliente($bd);
	
	$stmt = $cliente->Busca('Henrique');
	
	$nlinhas = $stmt->num_rows;

	if($nlinhas > 0){
		$clientes = array();
		$clientes['registros'] = array();
		
		while($linha = mysqli_fetch_array($stmt)){
			extract($linha);
			$cliEncontrado = array(
					"id" => $idCliente,
					"nome" =>$nomeCliente,
					"email" =>$emailCliente,	
					"telefone" =>$telefoneCliente,
					"senha" =>$senhaCliente
			);
			array_push($clientes["registros"], $cliEncontrado);
		}
		echo json_encode($clientes);
	} else {
		echo json_encode(
				array("mensagem" => "Nenhum Cliente Encontrado!")
			);
	}
	
	