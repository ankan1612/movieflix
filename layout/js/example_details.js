(function() {
    angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

    angular.module('movieflix').controller('CollapseDemoCtrl', function($scope) {
        $scope.isNavCollapsed = true;
    });

    angular.module('movieflix').controller('PaginationDemoCtrl', function($scope, $log) {
        $scope.maxSize = 5;
        $scope.TotalItems = 100;
        $scope.CurrentPage = 1;
        $scope.itemsPerPage = 12;

        $scope.pageChanged = function() {
            $log.log('Page changed to: ' + $scope.CurrentPage);
        };
    });

    angular.module('movieflix').controller('UserEditRating', UserEditRating);

    function UserEditRating() {
        var usereditVM = this;
        usereditVM.max = 5;
        usereditVM.isReadonly1 = true;
        usereditVM.isReadonly2 = false;
        usereditVM.comment1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        usereditVM.rating1 = 4;
        usereditVM.comment2 = usereditVM.comment1;
        usereditVM.rating2 = usereditVM.rating1;
        usereditVM.edit = false;
        usereditVM.hoveringOver = function(value) {
            usereditVM.overStar = value;
            usereditVM.percent = 100 * (value / usereditVM.max);
        };
    }

    angular.module('movieflix').controller('RatingDemoCtrl', function($scope) {
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