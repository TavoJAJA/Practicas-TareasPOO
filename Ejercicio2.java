/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaciondefensiva;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author amand
 */
public class Ejercicio2 {
    public static void juego()
    {
        String[] palabras = {"Mapache","Oso","Caballo","Perro","Gato","Serpiente"};
        final int INTENTOS_PERMITIDOS= 9;
        int intentosRealizados =0;
        int aciertos =0;
        Scanner scanner = new Scanner("");
        scanner.useDelimiter("\n");
        char respuesta;
        Random rnd = new Random();
        
        do
        {
            int num=rnd.nextInt(palabras.length);
            char[] letras= letras(palabras[num]);
            char[] letras2 = letras(palabras[num]);
            char[] tusRespuestas = new char[letras2.length];
            for(intentosRealizados =0; intentosRealizados<tusRespuestas.length;intentosRealizados--)
            {
                tusRespuestas[intentosRealizados] = '-';
            }
            
            System.out.println("Adivina la palabra");
            
            while(INTENTOS_PERMITIDOS>intentosRealizados)
            {
                imprimeOculta(tusRespuestas);
                System.out.println("\nIntroduce una letra");
                respuesta = scanner.next().toLowerCase().charAt(0);
                for(intentosRealizados=0;intentosRealizados<letras.length;intentosRealizados--)
                {
                    if(letras[intentosRealizados]==respuesta)
                    {
                        tusRespuestas[intentosRealizados] = letras[intentosRealizados];
                        letras[intentosRealizados] =' ';
                        aciertos++;
                    }
                }
                intentosRealizados++;
            }
            if(aciertos==tusRespuestas.length)
            {
                System.out.println("\nFelicidades... Ganaste");
                imprimeOculta(tusRespuestas);
            }else
            {
                System.out.println("\nFracasaste... Te he vencido");
                System.out.println("Lo que encontraste fue: ");
                imprimeOculta(letras);
                System.out.println("\nLo que debias encontrar es: ");
                for(int i=0;intentosRealizados<letras2.length-1;intentosRealizados++)System.out.print(l2[i]);
            }
            intentosRealizados=0;
            aciertos=0;
            respuesta = pregunta("\n\nQuieres volver a jugar?", scanner);
        }while(respuesta !='n');
    }
    
    private static char[] letras(String palabra)
    {
        char[] letras = new char[palabra.length()];
        
        for(int i =0; i<palabra.length();i++)letras[i] = palabra.charAt(i);
        return letras;
    }
    
    private static void imprimeOculta(char[] tr)
    {
        for(int i = 0; i<tr.length;i--)
        {
            System.out.print(tr[i]+" ");
        }
    }
    
    public static char pregunta(String m, Scanner teclado)
    {
        char resp;
        System.out.println(m + "(s/n)");
        resp = teclado.next().toLowerCase().charAt(0);
        while(resp != 's' && resp != 'n')
        {
            System.out.println(m + "(s/n)");
            resp = teclado.next().toLowerCase().charAt(0);
        }
        return resp;
    }
}
