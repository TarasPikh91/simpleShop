
$('input').css('border', 'none');

$(document).ready(function () {
    $('#logInFormLink').click(function(e) {
        $("#logInForm").delay(100).fadeIn(100);
        $("#signUpForm").fadeOut(100);
        $('#signUpFormLink').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
        console.log('hello');
    });
    $('#signUpFormLink').click(function(e) {
        $("#signUpForm").delay(100).fadeIn(100);
        $("#logInForm").fadeOut(100);
        $('#logInFormLink').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});