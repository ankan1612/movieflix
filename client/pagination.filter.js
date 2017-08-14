(function() {
  'use strict';
  angular.module('movieflix')
    .filter('startFrom', startFrom);

  startFrom.$inject = [];

  function startFrom() {
    return function(input, start) {
      start = +start; 
      return _.slice(input, start);
    };
  }
})();