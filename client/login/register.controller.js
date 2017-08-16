(function() {
    'use strict';
    angular.module('movieflix')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['$location', '$scope', 'RegisterService', 'RegisterSuccessModal'];

    function RegisterController($location, $scope, RegisterService, RegisterSuccessModal) {
        var registerVM = this;
        var self = this;
        registerVM.addUser = addUser;
        registerVM.checkUser = checkUser;
        registerVM.Btnclick = Btnclick;
        registerVM.BtnText = "Register";
        registerVM.defaultForm = {
            firstName: '',
            lastName: '',
            register_email: '',
            register_pwd: '',
            register_cnfpwd: ''
        };

        function Btnclick() {
            registerVM.BtnText = " Registering..Please Wait!";
        }

        function addUser() {
            self.firstName = registerVM.user.firstName;
            self.lastName = registerVM.user.lastName;
            self.email = registerVM.user.register_email;
            self.password = registerVM.user.register_pwd;
            RegisterService
                .createNewUser(self)
                .then(function(data) {
                    RegisterSuccessModal.open();
                    registerVM.user = angular.copy(registerVM.defaultForm);
                    $scope.registerForm.$setPristine();
                    registerVM.BtnText = "Register";
                    console.log(data);
                }, function(error) {
                    console.log(error);
                });
        }

        function checkUser() {
            console.log("Inside Check user")
            self.email = registerVM.user.register_email;
            RegisterService
                .checkEmail(self.email)
                .then(function(data) {
                    console.log(data);
                }, function(error) {
                    console.log(error);
                });
        }
    }

})();