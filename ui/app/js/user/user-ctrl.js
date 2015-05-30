angular.module( 'user', [] ).config( function( $stateProvider ) {
	$stateProvider.state( 'home.user', {
		url: '/user',
		templateUrl: 'user/user.tpl',
		controller: 'UserCtrlrl',
		resolve:{
			user: function(UserService){
				return UserService.findByEmail();
			}
		}
	} );
} ).controller('UserCtrl',  function($scope){
	$scope.UserCtrl = {};
	console.log("UserCtrl");
	
});