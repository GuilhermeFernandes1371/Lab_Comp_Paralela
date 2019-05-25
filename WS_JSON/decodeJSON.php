<!DOCTYPE>
<html>
	<head>
		<title> Gerar JSON (Cliente) </title>
			<meta http-equiv="Content-type" content="text/html" charset="UTF-8"/>
    	 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	</head>
	<body>
		<h1 align="center"> Pessoas Cadastradas  </h1>
		<div class="container">
			<div class="row">
				<table class="table table-bordered">
				    <thead>
				    <tr>
				        <th class="text text-center">Nome</th>
				        <th class="text text-center">Email</th>
				        <th class="text text-center">Telefone</th>
				        <th class="text text-center">Cidade</th>
				        <th class="text text-center">Deletar</th>
				    </tr>
				    </thead>
				    <tbody>
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

							$geraJSON = json_encode($pessoas);

						} else {
							echo json_encode(
									array("mensagem" => "Nenhum Cliente Encontrado!")
								);
						}

				        $pessoas = json_decode($geraJSON, true);
				        $resultado = array();
				        $resultado['registros'] = array();
				        
				        for($i = 0; $i < count($pessoas["registros"]); $i++){
				            echo "<tr>";
				            echo "<td class='text text-center'>" . $pessoas["registros"][$i]["nome"] . "</td>";
				            echo "<td class='text text-center'>" . $pessoas["registros"][$i]["email"] . "</td>";
				            echo "<td class='text text-center'>" . $pessoas["registros"][$i]["telefone"] . "</td>";
				            echo "<td class='text text-center'>" . $pessoas["registros"][$i]["cidade"] . "</td>";
				            echo "<td class='text text-center'><a href='deletarPessoa.php?id=". $pessoas["registros"][$i]["id"] ."'><i class='fas fa-trash'></i></a></td>";
				            echo "</tr>";

				        }
				    ?>
				    </tbody>
			     </table>
			</div>
		</div>
		<br><br><a href="menu.php"> Voltar à tela inicial </a> <br>
	</body>
</html>

	

	





