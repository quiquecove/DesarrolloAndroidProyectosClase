package com.example.datoscuriosos;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ListaHechos {

    public List<String> lista= new ArrayList<>();

    private String hechoAux="a";

    List<String> hechosVocales = new ArrayList<>();


    public void setLista(ArrayList<String> aux){
        this.lista.addAll(aux);

        for (String hecho : lista) {
            if (comienzaPorVocal(hecho)) {
                hechosVocales.add(hecho);
            }
        }

    }


    public String getHechoAleatorio() {
        int aux = (int) (Math.random() * lista.size());
        return lista.get(aux);
    }

    public String getHecho() {

        return lista.get(0);
    }

    public String getHechoAleatorioImpar() {
        int aux;
        do {
            aux = (int) (Math.random() * lista.size());
        } while (aux % 2 == 0);

        return lista.get(aux);
    }

    public String getHechoVocal() {
        String aux=this.hechoAux;

        if (this.hechosVocales.isEmpty()) {
            throw new NoSuchElementException("No se encontró ningún elemento que comience por vocal.");
        }
        while(aux.equals(this.hechoAux)){

            int aux2 = (int) (Math.random() * this.hechosVocales.size());

            aux = this.hechosVocales.get(aux2);

        }

        this.hechoAux = aux;
        return aux;
    }

    // Función auxiliar para verificar si una cadena comienza por vocal
    private boolean comienzaPorVocal(String cadena) {
            char primeraLetra = Character.toLowerCase(cadena.charAt(0));
            return "aeiou".contains(String.valueOf(primeraLetra));
    }
}
