angular.module( 'app', [ 'ui.router', 'templates', 'login', 'home','signup','user'] ).config( function( $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/home' );
} ).run( function() {
} );
