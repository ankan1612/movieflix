(function(){
    angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

    angular.module('movieflix').controller('CollapseDemoCtrl', function($scope) {
        $scope.isNavCollapsed = true;
    });

    angular.module('movieflix').controller('PaginationDemoCtrl', function ($scope, $log) {
        $scope.maxSize = 5;
        $scope.TotalItems = 100;
        $scope.CurrentPage = 1;
        $scope.itemsPerPage = 12;

        $scope.pageChanged = function() {
            $log.log('Page changed to: ' + $scope.CurrentPage);
        };


    });

})();