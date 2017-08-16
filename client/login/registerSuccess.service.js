(function() {
    'use strict';

    angular.module('movieflix')
        .service('RegisterSuccessModal', RegisterSuccessModal);

    RegisterSuccessModal.$inject = ['$uibModal'];

    function RegisterSuccessModal($uibModal) {
        var serv = this;
        serv.animationsEnabled = true;
        serv.open = function() {
            var modalInstance = $uibModal.open({
                animation: serv.animationsEnabled,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: 'login/registerSuccessModal.tmpl.html',
                controller: 'ModalInstanceCtrl',
                controllerAs: 'serv'
            });

            modalInstance.result.then(function(newposter) {}, function() {});
        };
    }

    angular.module('movieflix').controller('ModalInstanceCtrl', function($uibModalInstance) {
        var serv = this;
        serv.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });

})();