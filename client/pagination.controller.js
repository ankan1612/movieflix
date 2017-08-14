(function() {
  'use strict';
  angular.module('movieflix')
    .controller('PaginationCtrl', PaginationCtrl);

  PaginationCtrl.$inject = ['$scope','PaginationService'];

  function PaginationCtrl($scope, PaginationService) {
    var paginationVM = this;
    $scope.PaginationService = PaginationService;
    paginationVM.maxSize = 5;
    paginationVM.CurrentPage = 1;
    paginationVM.itemsPerPage = 12;
    
    
    
    paginationVM.pageChanged = function() {

    };
  }
})();