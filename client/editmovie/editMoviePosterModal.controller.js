(function() {

  'use strict';
  angular.module('movieflix')
    .controller('EditMoviePosterModal', EditMoviePosterModal);

  EditMoviePosterModal.$inject = ['editMoviePosterModalService', '$uibModal', '$scope'];

  function EditMoviePosterModal(editMoviePosterModalService, $uibModal, $scope ) {
    $scope.editMoviePosterModalService = editMoviePosterModalService;
    var $ctrl = this;
    $ctrl.poster = $scope.editMoviePosterModalService.poster;
    $ctrl.animationsEnabled = true;
    $ctrl.open = function() {
      var modalInstance = $uibModal.open({
        animation: $ctrl.animationsEnabled,
        ariaLabelledBy: 'modal-title',
        ariaDescribedBy: 'modal-body',
        templateUrl: 'editmovie/modalPopUp.tmpl.html',
        controller: 'ModalInstanceCtrl',
        controllerAs: '$ctrl',
        resolve: {
          poster: function() {
            return $ctrl.poster;
          }
        }
      });

      modalInstance.result.then(function(newposter) {
        $ctrl.poster = newposter;
        $scope.editMoviePosterModalService.poster = newposter;
      }, function() {});
    };
  }

  angular.module('movieflix').controller('ModalInstanceCtrl', ModalInstanceCtrl);
  
  ModalInstanceCtrl.$inject=['$uibModalInstance', 'poster'];
  function ModalInstanceCtrl($uibModalInstance, poster) {
    var $ctrl = this;
    $ctrl.poster = poster;

    $ctrl.ok = function() {
      $uibModalInstance.close($ctrl.poster);
    };
    $ctrl.cancel = function() {
      $uibModalInstance.dismiss('cancel');
    };
  }

})();