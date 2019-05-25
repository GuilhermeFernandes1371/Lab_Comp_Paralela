<!DOCTYPE>
<html>
	<head>
		<title> Cadastro de Pessoas </title>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8"/>
    	<link rel="stylesheet" type="text/css" href="stilo.css">
	</head>

	<body>
		<div class="container">  
		  <form id="contact" action="cadastraPessoa.php" method="post">
		    
		    <fieldset>
		      <input placeholder="Nome" type="text" name="nome">
		    </fieldset>
		    <fieldset>
		      <input placeholder="E-mail" type="text" name="email">
		    </fieldset>
		    <fieldset>
		      <input placeholder="CPF" type="number" tabindex="3" name="cpf">
		    </fieldset>
		    <fieldset>
		      <input placeholder="RG" type="number" tabindex="4" name="rg">
		    </fieldset>
		    <fieldset>
		      <input placeholder="Rua" type="text" tabindex="5" name="rua">
		    </fieldset>
		    <fieldset>
		      <input placeholder="Numero" type="number" tabindex="6" name="numero">
		    </fieldset>
		    <fieldset>
		      <input placeholder="Complemento" type="text" tabindex="7" name="complemento">
		    </fieldset>
		    <fieldset>
		      <input placeholder="Cidade" type="text" tabindex="8" name="cidade">
		    </fieldset>
		    <fieldset>
		      <input placeholder="Estado" type="text" tabindex="9" name="estado">
		    </fieldset>
		    <fieldset>
		      <input placeholder="CEP" type="number" tabindex="10" name="cep">
		    </fieldset>
		    <fieldset>
		      <input placeholder="Telefone" type="number" tabindex="11" name="telefone">
		    </fieldset>
		    <fieldset>
		      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Cadastrar</button>
		    </fieldset>
		    <p class="copyright"><a href="menu.php" target="_self" title="Colorlib"> Voltar ao Menu Inicial</a></p>
		  </form>
		</div>

	</body>	

</html>
