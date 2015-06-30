angular.module( 'signup', [] ).config( function( $stateProvider ) {
  $stateProvider.state( 'signup', {
    url: '/signup',
    templateUrl: 'signup/signup.tpl',
    controller: 'SignupCtrl'
  } );
} ).controller( 'SignupCtrl', function( $scope, SignupService ) {
  $scope.SignupCtrl = {
    user: {},
    genderOptions: [ {
      label: 'MALE'
    }, {
      label: 'FEMALE'
    } ]
  };
  $scope.signUpUser = function( user ) {
    $scope.userGender = user.gender.label;
    user.gender = $scope.userGender;
    console.log("in controller");
    SignupService.signUpUser( user ).success( function( response ) {
      $scope.sucessMessage = response;
      console.log("response.data",response);
      if(response.data){
        console.log("hi");
        var email = response.data.email;
        toastr.success( $scope.successMessage );
        $state.go('user',{id:email});
      }
    } ).error( function( response ) {
      $scope.errorMessage=response.messages[0];
      toastr.error($scope.errorMessage);
    } );
  };
} );
