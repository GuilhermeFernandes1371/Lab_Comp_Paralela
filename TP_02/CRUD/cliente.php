<?php

class Cliente {

	private $tabela = 'cliente';
	private $conexao;
	
	private $idCliente;
	private $nomeCliente;
	private $emailCliente;
	private $idSuporte;
	
	public function __construct($bd){
		$this->conexao = $bd;
	}
	
	function inserir($nomeCliente, $emailCliente, $idSuporte){
		$consulta = "INSERT INTO
                " . $this->tabela . "
                SET
                nomeCliente = '$nomeCliente', emailCliente= '$emailCliente', suporte_idSuporte='$idSuporte'";
		
		$stmt = $this->conexao->prepare($consulta);
		
		if($stmt->execute()){

			return true;
		}
		
		return false;
	}

	function getCli(){

		$consulta = 'select * from ' . $this->tabela;
		$stmt = $this->conexao->query($consulta);
		return $stmt;

	}

	function deletaCliente($nomCliente){

		$sql = "DELETE FROM " .$this->tabela .' WHERE nomeCliente = "'.$nomCliente. '"';
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