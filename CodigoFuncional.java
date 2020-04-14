import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    //FUNCION PARA PASAR A BINARIO
    
    public static String aBinario (int decimal){
	    int resultado=0;
	    String resString="";             //AL PRINCIPIO HICE METODO PARA QUE ME DEVOLVIERA UN INT, 
	                                     //PERO MAS TARDE SEGUN AVANZABA EL PROGRAMA VI NECESARIO O MAS FACIL QUE ME DEVOLVIERA UN STRING
	                                    //Y DE ESA MANERA PODER DEVOLVER POR EJEMPLO EL NUMERO 00000001 EN VEZ DE SOLO 1
	    
	    int provisional=decimal;
	    int vueltas=2;
	    
	    do{
	        provisional=provisional/2;
	        vueltas++;
	    }while(provisional/2!=1);
	    
	    int [] binario=new int[vueltas];
	    
	    for(int i=0; i<vueltas; i++){
	        if(decimal/2!=1){
	            binario[i]=decimal%2;
	        }else if(decimal/2==1) {
	        	binario[i]=decimal%2;
	        	binario[i+1]=decimal/2;
	        }
	        decimal=decimal/2;
	    }
	    
	    
	    int[] binarioOrdenado=new int[vueltas];
	    int j=vueltas-1;
	    
	    for(int i=0; i<vueltas; i++){
	        binarioOrdenado[i]=binario[j];
	        j--;
	    }
	    
	    for(int i=0; i<vueltas; i++){
	        resultado=resultado+binarioOrdenado[i];
	        if(i!=vueltas-1) {
	        	resultado=resultado*10;
	        }
	    }
	    
	    for(int i=0;i<7-vueltas;i++){
	        resString="0"+resString;
	    }
	    
	   
	    
	    resString=resString+resultado;
	
	    //System.out.println(resString);
	    
	    
	    /*
	    for(int i=0; i<vueltas; i++){
	    	System.out.print(binario[i]);
	    }
	    System.out.println();
	    for(int i=0; i<vueltas; i++){
	    	System.out.print(binarioOrdenado[i]);
	    }
	    */
	    
	    //return binarioOrdenado;
	    //return resultado;
	    return resString;
	    }
    
    

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        
        int [] decimal=new int[MESSAGE.length()];  //ESTE ARRAY ES PARA GUARDAR CADA CARACTER DEL MENSAJE EN SU FORMA DECIMAL EJ:(C se guarda como 67)
        
        
        
        for(int i=0; i<MESSAGE.length(); i++){ //METO LAS LETRAS DEL CODIGO EN EL ARRAY EN SU FORMA DECIMAL EJ:(C se guarda como 67)
            decimal[i]=(int)MESSAGE.charAt(i);
        }
        
  
        String cerosUnos=""; //EN ESTE STRING VOY A GUARDAR EL MENSAJE YA PASADO A CODIGO BINARIO
        
        for(int i=0; i<MESSAGE.length(); i++){ //SUMO UNO POR UNO LOS NUMEROS DECIMALES A UN STRING DE BINARIOS EN CADA VUELTA DE BUCLE
            
            String binario=aBinario(decimal[i]); //EN EL STRING BINARIO GUARDO EL EQUIVALENTE BINARIO (SIEMPRE DE 7 NUMEROS) AL NUMERO DECIMAL QUE SE ENCUENTRE EN i 
                                                //EJ:(EL BINARIO DE 37 ES 100101 PERPO SE GUARDARA COMO 0100101)
            cerosUnos=cerosUnos+binario;        //EN ESTE STRING ENCADENO TODOS LOS BINARIOS SIN SEPARACION NINGUNA ENTRE ELLOS  
            //System.out.println(cerosUnos);
        }
        
        
        int[] paraCodificar=new int[cerosUnos.length()]; //EN ESTE ARRAY METO EL STRING cerosUnos PERO EN FORMA DE ARRAY
        
        for(int i=0; i<cerosUnos.length(); i++){
            paraCodificar[i]=Integer.parseInt(String.valueOf(cerosUnos.charAt(i))); //Ej: EL STRING cerosUnos DE SER 1000011 PASARIA A SER EL ARRAY {1,0,0,0,0,1,1};
        }
        
        int posicion=0; //ESTA VARIABLE LA UTILIZARE EN EL SIGUIENTE BUCLE PARA NO MODIFICAR EL CONTADOR DEL BUCLE DENTRO DEL PROPIO BUCLE
            
            for(int j=0; j<paraCodificar.length; j++){ //ESTE BUCLE ES PARA RECORRER EL ARRAY E IR IMPRIMIENDO EL CODIGO FINAL SIMULTANEAMENTE
                                                        //EL BUCLE DARA SIMEMPRE MENOS VUELTAS QUE (paraCodificar.length) EL NUMERO DE VUELTAS DE BUCLE DEPENDERA DE LA VARIABLE posicion
                                                        //QUE ES LA VARIABLE QUE DETERMINA EN QUE POSICION DEL ARRAY NOS ENCONTRAMOS (POSIBLEMENTE ESTO SEA SACRILEGIO, PERO ES LA MANERA QUE HE ENCONTRADO DE HACER EL EJERCICIO)
                                                        
                int valorReferencia=paraCodificar[posicion]; //ESTA VARIABLE NOS VA A INDICAR SI EN LA POSICION EN LA QUE NOS ENCONTRAMOS DEL ARRAY HAY UN 1 O UN 0
                
                //VALOR REFERENCIA == 0
                
                if(posicion<paraCodificar.length){
                    if(valorReferencia==0){                   //SI EN LA POSICION EN LA QUE NOS ENCONTRAMOS DEL BUCLE HAY UN CREO
                        System.out.print("00 ");              //VAMOS A IMPRIMIR "00 "
                        int cuentaCeros=1;                    //ESTE CONTADOR NOS VA A INDICAR CUANTOS 0 SEGUIDOS HAY Ej: EN 100011 --- 1"000"11 VALDRA 3
                        if(posicion<paraCodificar.length-1){  //ESTE IF ME EVITA QUE EN LA CONDICION DEL SIGUIENTE WHILE SE INTENTE LEER UNA POSICION DEL ARRAY QUE NO EXISTE Y DE ERROR
                            while(paraCodificar[posicion+1]==0){
                                cuentaCeros++;                      //SI EL NUMERO SIGUIENTE ES UN 0 SUMAMOS UNA AL cuentaCeros Y AVANZAMOS UNA POSICION EN EL ARRAY
                                posicion++;                         //ESTO ES NECESARIO PORQUE SI HAY VARIOS CEROS SEGUIDOS, EN LAS SIGUIENTES VUELTAS DE BUCLE NO NECESITO LEERLOS PORQUE YA LOS HABRE IMPRIMIDO EN ALGUNA VUELTA ANTERIOR
                                if(posicion==paraCodificar.length-1){
                                    break;                          //ESTE BREAK EVITA QUE SE COMPARE LA POSICION SIGUIENTE DEL ARRAY QUE YA NO EXISTE 
                                }
                            }
                        }
                        for(int h=0;h<cuentaCeros;h++){
                            System.out.print("0");                  //IMPRIMO TODOS LOS CEROS QUE SE HAN CONTADO ANTERIORMENTE
                        }
                        if(posicion<paraCodificar.length-1){
                            System.out.print(" ");                  //IMPRIMO EL ESPACIO NECESARIO PARA LA CODIFICACION
                        }
                }
                
                
                //DE AQUI HACIA ABAJO EL CODIGO ES PRACTICAMENTE IGUAL SOLO QUE ME SIRVE PARA CODIFICAR LOS 1 EN VEZ DE LOS 0    
                //VALOR REFERENCIA == 1  
             
                if(posicion<paraCodificar.length){
                    if(valorReferencia==1){
                        System.out.print("0 ");
                        int cuentaUnos=1;
                        if(posicion<paraCodificar.length-1){
                            while(paraCodificar[posicion+1]==1){
                                cuentaUnos++;
                                posicion++; 
                                if(posicion==paraCodificar.length-1){
                                    break;
                                }
                            }
                        }
                        
                        for(int h=0;h<cuentaUnos;h++){
                            System.out.print("0");
                        }
                        if(posicion<paraCodificar.length-1){
                            System.out.print(" "); 
                        }
                    }
                }
                }
                    posicion++; //SUMO UNO A LA POSICION DEL ARRAY PORQUE EN LA SIGUIENTE VUELTA DE BUCLE LO NECESITARE
                                //EJ: SI EN EL NUMERO 1100001 ACABO DE CODIFICAR LOS 000 NECESITO QUE EN LA SIGUIENTE VUELTA DE BUCLE CODIFIQUE EL ULTIMO 1
                
                
                if(posicion==paraCodificar.length){ //ROMPO EL BUCLE SI LA POSICION EN LA QUE ME ENCUENTRO DEL ARRAY ES LA ULTIMA
                    break;                          //COMO EL QUE INDICA LA POSICION DEL ARRAY ES LA VARIABLE posicion Y ESTA AUMENTA VARIAS VECES EN UNA MISMA VUELTA
                }                                   //AL FINAL ME SOBRAN VUELTAS DEL BUCLE POR LO QUE TENGO QUE ROMPELO
            }
        
        
        
       /* for(int i=0; i<MESSAGE.length(); i++){ //PRUEBA
            System.out.println(decimal[i]);
        }*/

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println(aBinario(67));
    }
}