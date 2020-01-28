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

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/oneThread1.png)
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/oneThread.png)

#### 2. Tantos hilos como procesadores(8)

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/eighthThread1.png)
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/eighthThread.png)

#### 3. El doble de hilos que de procesadores

![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/doubleThread1.png)
![](https://github.com/Jcro15/lab1/blob/master/BBP_FORMULA/PARALLELISM-JAVA_THREADS_MAVEN-INTRODUCTION_BBP_FORMULA/img/doubleThread.png)

#### 4. Con 200 hilos

#### 5. Con 500 hilos
