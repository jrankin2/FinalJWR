$(function(){
    $('form').submit(function(e){
        console.log('form submitted...');
        $('.form-group [required]').each(function(){
            if($(this).val() === ''){
                e.preventDefault();
            }
        });
    });
    
});