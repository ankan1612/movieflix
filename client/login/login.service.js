(function() {
    'use strict';
    angular.module('movieflix')
        .service('LoginService', LoginService);

    LoginService.$inject = ['$q', '$http'];

    function LoginService($q, $http) {
        var self = this;

        self.authenticateUser = authenticateUser;

        function authenticateUser(e, p) {
            return $http({
                url: 'http://localhost:8080/api/users/authenticate',
                method: "GET",
                params: {
                        email: e,
                        password: p
                    }
                })
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