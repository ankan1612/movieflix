/**
 * Created by Ankan on 8/3/2017.
 */
(function() {
    angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

    angular.module('movieflix').controller('CollapseDemoCtrl', function($scope) {
        $scope.isNavCollapsed = true;
    });

    angular.module('movieflix').controller('LoginBtnLoader', function() {
        var LoginBtnVM = this;
        LoginBtnVM.BtnText = "Login";
        LoginBtnVM.click = function() {
            LoginBtnVM.BtnText = " Logging..in";
        };
    });
    angular.module('movieflix').controller('RegisterBtnLoader', function() {
        var RegisterBtnVM = this;
        RegisterBtnVM.BtnText = "Register";
        RegisterBtnVM.click = function() {
            RegisterBtnVM.BtnText = " Registering..Please Wait!";
        };
    });

})();