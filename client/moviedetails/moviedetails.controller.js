(function() {
  'use strict';
  angular.module('movieflix')
    .controller('MovieDetailsCtrl', MovieDetailsCtrl);

  MovieDetailsCtrl.$inject = ['MovieDetailsService', 'OtherRatingsService', '$routeParams', '$location'];

  function MovieDetailsCtrl(MovieDetailsService, OtherRatingsService, $routeParams, $location) {
    var movieDetailsVM = this;
    movieDetailsVM.bigmaxrate = 10;
    movieDetailsVM.smallmaxrate = 5;
    movieDetailsVM.useredit = {};
    movieDetailsVM.useredit.max = 5;
    movieDetailsVM.useredit.rating = 4;
    movieDetailsVM.useredit.comment = '';
    movieDetailsVM.useredit.edit = false;
    movieDetailsVM.useredit.isReadonly = true;
    movieDetailsVM.useredit.hoveringOver = function(value) {
      movieDetailsVM.useredit.overStar = value;
      movieDetailsVM.useredit.percent = 100 * (value / movieDetailsVM.useredit.max);
    };
    movieDetailsVM.routeparam = $routeParams.id; // not required
    movieDetailsVM.user = {
      "userId": "884b7fa4-18e6-468a-be02-4e1c7117953d",
      "firstName": "Ankan",
      "lastName": "Giri",
      "email": "ankan@gmail.com",
      "password": "ankan",
      "role": "USER"
    }; // get from cookie;
    movieDetailsVM.url = '';
    movieDetailsVM.postUserRating = postUserRating;
    movieDetailsVM.putUserRating = putUserRating;
    movieDetailsVM.newRating = {};
    movieDetailsVM.newRating.ratingScore = 0;
    movieDetailsVM.newRating.comments = '';
    movieDetailsVM.newRating.timeStamp = 213214343432;
    movieDetailsVM.movie = MovieDetailsService.getMovieByID($routeParams.id)
      .then(function(response) {
          movieDetailsVM.movie = response;
          movieDetailsVM.movieUnchanged = movieDetailsVM.movie;
          movieDetailsVM.movie.genre = movieDetailsVM.movie.genre.map(function(elem) {
            return elem.name;
          }).join(", ");
          movieDetailsVM.movie.country = movieDetailsVM.movie.country.map(function(elem) {
            return elem.name;
          }).join(", ");
          movieDetailsVM.movie.language = movieDetailsVM.movie.language.map(function(elem) {
            return elem.name;
          }).join(", ");
          movieDetailsVM.movie.director = movieDetailsVM.movie.director.map(function(elem) {
            return elem.name;
          }).join(", ");
          movieDetailsVM.movie.writer = movieDetailsVM.movie.writer.map(function(elem) {
            return elem.name;
          }).join(", ");
          movieDetailsVM.movie.actor = movieDetailsVM.movie.actor.map(function(elem) {
            return elem.name;
          }).join(", ");
          movieDetailsVM.movie.type = movieDetailsVM.movie.type.name;
        },
        function(error) {
          console.log(error);
        });
    movieDetailsVM.currentUserRatings = OtherRatingsService.getCurrentUserRatingsID($routeParams.id) //pass movieid&userid  
      .then(function(response) {
          movieDetailsVM.currentUserRatings = response;
          if (movieDetailsVM.currentUserRatings.id) {
            movieDetailsVM.foundCurrentUserRating = true;
          } else {
            movieDetailsVM.foundCurrentUserRating = false;
            movieDetailsVM.useredit.isReadonly = false;
          }
        },
        function(error) {
          movieDetailsVM.useredit.isReadonly = false;
          console.log(error);
        });
    movieDetailsVM.otherRatings = OtherRatingsService.getOtherRatingsID($routeParams.id)
      .then(function(response) {
          movieDetailsVM.otherRatings = response;
          movieDetailsVM.otherRatings.forEach(function(item) {
            item.user = OtherRatingsService.getUserforRatings(item.userId) //pass userid  
                        .then(function(res) {
                            item.user = res;
                          },
                          function(err) {
                            console.log(err);
                          });
          });
        },
        function(error) {
          console.log(error);
        });

    function getUserByRating(id) {
      return OtherRatingsService.getUserforRatings(id) //pass userid  
        .then(function(response) {
            return response;
          },
          function(error) {
            console.log(error);
          });
    }


    function postUserRating() {
      movieDetailsVM.newRating.id = {
        "movie": movieDetailsVM.movieUnchanged,
        "user": movieDetailsVM.user
      };
      OtherRatingsService.postCurrentUserRatings(movieDetailsVM.newRating)
        .then(function(response) {
            console.log(response.uri);
            movieDetailsVM.url = response.uri;
            movieDetailsVM.currentUserRatings = OtherRatingsService.getCurrentUserRatingsID(movieDetailsVM.url) // pass movieid&userid
              .then(function(response) {
                  movieDetailsVM.currentUserRatings = response;
                  if (movieDetailsVM.currentUserRatings.id) {
                    movieDetailsVM.foundCurrentUserRating = true;
                  } else {
                    movieDetailsVM.foundCurrentUserRating = false;
                  }
                },
                function(error) {
                  console.log(error);
                });
          },
          function(error) {
            console.log(error);
          });
    }

    function putUserRating() {
      OtherRatingsService.putCurrentUserRatings(movieDetailsVM.url, movieDetailsVM.currentUserRatings)
        .then(function(response) {
            movieDetailsVM.currentUserRatings = OtherRatingsService.getCurrentUserRatingsID(movieDetailsVM.url) // pass movieid&userid
              .then(function(response) {
                  movieDetailsVM.currentUserRatings = response;
                  if (movieDetailsVM.currentUserRatings.id) {
                    movieDetailsVM.foundCurrentUserRating = true;
                    movieDetailsVM.useredit.edit = false;
                  } else {
                    movieDetailsVM.foundCurrentUserRating = false;
                  }
                },
                function(error) {
                  console.log(error);
                });
          },
          function(error) {
            console.log(error);
          });
    }
  }
})();