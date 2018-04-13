/*
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
 */
//Llamamos a la libreria de los sensores DHT instalada previamente
#include <dht.h>

//Llamamos a la libreria para controlar el LCD incluida en el IDE de Arduino
#include <LiquidCrystal.h>

//Definimos los pines asignados al LCD según el esquema de conexión
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

//definimos el objeto para poder traer el dato del sensor DHT11
dht DHT;

//Definimos el pin de Arduino al que conectamos el pin de datos del sensor e indicamos el tipo de sensor (DHT11)
#define DHT11_PIN 7

//iniciamos la variable que leara el dato de la comunicacion
String entrada;

//Definimos las variables del reloj
int mit = 10, seg=1, hor=9;

//Definimos la variable del contador
int cont=1;

//Definimos las variables de la fecha
int dia=12,mes=4,ano=2018;

void setup(){    
  //Iniciamos la comunicacion del serial
  Serial.begin(9600);

  //Indicamos el LCD que usamos: 16 caracteres y 2 lineas
  lcd.begin(16, 2);
}

void loop(){
  //Aqui se despliega la temperatura y humedad en el display
  if(cont == 1){
    //limpiar el display
    lcd.clear();
    //Mostramos la información obtenida (temperatura y humedad) en el Monitor Serial
    int chk = DHT.read11(DHT11_PIN);
    //Situamos el cursor en la posicion 0 de la primera linea
    lcd.setCursor(0,0); 
    lcd.print("Temp:");
    lcd.print(DHT.temperature);    
    //Editamos el simbolo de los grados º
    lcd.print((char)223);
    lcd.print("C");
    lcd.setCursor(0,1);
    lcd.print("Hum:");
    lcd.print(DHT.humidity);
    lcd.print("%");  
  }
  /*Aqui se lleva un contador de la hora y fecha como 
  tambien se va hacer el despliegue del mensaje en el display*/
  if(cont == 3){            
    if(seg > 59){
      mit++;
      seg=0;  
    }
    if(mit > 59){
      hor++;
      mit=0;  
    }
    //Aqui se lleva una decision para poder incrementar el dia
    if(hor == 23 && mit == 59 && seg == 59){
      dia++;
    }
    //Aqui se lleva una decision para poder incrementar el mes
    if(dia == 31 && mes == 1 || dia == 31 && mes == 3 || dia == 31 && mes == 5 || dia == 31 && mes == 7 || dia == 31 && mes == 8 || dia == 31 && mes == 10 && hor == 23 && mit == 59 && seg == 59){
      mes++;
      dia=1;  
    }else if(dia == 30 && mes == 4 || dia == 30 && mes == 6 || dia == 30 && mes == 9 && hor == 23 && mit == 59 && seg == 59){
      mes++;
      dia=1;
    }else if(dia == 28 && mes == 2 && hor == 23 && mit == 59 && seg == 59){
      mes++;
      dia=1;
    }
    //Aqui se lleva una decision para poder incrementar el mes
    if(dia == 31 && mes == 12 && hor == 23 && mit == 59 && seg == 59){
      ano++;
      mes=1;
    }
    //Limpiar el display
    lcd.clear();
    //Mostramos la información obtenida (temperatura y humedad) en el Monitor Serial
    int chk = DHT.read11(DHT11_PIN);
    //Situamos el cursor en la posicion 0 de la primera linea
    lcd.setCursor(0,0); 
    lcd.print("HORA: ");
    if(hor < 10){        
      lcd.print("0");      
    }
    lcd.print(hor);
    lcd.print(":");
    if(mit < 10){
      lcd.print("0");
    }    
    lcd.print(mit);
    if(hor<12){
      lcd.print(" AM");
    }else{
      lcd.print(" PM"); 
    }

    lcd.setCursor(0,1);
    lcd.print("Fecha:");
    lcd.print(dia);
    lcd.print("/");
    lcd.print(mes);
    lcd.print("/");
    lcd.print(ano);    
  }
  //Aqui se despliega el mensaje en el display
  if(cont == 5){
    //Se manda al metodo Decimal_to_ASCII el dato que recibe por el serial
    while(Serial.available()>0){//Ciclo que se ejecutará mientras halla caracteres que se puedan leer en el puerto Serie
      //En la comunicación serial se envían los mensajes caracter a caracter, por lo que tenemos que leerlos 1 a 1
      //Serial.available() indica la canidad de caracteres disponibles. //Este while no se romperá hasta que se halla leido todo.
      entrada = entrada+Decimal_to_ASCII(Serial.read());        
    }
    //Limpiar el display
    lcd.clear();
    lcd.setCursor(0,0);
    lcd.print("Bienvenido"); 

    //Se guarda el tamaño de la vaiable
    int contador = entrada.length();
    for(int i = contador;i>0;i--){
      //extraemos los caracteres
      String texto = entrada.substring(i-1);  

      //Situamos el cursor
      lcd.setCursor(0,1); 
      //Escribimos el texto   
      lcd.print(texto);           
      //Esperamos
      delay(350);
    }    
    //Se limpia la variable mensaje. Esto evitará que 
    //se imprima algo en el LCD si no se ha enviado algún mensaje.    
    entrada=""; 
  }
  if(cont == 6){
    cont = 0;
  }  
  
  //lee la temperatura desde el sensor
  float t = DHT.temperature;     
  
  //Se manda el valor por el Serial
  Serial.println(t);   

  /*Iniciamos el contador para poder mostrar
  en LCD los tres tipos de mensaje que fueron creados*/
  cont++;
  /*Iniciamos el contador del segundos para que empiece a
  contar los segundos y inicie tambien el reloj  */
  seg++;
  delay(1000);  
}

