(function() {
    angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

    angular.module('movieflix').controller('CollapseDemoCtrl', function($scope) {
        $scope.isNavCollapsed = true;
    });

    angular.module('movieflix').service('ModalDemo', ModalDemo);

    function ModalDemo() {
        var modalVM = this;
        modalVM.poster = "http://ia.media-imdb.com/images/M/MV5BMTk2NTI1MTU4N15BMl5BanBnXkFtZTcwODg0OTY0Nw@@._V1_SX300.jpg";
    }

    angular.module('movieflix').controller('UserEditMovie', ['$scope', 'ModalDemo', UserEditMovie]);

    function UserEditMovie($scope, ModalDemo) {
        $scope.ModalDemo = ModalDemo;
        var usereditVM = this;
        usereditVM.poster = $scope.ModalDemo.poster;
        usereditVM.title = "Avengers: Age of Ultron";
        usereditVM.year = 2015;
        usereditVM.rate = 8.2
        usereditVM.isReadonly = false;
        usereditVM.max = 10;
        usereditVM.votes = 920458;
        usereditVM.rated = "PG-13";
        usereditVM.language = ['English', 'Russian'];
        usereditVM.country = ['USA', 'UK'];
        usereditVM.genre = ['Action', 'Adventure', 'Sci-Fi'];
        usereditVM.released = "2015-05-01";
        usereditVM.runtime = "141 min";
        usereditVM.director = ['Joss Whedon'];
        usereditVM.writer = ['Joss Whedon', 'Stan Lee (Marvel comics)', 'Jack Kirby (Marvel comics)'];
        usereditVM.actors = ['Robert Downey Jr.', 'Chris Hemsworth', 'Mark Ruffalo', 'Chris Evans'];
        usereditVM.awards = "1 win & 12 nominations.";
        usereditVM.type = "Movie";
        usereditVM.plot = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's Mightiest Heroes to stop the villainous Ultron from enacting his terrible plans.";
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
                templateUrl: 'modal.edit.tmpl.html',
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