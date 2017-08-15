(function() {
  'use strict';
  angular.module('movieflix')
    .service('MovieService', MovieService);

  MovieService.$inject = ['$q', '$http'];

  function MovieService($q, $http) {
    var self = this;

    self.getAllMovie = getAllMovie;

    function getAllMovie() {
      return $http.get('https://api.myjson.com/bins/rjqft')  //http://localhost:8080/api/movies/
        .then(successFn, errorFn); 
    }

    function successFn(response) {
      return response.data; //resolve
    }

    function errorFn(error) {
      return $q.reject(error); //reject
    }
  }
})();