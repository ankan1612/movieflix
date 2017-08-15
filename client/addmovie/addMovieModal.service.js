(function() {

  angular.module('movieflix').service('AddModalPosterServ', AddModalPosterServ);

  AddModalPosterServ.$inject = [];

  function AddModalPosterServ() {
    var modalVM = this;
    modalVM.poster = "https://s3.amazonaws.com/ankan/no-poster-available.jpg";
  }

})();