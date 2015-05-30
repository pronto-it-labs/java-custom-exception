angular.module('app').factory('UserService',  function(Contants, $http){
	return {
		findUserByEmail: function(email){
			return $http.get(Contants.APP_URL+'user/findby-email',email);
		}
		
	};
})