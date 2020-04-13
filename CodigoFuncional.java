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
        
        int [] decimal=new int[MESSAGE.length()];
        String mensajeBin;
        
        
        for(int i=0; i<MESSAGE.length(); i++){ //METO LAS LETRAS EN UN ARRAY PASANDOLAS A DECIMAL
            decimal[i]=(int)MESSAGE.charAt(i);
        }
        
  
        String cerosUnos="";
        for(int i=0; i<MESSAGE.length(); i++){ //PASO UNO POR UNO LOS NUMEROS DECIMALES A UN String DE BINARIOS EN CADA VUELTA DE BUCLE
            
            String binario=aBinario(decimal[i]);
            
            cerosUnos=cerosUnos+binario;
            //System.out.println(cerosUnos);
        }
        
        
        int[] paraCodificar=new int[cerosUnos.length()];
        
        for(int i=0; i<cerosUnos.length(); i++){
            paraCodificar[i]=Integer.parseInt(String.valueOf(cerosUnos.charAt(i)));
        }
        
        ///////////////////////77
        //int [] paraCodificar={1,0,0,0,0,1,1};
        /////////////77
        
        
        
        /*for(int i=0; i<cerosUnos.length(); i++){
            System.out.println(paraCodificar[i]);
        }*/
        
        
        int posicion=0;
            
            for(int j=0; j<paraCodificar.length; j++){
                
                int valorReferencia=paraCodificar[posicion]; //
                
                //VALOR REFERENCIA == 0
                
                if(posicion<paraCodificar.length){
                    if(valorReferencia==0){
                        System.out.print("00 ");
                        int cuentaCeros=1;
                        if(posicion<paraCodificar.length-1){
                            while(paraCodificar[posicion+1]==0){
                                cuentaCeros++;
                                posicion++;
                                if(posicion==paraCodificar.length-1){
                                    break;
                                }
                            }
                        }
                        for(int h=0;h<cuentaCeros;h++){
                            System.out.print("0");
                        }
                        if(posicion<paraCodificar.length-1){
                            System.out.print(" "); 
                        }
                }
                    
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
      
                if(posicion<paraCodificar.length){
                    posicion++;
                }
                if(posicion==paraCodificar.length){
                    break;
                }
            }
        
        
        
       /* for(int i=0; i<MESSAGE.length(); i++){ //PRUEBA
            System.out.println(decimal[i]);
        }*/

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println(aBinario(67));
    }
}