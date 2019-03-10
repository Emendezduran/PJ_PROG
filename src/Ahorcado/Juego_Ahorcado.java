/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import java.util.Arrays;
import java.util.Scanner;
import proto.Game;

/**
 *
 * @author usuario
 */
public class Juego_Ahorcado implements Game {
    
    public static void main(String[] args) {
     
        
        Juego_Ahorcado j = new Juego_Ahorcado();
        j.startGame();
    }

    static Scanner scan = new Scanner(System.in);
    static String[] palabras = { "casa"};
    String palabra;
    char[] palabraOculta;
    int contador;
    final int TMAX = 7;

    @Override
    public void startGame() {
        System.out.println(palabra);
        while (!gameOver()) {
            System.out.println("RONDA " + contador);
            System.out.println(TMAX - contador);
            System.out.println(palabraOculta);
            char letraP = capturarLetra();
            if (verificarExistencia(letraP)) {
                sustituirLetra(letraP);
            } else {
                contador++;
            }
        }
        System.out.println(palabraOculta);
        System.out.println(gameOver());
    }
    
    public Juego_Ahorcado() {
        this.palabra = palabraAleatoria();
        this.palabraOculta = OcultarPalabra();
        contador = 0;
    }

    public static String palabraAleatoria() {
        int posicionRand = (int) Math.floor(Math.random() * palabras.length);
        String palabraRand = palabras[posicionRand];
        return palabraRand;
    }

    public char[] OcultarPalabra() {

        char[] letras = palabra.toCharArray();
        char[] letrasOcultas = new char[letras.length];
        for (int i = 0; i < letras.length; i++) {
            letrasOcultas[i] = '_';
        }
        return letrasOcultas;
    }

    public char capturarLetra() {
        imput
        System.out.println("Introduce una letra: ");
        char letraJugada = Character.toLowerCase(scan.next().charAt(0));
        return letraJugada;
    }

    public boolean verificarExistencia(char letra) {

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    }

    public void sustituirLetra(char letra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                palabraOculta[i] = letra;
            }
        }
    }

    public boolean gameOver() {
        if (Arrays.equals(palabra.toCharArray(), palabraOculta) || contador == TMAX) {
            return true;
        } else {
            return false;
        }

    }
}
