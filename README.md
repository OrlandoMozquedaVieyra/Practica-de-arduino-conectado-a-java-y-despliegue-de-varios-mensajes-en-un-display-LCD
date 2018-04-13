# Practica de arduino conectado a java y despliegue de varios mensajes en un display LCD

Se desarrollara un programa para poder hacer la comunicacion
del arduino hacia lenguaje java. Con esto vamos a poder enviar
y recibir datos desde arduino hacia java. Tambien contara con
varios mensajes desplegados en la pantalla LCD como son temperatura y
humedad que seran leidos desde el sensro DHT11 en el primer mensaje,
el segundo mensaje se desplegara la hora y fecha que estaran programas
con un contador y el ultimo mensaje que desplegara LCD sera, lo que envie
de java en texto hacia el arduino la va desplegar el texto pero primero debera
convertir lo que recibe en lenguaje ASCII convertirlo al caracter que pertenece
y asi poder tener el mensaje enviado.

Tambien podremos poder checar el programa desarrollado en java para crear la
interfaz de comunicacion con arduino. deben incluir la libreria PanamaHitek_Arduino-3.0.0
para poder hacer la conexion desde java hacia el serial del arduino. Esta libreria
esta incluida en el proyecto del repositorio.

Esta incluido tambien el diagrama del circuito utilizado para este proyecto desarrollado.

![diagrama del circuito](https://user-images.githubusercontent.com/22648194/38740527-6a34fffe-3efd-11e8-9600-7c3d105614b4.png)
