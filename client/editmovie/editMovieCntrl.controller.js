(function() {
  'use strict';
  angular.module('movieflix')
    .controller('EditMovieCtrl', EditMovieCtrl);

  EditMovieCtrl.$inject = ['EditMovieService', '$routeParams', '$scope', 'editMoviePosterModalService'];

  function EditMovieCtrl(EditMovieService, $routeParams, $scope, editMoviePosterModalService) {
    var editMovieVM = this;
    $scope.editMoviePosterModalService = editMoviePosterModalService;
    editMovieVM.movie={};
    editMovieVM.max=10;
    editMovieVM.isReadonly = false;
    editMovieVM.hoveringOver = function(value) {
      editMovieVM.overStar = value;
      editMovieVM.percent = 100 * (value / editMovieVM.max);
    };
    editMovieVM.movie = EditMovieService.getMovieByID($routeParams.id) //pass movieid
      .then(function(response) {
          editMovieVM.movie = response;
          editMovieVM.movieUnchanged = editMovieVM.movie;
          editMovieVM.movie.genre = editMovieVM.movie.genre.map(function(elem) {
            return elem.name;
          }).join(", ");
          editMovieVM.movie.country = editMovieVM.movie.country.map(function(elem) {
            return elem.name;
          }).join(", ");
          editMovieVM.movie.language = editMovieVM.movie.language.map(function(elem) {
            return elem.name;
          }).join(", ");
          editMovieVM.movie.director = editMovieVM.movie.director.map(function(elem) {
            return elem.name;
          }).join(", ");
          editMovieVM.movie.writer = editMovieVM.movie.writer.map(function(elem) {
            return elem.name;
          }).join(", ");
          editMovieVM.movie.actor = editMovieVM.movie.actor.map(function(elem) {
            return elem.name;
          }).join(", ");
          editMovieVM.movie.type = editMovieVM.movie.type.name;
          $scope.editMoviePosterModalService.poster = editMovieVM.movie.poster;
        },
        function(error) {
          console.log(error);
        });
  }
})();