<!DOCTYPE>
<html>
	<head>
		<title> Deletar Pessoa </title>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8"/>
    	<link rel="stylesheet" type="text/css" href="stilo.css">
	</head>

	<body>
		<div class="container">  
		  <form id="contact" action="deletarPessoa.php" method="post">
		    
		    Digite o nome de uma pessoa para deletar o seu registro:
		    <fieldset>
		      <input placeholder="Nome" type="text" name="nome">
		    </fieldset>
		    
		      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Deletar</button>
		    </fieldset>
		    <p class="copyright"><a href="menu.php" target="_self" title="Colorlib"> Voltar ao Menu Inicial</a></p>
		  </form>
		</div>

	</body>	

</html>
