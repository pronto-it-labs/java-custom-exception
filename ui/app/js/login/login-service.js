angular.module( 'app' ).factory( 'LoginService', function( Constants, $http ) {
  return {
    validateUser: function( email ) {
      // console.log( "LoginService: ", email );
      return $http.post( Constants.APP_URL + 'user/findby-email',email);
    }
  };
} );
