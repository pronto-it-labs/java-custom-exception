angular.module( 'app' ).factory( 'LoginService', function( Constants, $http ) {
	return {
		findByEmail: function( email ) {
			console.log("email in service",email);
			return $http.post( Constants.APP_URL + 'user/findby-email?email='+email);
		}
	};
} );
