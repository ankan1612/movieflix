(function() {
  'use strict';
  angular.module('movieflix')
    .directive('movieThumbnail', movieThumbnail);

  movieThumbnail.$inject = [];
  function movieThumbnail() {
    return {
      restrict: 'E',
      scope: {
        movieDetails: '=',
        callback: '&'
      },
      transclude: true,
      templateUrl: 'movielist/movieThumbnail.tmpl.html'
      // controller: 'MovieCtrl',
      // controllerAs: 'moviesVm',
      //bindToController: true,
      // link: function(scope, elem, attrs) {
      //   elem.on('click', function() {
      //     // console.log(scope.movieDetails.imdbId);
      //     // $location.path('/movies/' + scope.movieDetails.imdbId).replace();
      //     // scope.$apply();
      //   });
      // }
    };
  }
})();