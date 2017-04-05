Feature: Login de usuario
	Scenario: Un alcalde se loguea
		When un usuario de tipo alcalde se loguea con usuario "alcalde1" y password "alcalde1"
		Then el usuario recibe la pantalla inicial