(function() {

  angular.module('movieflix').service('editMoviePosterModalService', editMoviePosterModalService);

  editMoviePosterModalService.$inject = [];

  function editMoviePosterModalService() {
    var modalVM = this;
    modalVM.poster = "https://s3.amazonaws.com/ankan/no-poster-available.jpg";
  }


})();