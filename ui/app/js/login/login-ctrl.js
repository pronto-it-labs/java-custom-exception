angular.module( 'user-login', [] ).config( function( $stateProvider ) {
  $stateProvider.state( 'login', {
    url: '/login',
    templateUrl: 'login/login.tpl',
    controller: 'LoginCtrl'
  } );
} ).controller( 'LoginCtrl', function( $scope, LoginService,$state) {
  $scope.LoginCtrl = {
    user: {}
  };
  $scope.validateUser = function( email ) {
    LoginService.validateUser( email ).error( function( response ) {
      console.log( "error response: ", response );
      $scope.errorMessage = response.messages[0];
      toastr.error( $scope.errorMessage );
    } ).success( function( response ) {
      $scope.successMessage = response.messages[0];
      toastr.success( $scope.successMessage );
      console.log( "success response: ", response );
      
    } );
  };
  $scope.goToHomePage = function() {
    $state.go('signup');
  };
} );
