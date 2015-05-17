angular.module( 'app', [ 'ui.router', 'templates', 'user-login', 'home','user-signup'] ).config( function( $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/home' );
} ).run( function() {
} );
