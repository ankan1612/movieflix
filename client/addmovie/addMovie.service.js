(function() {
  'use strict';
  angular.module('movieflix')
    .service('AddMovieService', AddMovieService);

  AddMovieService.$inject = ['$q', '$http'];

  function AddMovieService($q, $http) {
    var self = this;

    self.postMovie = postMovie;

    function postMovie(obj) { 
      return $http.post('https://api.myjson.com/bins/', obj)  //'http://localhost:8080/api/movies/'
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