(function() {
    angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

    angular.module('movieflix').controller('CollapseDemoCtrl', function($scope) {
        $scope.isNavCollapsed = true;
    });

    angular.module('movieflix').service('ModalDemo', ModalDemo);

    function ModalDemo() {
        var modalVM = this;
        modalVM.poster = "https://s3.amazonaws.com/ankan/no-poster-available.jpg";
    }

    angular.module('movieflix').controller('UserEditMovie', ['$scope', 'ModalDemo', UserEditMovie]);

    function UserEditMovie($scope, ModalDemo) {
        $scope.ModalDemo = ModalDemo;
        var usereditVM = this;
        usereditVM.rate = 0
        usereditVM.isReadonly = false;
        usereditVM.max = 10;
        usereditVM.hoveringOver = function(value) {
            usereditVM.overStar = value;
            usereditVM.percent = 100 * (value / usereditVM.max);
        };
    }

    angular.module('movieflix').controller('ModalDemoCtrl', ['$uibModal', '$scope', 'ModalDemo', ModalDemoCtrl]);

    function ModalDemoCtrl($uibModal, $scope, ModalDemo) {
        $scope.ModalDemo = ModalDemo;
        var $ctrl = this;
        $ctrl.poster = ModalDemo.poster;
        $ctrl.animationsEnabled = true;
        $ctrl.open = function() {
            var modalInstance = $uibModal.open({
                animation: $ctrl.animationsEnabled,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: 'modal.add.tmpl.html',
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
                $scope.ModalDemo.poster = newposter;
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

    angular.module('movieflix').controller('RatingDemoCtrl', function($scope) {
        $scope.rate = 8.2;
        $scope.max = 10;
        $scope.isReadonly = false;

        $scope.hoveringOver = function(value) {
            $scope.overStar = value;
            $scope.percent = 100 * (value / $scope.max);
        };
    });

    angular.module('movieflix').controller('RatingFixedDemoCtrl', function($scope) {
        $scope.rate = 8.2;
        $scope.max = 10;
        $scope.isReadonly = true;

        $scope.hoveringOver = function(value) {
            $scope.overStar = value;
            $scope.percent = 100 * (value / $scope.max);
        };
    });

    angular.module('movieflix').controller('UserFixedRatingDemoCtrl', function($scope) {
        $scope.rate = 3;
        $scope.max = 5;
        $scope.isReadonly = true;

        $scope.hoveringOver = function(value) {
            $scope.overStar = value;
            $scope.percent = 100 * (value / $scope.max);
        };
    });

    angular.module('movieflix').controller('UserRatingDemoCtrl', function($scope) {
        $scope.rate = 0;
        $scope.max = 5;
        $scope.isReadonly = false;

        $scope.hoveringOver = function(value) {
            $scope.overStar = value;
            $scope.percent = 100 * (value / $scope.max);
        };
    });




})();