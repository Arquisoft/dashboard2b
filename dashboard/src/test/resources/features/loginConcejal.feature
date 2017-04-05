Feature: Login de usuario
	Scenario: Un concejal se loguea
		When un usuario de tipo concejal se loguea con usuario "concejal1" y password "concejal1"
		Then el usuario recibe la pantalla inicial
