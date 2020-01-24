# Laboratorio #1

**Estudiantes:** 
+ Carlos Manuel Murillo Ibañez
+ Juan Camilo Rojas Ortiz

## Compile and run instructions.
+ **Para compilar:** maven package
+ **Para ejecutar la clase principal:** mvn exec:java -Dexec.mainClass="edu.eci.arsw.math.Main"
+ **Para ejecutar las pruebas:** mvn test


## Part I - Introduction to Java Threads
1. Se completó la implementación de la clase CountThread:
![](img/CountThread.png)

2. Se completo la implementación de la clase CountMainThreads:
![](img/CountMainThreads.png)

+ Change the beginning with start() to run(). How does the output change? Why?
Cuando iniciamos la ejecución de los tres Threads con el metodo start() pudimos notar que no tenia un orden predeterminado para la ejecución de los tres, en cambio con el metodo run() los tres Threads se ejecutan en el orden en que es ejecutada la linea.