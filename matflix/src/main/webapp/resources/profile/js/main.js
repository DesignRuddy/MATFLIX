// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
    'use strict';
    window.addEventListener('load', function() {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName('needs-validation');
      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();
//

$('.collapse').collapse()
$('svg').click(function() {
  this.classList.toggle('rotated');
});


$(function(){
    $('.form-group').floatingLabel();
  });

  $('.form-group').floatingLabel({
      floatingLabelClass:'floating-label',
      floatingLabelOnClass:'floating-label-on',
      floatingInputClass:'floating-input'
    });

  $('.form-group').floatingLabel({
      floatingStyle:'primary'
    });
    
  