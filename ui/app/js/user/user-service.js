angular.module('app').factory('UserService',  function(Constants, $http){
	return {
		findUserByEmail: function(email){
			return $http.post( Constants.APP_URL + 'user/findby-email?email='+email);
		}
		
	};
});