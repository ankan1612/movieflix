(function() {
  'use strict';
  angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap', 'ngMessages', 'ngRoute']);

  angular.module('movieflix')
    .config(movieflixConfig, 'movieflixConfig');

  movieflixConfig.$inject = ['$routeProvider'];

  function movieflixConfig($routeProvider) {
    $routeProvider
        .when('/login',{
            templateUrl: 'login/login.tmpl.html'
        })
        .when('/movies',{
        templateUrl: 'movielist/movielist.tmpl.html'
      })
      .when('/movies/:id',{
        templateUrl: 'moviedetails/moviedetails.tmpl.html'
      })
      .when('/edit/:id',{
        templateUrl: 'editmovie/editmovie.tmpl.html'
      })
      .when('/add',{
        templateUrl: 'addmovie/addMovie.tmpl.html'
      })
      .otherwise({ 
        redirectTo: '/login'
      });

  }
})();