angular.module( 'login', [] ).config( function( $stateProvider ) {
  $stateProvider.state( 'login', {
    url: '/login',
    templateUrl: 'login/login.tpl',
    controller: 'LoginCtrl'
  } );
} ).controller( 'LoginCtrl', function( $scope, LoginService,$state) {
  $scope.loginCtrl = {
    user: {}
  };
  $scope.validateUser = function( loginDto ) {
    console.log("email in controller",loginDto.email);
    LoginService.findByEmail( loginDto.email ).success( function( response ) {
      $scope.successMessage = response.messages[0];

      if(response.data && response.success === true){
        var email = response.data.email;
        toastr.success( $scope.successMessage );
        $state.go('user',{id:email});
      }
      
      
    } ).error( function( response ) {
      $scope.errorMessage = response.messages[0];
      toastr.error( $scope.errorMessage );
    } );
  };
  $scope.goToHomePage = function() {
    $state.go('signup');
  };
} );
