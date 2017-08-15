(function() {

  angular.module('movieflix').controller('AddMoviePosterModalCtrl', AddMoviePosterModalCtrl);


  AddMoviePosterModalCtrl.$inject = ['$uibModal', '$scope', 'AddModalPosterServ'];

  function AddMoviePosterModalCtrl($uibModal, $scope, AddModalPosterServ) {
    $scope.AddModalPosterServ = AddModalPosterServ;
    var $ctrl = this;
    $ctrl.poster = AddModalPosterServ.poster;
    $ctrl.animationsEnabled = true;
    $ctrl.open = function() {
      var modalInstance = $uibModal.open({
        animation: $ctrl.animationsEnabled,
        ariaLabelledBy: 'modal-title',
        ariaDescribedBy: 'modal-body',
        templateUrl: 'addmovie/addMovieModal.tmpl.html',
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
        $scope.AddModalPosterServ.poster = newposter;
      }, function() {});
    };
  }

  angular.module('movieflix').controller('ModalInstanceCtrl', function($uibModalInstance, poster) {
    var $ctrl = this;
    $ctrl.poster = poster;

    $ctrl.ok = function() {
      $uibModalInstance.close($ctrl.poster);
    };
    $ctrl.cancel = function() {
      $uibModalInstance.dismiss('cancel');
    };
  });
})();