(function() {

  angular.module('movieflix').controller('AddMovieContrl', AddMovieContrl);

  AddMovieContrl.$inject = ['$scope', '$location', 'AddModalPosterServ','AddMovieService'];

  function AddMovieContrl($scope, $location, AddModalPosterServ, AddMovieService) {
    $scope.AddModalPosterServ = AddModalPosterServ;
    var addMovieVM = this;
    addMovieVM.movie = {};
    addMovieVM.movies={};
    addMovieVM.movie.imdbRating = 0;
    addMovieVM.isReadonly = false;
    addMovieVM.max = 10;
    addMovieVM.addMovie = addMovie;
    addMovieVM.hoveringOver = function(value) {
      addMovieVM.overStar = value;
      addMovieVM.percent = 100 * (value / addMovieVM.max);
    };
    addMovieVM.movie.title='';
    addMovieVM.movie.year='';
    addMovieVM.movie.imdbId='';
    addMovieVM.movie.imdbVotes='';
    addMovieVM.movie.rated='';
    addMovieVM.movies.language='';
    addMovieVM.movies.country='';
    addMovieVM.movies.genre='';
    addMovieVM.movies.actor='';
    addMovieVM.movies.director='';
    addMovieVM.movies.writer='';
    addMovieVM.movie.runtime='';
    addMovieVM.movie.released='';
    addMovieVM.movie.plot='';
    addMovieVM.movie.userRating=0.0;
    addMovieVM.movie.awards='';
    addMovieVM.movie.poster='';
    addMovieVM.movie.metascore='';
    addMovieVM.movies.type='';
    
    

    function addMovie() {
      addMovieVM.movie.type = {};
      addMovieVM.movie.type.name = addMovieVM.movies.type;
      addMovieVM.movie.genre = [];
      console.log(addMovieVM.movies.genre);
      var genres = addMovieVM.movies.genre.split(', ');
      genres.forEach(function(item) {
        addMovieVM.movie.genre.push({
          "name": item
        });
      });
      addMovieVM.movie.language = [];
      var languages = addMovieVM.movies.language.split(', ');
      languages.forEach(function(item) {
        addMovieVM.movie.language.push({
          "name": item
        });
      });
      addMovieVM.movie.country = [];
      var countries = addMovieVM.movies.country.split(', ');
      countries.forEach(function(item) {
        addMovieVM.movie.country.push({
          "name": item
        });
      });
      addMovieVM.movie.actor = [];
      var actors = addMovieVM.movies.actor.split(', ');
      actors.forEach(function(item) {
        addMovieVM.movie.actor.push({
          "name": item
        });
      });
      addMovieVM.movie.writer = [];
      var writers = addMovieVM.movies.writer.split(', ');
      writers.forEach(function(item) {
        addMovieVM.movie.writer.push({
          "name": item
        });
      });
      addMovieVM.movie.director = [];
      var directors = addMovieVM.movies.director.split(', ');
      directors.forEach(function(item) {
        addMovieVM.movie.director.push({
          "name": item
        });
      });
      addMovieVM.movie.poster=$scope.AddModalPosterServ.poster;
      console.log(addMovieVM.movie);
      AddMovieService.postMovie(addMovieVM.movie)
        .then(function(response) {
          console.log(response);
            $location.path('/movies');
          },
          function(error) {
            console.log(error);
          });
    }
  }
})();