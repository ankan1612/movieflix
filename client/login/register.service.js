(function() {
    'use strict';
    angular.module('movieflix')
        .service('RegisterService', RegisterService);

    RegisterService.$inject = ['$q', '$http'];

    function RegisterService($q, $http) {
        var self = this;

        self.createNewUser = createNewUser;

        function createNewUser(user) {
            return $http.post('http://localhost:8080/api/users/', user)
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