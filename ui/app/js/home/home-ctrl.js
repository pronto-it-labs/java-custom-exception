angular.module( 'home', [] ).config( function( $stateProvider ) {
  $stateProvider.state( 'home', {
    url: '/home',
    templateUrl: 'home/home.tpl',
    controller: 'HomeCtrl'
  } );
} ).controller( 'HomeCtrl', function( $scope, $state ) {
  $scope.homeCtrl = {};
  console.log( "HomeCtrl" );
  $scope.goToLoginPage = function() {
    $state.go( 'login' );
  };
} );
