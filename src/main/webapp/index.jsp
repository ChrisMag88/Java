<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Interest Calculator</title>
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
	    <form action="calculateInterest" method="post">
	        <label for="amount">Cantidad :</label>
	        <input type="number" name="amount" step="0.01" required><br>
	        
	        <label for="timeInMonths">Tiempo:</label>
	        <select name="timeInMonths" id="timeInMonths" required>
	        	<option value="" disabled selected>Selecciona un tiempo</option>
	            <option value="3">3 meses</option>
	            <option value="6">6 meses</option>
	            <option value="9">9 meses</option>
	            <option value="12">12 meses</option>
	            <option value="15">15 meses</option>
	            <option value="18">18 meses</option>
	            <option value="21">21 meses</option>
	            <option value="24">24 meses</option>
	        </select><br>
	        
	        <input type="submit" value="Calcular intereses">
	    </form>
	</div>
    
</body>
</html>