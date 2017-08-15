(function() {
  'use strict';
  angular.module('movieflix')
    .service('EditMovieService', EditMovieService);

  EditMovieService.$inject = ['$q', '$http'];

  function EditMovieService($q, $http) {
    var self = this;

    self.getMovieByID = getMovieByID;
    
    self.putMovieByID = putMovieByID;

    function getMovieByID(id) { //movieid
      return $http.get('https://api.myjson.com/bins/'+id)  //'http://localhost:8080/api/movies/ + id'
        .then(successFn, errorFn); 
    }
    
    function putMovieByID(id, obj) { //movieid, movieobj
      return $http.put('https://api.myjson.com/bins/'+id, obj)  //'http://localhost:8080/api/movies/ + id'
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