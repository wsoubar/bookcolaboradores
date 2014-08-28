(function() {

	var usuarioApp = angular.module('UsuarioApp', []);

	usuarioApp.factory('usuarioServices', ['$filter', function($filter) {
		var factory = {};

		factory.usuarios = users;

		factory.listarUsuarios = function() {
			return this.usuarios;
		};

		factory.login = function(options, callback) {

			console.log('options', options);
			console.log(JSON.stringify(options));
			
			var login = null;
			
			login = _.findWhere(users, options);
			console.log('login', login);
			console.log(login);

			if (login) {
				callback({
					sucesso : true,
					status : "sucesso",
					usuario : login
				});
			} else {
				callback({
					erro : true,
					status : "erro",
					mensagem : "Usuário não foi encontrado"
				});
			}
		};

		return factory;
	} ]);

	var users = [ {
		id : 1,
		nome : "Wagner Barbosa",
		email : "wsoubar@gmail.com",
		senha : "123"
	}, {
		id : 2,
		nome : "Teste",
		email : "test@test.com",
		senha : "123"
	} ];

})();