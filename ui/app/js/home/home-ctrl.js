angular.module( 'home', ['user'] ).config( function( $stateProvider ) {
  $stateProvider.state( 'home', {
    url: '/home',
    templateUrl: 'home/home.tpl',
    controller: 'HomeCtrl'
  } );
} ).controller( 'HomeCtrl', function( $scope, $state ) {

  console.log("HomeCtrl");
    $state.go( 'login' );
} );
