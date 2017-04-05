Feature: Login de usuario
	Scenario: Un alcalde se loguea
		When un usuario de tipo alcalde se loguea con usuario "alcalde@gmail.com" y password "alcalde"
		Then el usuario recibe la pantalla inicial