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
	// console.log("$stateParams.id",$stateParams.id);
	var email = $stateParams.id;
	console.log("email",email);
	UserService.findUserByEmail(email).success(function(response){
		console.log("response",response);
		// $scope.userName = response.data.userName;
		$scope.user = response.data;
	}).error(function(response){
		console.log("error response",response);
	});
});