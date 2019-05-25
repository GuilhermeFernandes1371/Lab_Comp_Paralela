<?php
class Pessoa {
	private $tabela = 'pessoa';
	private $conexao;
	
	private $idCliente;
	private $nomeCliente;
	private $emailCliente;
	private $cpfCliente;
	private $telefoneCliente;
	private $senhaCliente;
	
	public function __construct($bd){
		$this->conexao = $bd;
	}

	function getByID($id){

		$consulta = 'select * from ' . $this->tabela . ' where codpessoa = ' . $id;
		$stmt = $this->conexao->query($consulta);
		return $stmt; 
	}
	
	function getAll(){
		$consulta = 'select * from ' . $this->tabela;
		$stmt = $this->conexao->query($consulta);
		return $stmt;
	}

	function busca($palavraChave){

		$consulta = 'select * from ' . $this->tabela . " where codpessoa like '%". $palavraChave; 
		$stmt = $this->conexao->query($consulta);
		return $stmt;		

	}

	function inserir($nome, $email, $telefone, $cpf, $rg, $rua, $numero){
		$consulta = "INSERT INTO
                " . $this->tabela . "
                SET
                NOME = '$nome', 
                EMAIL = '$email', 
                TELEFONE ='$telefone',
                CPF = '$cpf',
                RG = '$rg',
                RUA = '$rua',
                NUMERO = '$numero'";
		
		$stmt = $this->conexao->prepare($consulta);
		
		if($stmt->execute()){

			return true;
		}
		
		return false;
	}

	function deletar($id){

		$sql = "DELETE FROM " .$this->tabela .' WHERE codpessoa = "'.$id. '"';
		$stmt = $this->conexao->prepare($sql);
		
		if($stmt->execute()){

			return true;
		}
		
		return false;
	}

	function atualizaCliente($idCli, $nomeCli, $emailCli){

		$sql = "UPDATE " .$this->tabela .
		' SET nomeCliente = "'.$nomeCli. '", emailCliente = "' .$emailCli. '"
		WHERE idCliente = 	' .$idCli;
		$stmt = $this->conexao->prepare($sql);
		
		if($stmt->execute()){

			return true;
		}
		
		return false;
	}
}