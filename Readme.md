#TLDR
https://player.vimeo.com/video/710565446?h=214445ebcf&amp;badge=0&amp;autopause=0&amp;player_id=0&amp;app_id=58479

Mini tutorial de cucumber

Para crear un archivo de cucumber es:
clic derecho en el paquete steps -> New -> File -> ingresan el nombre del capability con la extensión ".steps"

El "Feature:" es el nombre del capability
El "Scenario:" es el nombre del caso de prueba a realizar
El "Given" es la precondición, Utilicen " Given being logged " para que inicie sesión automáticamente y ya uds trabajan en su parte a partir del When
El "When" Es el paso a realizar, si lo traducen tal cual sería por ejemplo "cuando ingreso mi informacion..."
El "And" es para agregar otro paso después del When
El "Then" Es para decir el resultado esperado

EL código se realizará en StepDefinitions (Señalar con un mensaje donde inicia y donde termina el código que hicieron)


Posible error: Duplicidad en java

@when I watch movies
public void IWatchMovies(){
    prender la tele
}
@when I watch movies
public void IWatchMovies(){
    cambiar el canal
}

Ahi marcaría error porque se está duplicando una misma oracion para diferentes acciones

Lo correcto es cambiar la oracion para que no marque error por ejemplo:

@when I watch movies on Tv
public void IWatchMovies(){
    prender la tele
}
@when I watch movies
public void IWatchMovies(){
    cambiar el canal
}

Para ejecutar un "Scenario" le dan clic en las flechitas verdes que están a la izquierda en el archivo de cucumber (.steps)
Si le dan clic a ejecutar en el "Feature" se ejecutarán todos los escenarios