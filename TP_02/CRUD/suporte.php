<?php

class Suporte {

	private $tabela = 'suporte';
	private $conexao;
	
	private $idSuporte;
	private $descricaoSuporte;
	
	public function __construct($bd){
		$this->conexao = $bd;
	}
	
	function inserir($descricaoSuporte){
		$consulta = "INSERT INTO
                " . $this->tabela . "
                SET
                descricaoSuporte = '$descricaoSuporte'";
		
		$stmt = $this->conexao->prepare($consulta);
		
		if($stmt->execute()){
			return true;
		}
		
		return false;
	}

		function getAll(){
			
			$consulta = 'select * from ' . $this->tabela;
			$stmt = $this->conexao->query($consulta);
			return $stmt;
		}
}