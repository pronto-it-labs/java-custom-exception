<div class="pull-right" ui-sref="home">
	
<button class="btn btn-block btn-success pull-right">Back</button>
</div>
<div class="div-center">
  <div class="form-group center">
  </div>
  <form >
    <div class="form-group">
      <label for="firstName">First Name</label>
      <input type="text" class="form-control" id="firstName" placeholder="First Name" ng-model="user.firstName"> </div>
    <div class="form-group">
      <label for="lastName">Last Name</label>
      <input type="text" placeholder="Last Name" id="lastName" class="form-control" ng-model="user.lastName"> </div>
    <label for="userGender">Gender</label>
    <div class="form-group">
       <input type="text"  class="form-control" ng-model="user.gender">
    </div>
    <div class="form-group">
      <label for="userEmail">Email</label>
      <input type="email" name="Email" id="userEmail" class="form-control" placeholder="Enter Email" ng-model="user.email"> </div>
    
  </form>
</div>
