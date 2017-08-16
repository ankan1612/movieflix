(function() {
    'use strict';
    angular.module('movieflix')
        .directive('emailUnique', emailUnique);

    emailUnique.$inject = ['$http', '$q'];

    function emailUnique($http, $q) {
        return {
            restrict: 'AE',
            require: 'ngModel',
            link: function(scope, elm, attr, model) {
                model.$asyncValidators.usernameExists = function() {
                    return $http({
                        url: 'http://localhost:8080/api/users/search',
                        method: "GET",
                        params: {
                            email: model.$viewValue
                        }
                    }).then(errorFn, successFn);

                    function successFn(response) {
                        return response.data; //resolve
                    }

                    function errorFn(error) {
                        return $q.reject(error); //reject
                    }

                };
            }
        };
    }

})();