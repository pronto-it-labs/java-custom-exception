angular.module( 'app' ).factory( 'SignupService', function( Constants, $http ) {
  return {
    signUpUser: function( user ) {
      console.log( "SignupService: ", user );
      return $http.post( Constants.APP_URL + 'user/signup', user );
    }
  };
} );
