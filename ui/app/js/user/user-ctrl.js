angular.module( 'user', [] ).config( function( $stateProvider ) {
	$stateProvider.state( 'user', {
		url: '/user/:id',
		templateUrl: 'user/user.tpl',
		controller: 'UserCtrl',
		/*resolve:{
			user: function(UserService, $stateParams){
				console.log("$stateParams.id",$stateParams.id);
				return UserService.findByEmail($stateParams.id);
			}
		}*/
	} );
} ).controller('UserCtrl',  function($scope, $stateParams, UserService){
	$scope.UserCtrl = {};
	var email = $stateParams.id;
	UserService.findUserByEmail(email).success(function(response){
		$scope.user = response.data;
	});
});