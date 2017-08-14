(function() {
  'use strict';
  angular.module('movieflix', ['ngAnimate', 'ngSanitize', 'ui.bootstrap', 'ngMessages', 'ngRoute']);

  angular.module('movieflix')
    .config(movieflixConfig, 'movieflixConfig');

  movieflixConfig.$inject = ['$routeProvider'];

  function movieflixConfig($routeProvider) {
    $routeProvider
      .when('/movies',{
        templateUrl: 'movielist.tmpl.html'
      })
      .when('/movies/:id',{
        templateUrl: 'moviedetails/moviedetails.tmpl.html'
      })
      .when('/movies/edit/:id',{
        templateUrl: 'editmovie/editmovie.tmpl.html'
      })
      .otherwise({ 
        redirectTo: '/movies'
      });

  }
})();