(function() {
  'use strict';
  angular.module('movieflix')
    .controller('EditMovieCtrl', EditMovieCtrl);

  EditMovieCtrl.$inject = ['EditMovieService', '$routeParams', '$scope', '$location', 'editMoviePosterModalService'];

  function EditMovieCtrl(EditMovieService, $routeParams, $scope, $location , editMoviePosterModalService) {
    var editMovieVM = this;
    $scope.editMoviePosterModalService = editMoviePosterModalService;
    editMovieVM.movie = {};
    editMovieVM.newMovie = {};
    editMovieVM.max = 10;
    editMovieVM.isReadonly = false;
    editMovieVM.updateChange = updateChange;
    editMovieVM.hoveringOver = function(value) {
      editMovieVM.overStar = value;
      editMovieVM.percent = 100 * (value / editMovieVM.max);
    };
    editMovieVM.movie = EditMovieService.getMovieByID($routeParams.id) //pass movieid
      .then(function(response) {
          editMovieVM.movie = response;
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

    function updateChange() {
      editMovieVM.newMovie.imdbId = editMovieVM.movie.imdbId;
      editMovieVM.newMovie.title = editMovieVM.movie.title;
      editMovieVM.newMovie.year = editMovieVM.movie.year;
      editMovieVM.newMovie.rated = editMovieVM.movie.rated;
      editMovieVM.newMovie.released = editMovieVM.movie.released;
      editMovieVM.newMovie.runtime = editMovieVM.movie.runtime;
      editMovieVM.newMovie.plot = editMovieVM.movie.plot;
      editMovieVM.newMovie.awards = editMovieVM.movie.awards;
      editMovieVM.newMovie.poster = editMovieVM.movie.poster;
      editMovieVM.newMovie.metascore = editMovieVM.movie.metascore;
      editMovieVM.newMovie.imdbRating = editMovieVM.movie.imdbRating;
      editMovieVM.newMovie.imdbVotes = editMovieVM.movie.imdbVotes;
      editMovieVM.newMovie.userRating = editMovieVM.movie.userRating;
      editMovieVM.newMovie.type = {};
      editMovieVM.newMovie.type.name = editMovieVM.movie.type;
      editMovieVM.newMovie.genre = [];
      editMovieVM.genres = editMovieVM.movie.genre.split(', ');
      editMovieVM.genres.forEach(function(item) {
        editMovieVM.newMovie.genre.push({
          "name": item
        });
      });
      editMovieVM.newMovie.language = [];
      editMovieVM.languages = editMovieVM.movie.language.split(', ');
      editMovieVM.languages.forEach(function(item) {
        editMovieVM.newMovie.language.push({
          "name": item
        });
      });
      editMovieVM.newMovie.country = [];
      editMovieVM.countries = editMovieVM.movie.country.split(', ');
      editMovieVM.countries.forEach(function(item) {
        editMovieVM.newMovie.country.push({
          "name": item
        });
      });
      editMovieVM.newMovie.actor = [];
      editMovieVM.actors = editMovieVM.movie.actor.split(', ');
      editMovieVM.actors.forEach(function(item) {
        editMovieVM.newMovie.actor.push({
          "name": item
        });
      });
      editMovieVM.newMovie.director = [];
      editMovieVM.directors = editMovieVM.movie.director.split(', ');
      editMovieVM.directors.forEach(function(item) {
        editMovieVM.newMovie.director.push({
          "name": item
        });
      });
      editMovieVM.newMovie.writer = [];
      editMovieVM.writers = editMovieVM.movie.writer.split(', ');
      editMovieVM.writers.forEach(function(item) {
        editMovieVM.newMovie.writer.push({
          "name": item
        });
      });
      EditMovieService.putMovieByID(editMovieVM.newMovie.imdbId, editMovieVM.newMovie)
        .then(function(response) {
            $location.path('/movies/' + editMovieVM.newMovie.imdbId);
        },
        function(error) {
          console.log(error);
        });
        
      
    }
  }
})();