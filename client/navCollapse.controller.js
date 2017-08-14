(function() {
  'use strict';
  angular.module('movieflix')
    .controller('NavCollapseContrl', NavCollapseContrl);

  NavCollapseContrl.$inject=['$scope']
  function NavCollapseContrl($scope) {
    $scope.isNavCollapsed = true;
  }
})();