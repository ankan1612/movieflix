(function() {
  'use strict';
  angular.module('movieflix')

  .factory('PaginationService', PaginationService);

  PaginationService.$inject = [];

  function PaginationService() {
    return {
      TotalItems: 0
    };
  }
})();