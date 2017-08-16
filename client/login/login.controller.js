(function() {
    'use strict';
    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'LoginService'];

    function LoginController($location, LoginService) {
        var loginVM = this;
        loginVM.login_email ='';
        loginVM.login_pwd='';
        loginVM.BtnText = "Login";
        loginVM.wrongCredential = false;
        loginVM.click = click;
        function click() {
            loginVM.BtnText = " Logging..in";
            login();
        };
        function login() {
            LoginService.authenticateUser(loginVM.login_email, loginVM.login_pwd)
                .then(function(data) {
                    console.log(data);
                    if(data===true){
                        $location.path('/movies');
                    }
                    else{
                        loginVM.wrongCredential = true;
                        loginVM.BtnText = "Login";
                    }
                }, function(error) {
                    console.log(error);
                    loginVM.wrongCredential = true;
                    loginVM.BtnText = "Login";
                });
        }
    }

})();