(function(){

	/**
	 * múdulo principal
	 */
	var app = angular.module('BookApp', ['ui.bootstrap', 'UsuarioApp', 'ngCookies', 'ngRoute']);

	app.config(function($routeProvider) {
		$routeProvider

			// route for the home page
			.when('/', {
				templateUrl : 'pages/home.html',
				controller  : 'HomeCtrl'
			})

			.when('/perfil/:id', {
				templateUrl  : 'pages/perfil.html',
				controller   : 'PerfilCtrl',
				controllerAs : 'ctrl' 
			})
			;
	});


	/**
	 * controller da navbar
	 */
	app.controller('NavbarCtrl', ['$scope', '$window', function($scope, $window){
		$scope.isCollapsed = true;
		$scope.isLogged = false;
		//alert("screen width " + $window.innerWidth);
		
		this.screenWidth = function() {
			alert("screen width " + $window.innerWidth);
		};
	}]);

	/**
	 * [description]
	 * @param  {[type]} usuarioServices [description]
	 * @param  {[type]} $scope          [description]
	 * @return {[type]}                 [description]
	 */
	app.controller('AutenticacaoCtrl', ['usuarioServices', '$scope', '$cookies', function(usuarioServices, $scope, $cookies) {

		this.username = null;
		this.senha = null;

		$scope.isLogged = false;

		if ($cookies.isLogged) {
			console.log('$cookies.isLogged', $cookies);
			$scope.isLogged = $cookies.isLogged;
			try {
				$scope.usuario = JSON.parse($cookies.usuario);
			} catch (err) {
				throw "Erro ao buscar tentar fazer o parse do objeto usuario no cookie!! " + err; 
			}

			console.log('$scope.isLogged', $scope.isLogged);
			console.log('$scope.usuario', $scope.usuario);
		}	


		this.login = function() {

			var usuarioLogin = {email: this.username, senha: this.senha};
			console.log('usuarioLogin', usuarioLogin);

			usuarioServices.login(usuarioLogin, function(data) {
				if (data.sucesso) {
					console.log('data', data);
					// update $scope
					$scope.isLogged = true;
					$scope.usuario = data.usuario;
					// update cookie
					$cookies.isLogged = $scope.isLogged;
					$cookies.usuario = JSON.stringify($scope.usuario);
				} else {
					alert('falha no login');
				}
			});
		};


		this.logout = function() {
			$scope.isLogged = false;
			delete $scope.usuario;
			delete $cookies.isLogged;
			delete $cookies.usuario;
			this.username = null;
			this.senha = null;
		};

	}]);

	app.controller('HomeCtrl', [function(){

	}]);

	app.controller('PerfilCtrl', [function(){
		this.funcionario = {id: 1, nome:"Buzz Lightyear", email: "buzz@toyhistory.com", 
			imagemPerfil : "resources/v1/img/buzz.jpg", cargo: "Astronauta"
		};

	}]);
	

})();