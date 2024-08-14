document.addEventListener('DOMContentLoaded',function(){
    const mainAlert = document.querySelector('.alert');

    if (mainAlert) {
        setTimeout(()=> {
            mainAlert.classList.add('fade-out');
            setTimeout(() => mainAlert.remove(),1000); // Remover despues de la animacion fade-out

        }, 3000) // Tiempo en milisegundos antes de empezar a desaparecer
    }

});