<?php

	class Conexao{

		private $servidor = "localhost";
		private $banco = "provapratica";
		private $usuario = "root";
		private $senha = "";
		public $conn;
		
		public function getConnection(){
			$this->conn = null;
			try{
				$this->conn = new mysqli($this->servidor, $this->usuario, $this->senha, $this->banco); 
			}catch(PDOException $exception){
				echo "Erro de conexão " . $exception->getMessage();
			}
			return $this->conn;
		}
	}
?>