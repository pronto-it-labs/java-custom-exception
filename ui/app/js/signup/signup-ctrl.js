angular.module( 'user-signup', [] ).config( function( $stateProvider ) {
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
    console.log( "SignupCtrl: ", user );
    $scope.userGender = user.gender.label;
    user.gender = $scope.userGender;
    console.log( '$scope.userGender', $scope.userGender );
    SignupService.signUpUser( user ).error( function( response ) {
      console.log( "errorMessage".response );
    } ).success( function( response ) {
      console.log( "sucess", response );
    } );
  };
} );
