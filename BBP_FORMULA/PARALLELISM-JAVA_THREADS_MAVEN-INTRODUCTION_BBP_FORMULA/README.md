# BBP Formula

## Compile and run instructions.
+ **Para compilar:** maven package
+ **Para ejecutar la clase principal:** mvn exec:java -Dexec.mainClass="edu.eci.arsw.math.Main"
+ **Para ejecutar las pruebas:** mvn test


## Part I - Introduction to Java Threads
1. Se completó la implementación adecuada de la clase CountThread: 
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/CountThread.png)

2. Se completo la implementación adecuada de la clase CountMainThreads: 
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/CountMainThreads.png)

Al iniciar la ejecución de los tres threads con la función start() se obtuvieron los siguientes resultados:  
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/start.png)

Al iniciar la ejecución de los tres threads con la función run() se obtuvieron los siguientes resultados:  
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/run.png)

+ Change the beginning with start() to run(). How does the output change? Why?  
Cuando iniciamos la ejecución de los tres Threads con el metodo start() pudimos 
notar que no tenia un orden predeterminado para la ejecución de los tres, en cambio 
con el metodo run() los tres Threads se ejecutan en el orden en que es ejecutada la linea.

## Part III - Performance Evaluation

#### 1. Un hilo

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/oneThread.png)

#### 2. Tantos hilos como procesadores(8)

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/eighthThread.png)

#### 3. El doble de hilos que de procesadores

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/doubleThread.png)

#### 4. Con 200 hilos

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/twoHundred.png)

#### 5. Con 500 hilos

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/fiveHundred.png)


Para poder registrar los tiempos decidimos realizarlo con 100000 datos de PI:
+ **Un hilo:** Este tomó 371730 milisegundos.
+ **Tantos hilos como procesadores(12):** Este tomó 67240 milisegundos.
+ **El doble de hilos que de procesadores:** Este tomó 48288 milisegundos.
+ **Con 200 hilos:** Este tomó 39406 milisegundos.
+ **Con 500 hilos:** Este tomó 39328 milisegundos.

#### Grafica de Tiempo VS numero de hilos.

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/grafica.png)


+ **According to Amdahls law, where S (n) is the theoretical performance improvement, P the parallel fraction of the algorithm, and n the number of threads, the greater n, the greater the improvement should be. Why is the best performance not achieved with the 500 threads? How does this performance compare when 200 are used?**  
Porque a partir de cierto punto, el tiempo que toma hacer el cambio de contexto entre los subprocesos supera el tiempo que estos tienen para ejecutar, por lo que aumentar el numero de estos genera un efecto contrario al supuesto por la formula 

+ **How does the solution behave using as many processing threads as cores compared to the result of using twice as much?**  
El tiempo necesario para conseguir la respuesta fue menor, además las gráficas del monitor muestran que en el caso con más hilos se generan menos valles en el uso del procesador, por lo que se podría decir que se tiene un mejor uso de este pues se mantiene a un nivel aproximado del 90% 

+ **According to the above, if for this problem instead of 500 threads on a single CPU, 1 wire could be used on each of 500 hypothetical machines, would Amdahls's law be better applied? If, instead, c threads were used in 500 / c distributed machines (where c is the number of cores of said machines), would it be improved? Explain your answer.**

1. En este caso el rendimiento si mejora puesto que cada máquina se encarga de problemas mucho más pequeños.
2. Si se utilizan C hilos por cada máquina el rendimiento se verá mejorado siempre y cuando C no sea demasiado grande, puesto que se puede presentar el mismo problema que con una maquina y generar que el tiempo en el cambio de contexto sea superior al tiempo que tiene el hilo para ejecutarse .Si se escoge un C óptimo cada hilo tendrá que solucionar porciones muy pequeñas del problema y además la maquina aprovecharía mejor su capacidad de procesamiento.
