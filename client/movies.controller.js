(function() {
  'use strict';
  angular.module('movieflix')
    .controller('MovieCtrl', MovieCtrl);

  MovieCtrl.$inject = ['$scope', 'MovieService', 'PaginationService', 'filterFilter'];

  function MovieCtrl($scope, MovieService, PaginationService, filterFilter) {
    var movieVM = this;
    $scope.PaginationService = PaginationService;
    movieVM.searchCriteria = 'All';
    movieVM.searchCriteriaLC = 'all';
    movieVM.changeSearchCriteria = changeSearchCriteria;
    movieVM.sorter = {
      sortBy: 'imdbRating',
      sortOrder: true
    };
    movieVM.movies = MovieService.getAllMovie()
      .then(function(response) {
          movieVM.movies = response;
          for (var i = 0; i < _.size(movieVM.movies); i++) {
            movieVM.movies[i].genre = movieVM.movies[i].genre.map(function(elem){
                                                                return elem.name;
                                                            }).join(", ");
            movieVM.movies[i].country = movieVM.movies[i].country.map(function(elem){
                                                                return elem.name;
                                                            }).join(", ");
            movieVM.movies[i].language = movieVM.movies[i].language.map(function(elem){
                                                                return elem.name;
                                                            }).join(", ");
            movieVM.movies[i].type = movieVM.movies[i].type.name;                                        
                    
          }
          movieVM.filteredmovies = movieVM.movies;
          $scope.PaginationService.TotalItems = _.size(movieVM.movies);
        },
        function(error) {
          console.log(error);
        });

    function changeSearchCriteria(criteria) {
      movieVM.searchCriteria = criteria;
      movieVM.searchCriteriaLC = _.toLower(criteria);
    }
    $scope.$watch('movieVM.searchText', function(toSearch) {
      var criteria = {};
      criteria[movieVM.searchCriteriaLC] = toSearch;
      if (movieVM.searchCriteriaLC === 'all') {
        movieVM.filteredmovies = filterFilter(_.values(movieVM.movies), toSearch);
      } else {
        movieVM.filteredmovies = filterFilter(_.values(movieVM.movies), criteria);
      }
      $scope.PaginationService.TotalItems = _.size(movieVM.filteredmovies);
    });
  }
})();