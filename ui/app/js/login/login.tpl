<div class="div-center">
  <form ng-submit="validateUser(LoginCtrl.user)">
    <div role="alert" class="form-group" ng-show="errorMessage">{{errorMessage}}</div>
    <div class="form-group center">
      <span class="signin-font-size">Sign In</span>
    </div>
    <div class="form-group">
      <label for="userEmail">Email</label>
      <input type="email" class="form-control" placeholder="Email" id="userEmail" ng-model="LoginCtrl.user.email"> </div>
    <div class="form-group">
      <label for="userPassword">Password</label>
      <input type="password" class="form-control" placeholder="Password" id="userPassword" ng-model="LoginCtrl.user.password"> </div>
    <button class="btn btn-block btn-primary">Sign in</button>
    <div class="form-group"></div>
  </form>
  <div class="form-group"></div>
  <button class="btn btn-block btn-success" data-ng-click="goToHomePage()">Sign Up</button>
</div>
