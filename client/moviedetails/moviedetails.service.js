(function() {
  'use strict';
  angular.module('movieflix')
    .service('MovieDetailsService', MovieDetailsService);

  MovieDetailsService.$inject = ['$q', '$http'];

  function MovieDetailsService($q, $http) {
    var self = this;

    self.getMovieByID = getMovieByID;

    function getMovieByID(id) {
      return $http.get('https://api.myjson.com/bins/'+id)  //'http://localhost:8080/api/movies/ + id'
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