<?php
	include_once 'conexao.php';
	include_once 'pessoa.php';
	
	$bancoDeDados = new Conexao();
	$bd = $bancoDeDados->getConnection();
	
	$pessoa = new Pessoa($bd);	
	$stmt = $pessoa->getAll();
	
	$nlinhas = $stmt->num_rows;

	if($nlinhas > 0){
		$pessoas = array();
		$pessoas['registros'] = array();
		
		while($linha = mysqli_fetch_array($stmt)){
			extract($linha);
			$pessoaEncontrado = array(
					"id" => $CODPESSOA,
					"nome" =>$NOME,
					"email" =>$EMAIL,	
					"telefone" =>$TELEFONE,
					"rua" =>$RUA,
					"numero" =>$NUMERO,
					"complemento" =>$COMPLEMENTO,	
					"cidade" =>$CIDADE,
					"estado" =>$ESTADO,
					"cep" =>$CEP,
					"rg" =>$RG,
					"cpf" =>$CPF,
			);
			array_push($pessoas["registros"], $pessoaEncontrado);
		}

		$json = json_encode($pessoas);
		echo $json;

	} else {
		echo json_encode(
				array("mensagem" => "Nenhum Cliente Encontrado!")
			);
	}

	echo '<br><br><a href="menu.php"> Voltar à tela inicial </a> <br>';

	