/*Creamos este metodo para poder trasnformar la entrada que recibe en codigo ASCII
Ponerlo el caracter que tiene en el lenguaje ASCII*/
char Decimal_to_ASCII(int entrada){
  char salida=' ';
  switch(entrada){
    case 32: 
      salida=' '; 
    break; 
    case 33: 
      salida='!'; 
    break; 
    case 34: 
      salida='"'; 
    break; 
    case 35: 
      salida='#'; 
    break; 
    case 36: 
      salida='$'; 
    break; 
    case 37: 
      salida='%'; 
    break; 
    case 38: 
      salida='&'; 
    break; 
    case 39: 
      salida=' '; 
    break; 
    case 40: 
      salida='('; 
    break; 
    case 41: 
      salida=')'; 
    break; 
    case 42: 
      salida='*'; 
    break; 
    case 43: 
      salida='+'; 
    break; 
    case 44: 
      salida=','; 
    break; 
    case 45: 
      salida='-'; 
    break; 
    case 46: 
      salida='.'; 
    break; 
    case 47: 
      salida='/'; 
    break; 
    case 48: 
      salida='0'; 
    break; 
    case 49: 
      salida='1'; 
    break; 
    case 50: 
      salida='2'; 
    break; 
    case 51: 
      salida='3'; 
    break; 
    case 52: 
      salida='4'; 
    break; 
    case 53: 
      salida='5'; 
    break; 
    case 54: 
      salida='6'; 
    break; 
    case 55: 
      salida='7'; 
    break; 
    case 56: 
      salida='8'; 
    break; 
    case 57: 
      salida='9'; 
    break; 
    case 58: 
      salida=':'; 
    break; 
    case 59: 
      salida=';'; 
    break; 
    case 60: 
      salida='<'; 
    break; 
    case 61: 
      salida='='; 
    break; 
    case 62: 
      salida='>'; 
    break; 
    case 63: 
      salida='?'; 
    break; 
    case 64: 
      salida='@'; 
    break; 
    case 65: 
      salida='A'; 
    break; 
    case 66: 
      salida='B'; 
    break; 
    case 67: 
      salida='C'; 
    break; 
    case 68: 
      salida='D'; 
    break; 
    case 69: 
      salida='E'; 
    break; 
    case 70: 
      salida='F'; 
    break; 
    case 71: 
      salida='G'; 
    break; 
    case 72: 
      salida='H'; 
    break; 
    case 73: 
      salida='I'; 
    break; 
    case 74: 
      salida='J'; 
    break; 
    case 75: 
      salida='K'; 
    break; 
    case 76: 
      salida='L'; 
    break; 
    case 77: 
      salida='M'; 
    break; 
    case 78: 
      salida='N'; 
    break; 
    case 79: 
      salida='O'; 
    break; 
    case 80: 
      salida='P'; 
    break; 
    case 81: 
      salida='Q'; 
    break; 
    case 82: 
      salida='R'; 
    break; 
    case 83: 
      salida='S'; 
    break; 
    case 84: 
      salida='T'; 
    break; 
    case 85: 
      salida='U'; 
    break; 
    case 86: 
      salida='V'; 
    break; 
    case 87: 
      salida='W'; 
    break; 
    case 88: 
      salida='X'; 
    break; 
    case 89: 
      salida='Y'; 
    break; 
    case 90: 
      salida='Z'; 
    break; 
    case 91: 
      salida='['; 
    break; 
    case 92: 
      salida=' '; 
    break; 
    case 93: 
      salida=']'; 
    break; 
    case 94: 
      salida='^'; 
    break; 
    case 95: 
      salida='_'; 
    break; 
    case 96: 
      salida='`'; 
    break; 
    case 97: 
      salida='a'; 
    break; 
    case 98: 
      salida='b'; 
    break; 
    case 99: 
      salida='c'; 
    break; 
    case 100: 
      salida='d'; 
    break; 
    case 101: 
      salida='e'; 
    break; 
    case 102: 
      salida='f'; 
    break; 
    case 103: 
      salida='g'; 
    break; 
    case 104: 
      salida='h'; 
    break; 
    case 105: 
      salida='i'; 
    break; 
    case 106: 
      salida='j'; 
    break; 
    case 107: 
      salida='k'; 
    break; 
      case 108: 
    salida='l'; 
    break; 
    case 109: 
      salida='m'; 
    break; 
    case 110: 
      salida='n'; 
    break; 
    case 111: 
      salida='o'; 
    break; 
    case 112: 
      salida='p'; 
    break; 
    case 113: 
      salida='q'; 
    break; 
    case 114: 
      salida='r'; 
    break; 
    case 115: 
      salida='s'; 
    break; 
    case 116: 
      salida='t'; 
    break; 
    case 117: 
      salida='u'; 
    break; 
    case 118: 
      salida='v'; 
    break; 
    case 119: 
      salida='w'; 
    break; 
    case 120: 
      salida='x'; 
    break; 
    case 121: 
      salida='y'; 
    break; 
    case 122: 
      salida='z'; 
    break; 
    case 123: 
      salida='{'; 
    break; 
    case 124: 
      salida='|'; 
    break; 
    case 125: 
      salida='}'; 
    break; 
    case 126: 
      salida='~'; 
    break; 
  }
return salida;
}

