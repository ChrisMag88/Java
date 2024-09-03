<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Interest Calculation Result</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="header">	
		<div class="items">
			<div>
				<img width="350" alt="banxico" src="images/logo1.png">
			</div>
			<div class="center">	
				<h1>Calculadora de intereses</h1>
			</div>
			<div class="welcome">
				<h3>Bienvenido!</h3>
			</div>
		</div>
	</div>
	
	<div class="container">	
		<div class="row text-center">		
		    <h1>Resultado del calculo</h1>
		    <p>El interes total sería de: <span class="total-debt">$${interest}</span></p>
		    <p>Pagarías en total: <span class="total-debt">$${totalToPay}</span></p>
		    
		    <small class="note">*Fecha y hora del cálculo: ${today}</small>
		    
		    <div style="margin-top: 40px">
			    <a href="index.jsp">Finalizar</a>
		    </div>
		</div>
	</div>
</body>
</html>