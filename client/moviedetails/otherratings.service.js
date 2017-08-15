(function() {
  'use strict';
  angular.module('movieflix')
    .service('OtherRatingsService', OtherRatingsService);

  OtherRatingsService.$inject = ['$q', '$http'];

  function OtherRatingsService($q, $http) {
    var self = this;

    self.getOtherRatingsID = getOtherRatingsID;

    self.getCurrentUserRatingsID = getCurrentUserRatingsID;
    
    self.postCurrentUserRatings = postCurrentUserRatings;
    
    self.putCurrentUserRatings = putCurrentUserRatings;
    
    self.getUserforRatings = getUserforRatings;

    function getUserforRatings(id) {  //userid 
      return $http.get('https://api.myjson.com/bins/'+id)  //'http://localhost:8080/api/users/ + id'
        .then(successFn, errorFn); 
    }

    function putCurrentUserRatings(id, obj) {  //movieid&userid 
      return $http.put(id, obj)  //'http://localhost:8080/api/ratings/ + id'
        .then(successFn, errorFn); 
    }

    function postCurrentUserRatings(obj) {  
      return $http.post('https://api.myjson.com/bins', obj)  //'http://localhost:8080/api/ratings/'
        .then(successFn, errorFn); 
    }

    function getCurrentUserRatingsID(id) {   //movieid&userid 
      return $http.get(id)  //'http://localhost:8080/api/ratings/ + id'
        .then(successFn, errorFn); 
    }

    function getOtherRatingsID(id) {   //movieid
      return $http.get('https://api.myjson.com/bins/1da20p')  //'http://localhost:8080/api/ratings/movie + id'
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