package com.example.datoscuriosos;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colores {

    public List<Integer> listColors;

    public int colorAux = 0;


    public void setLista(ArrayList<Integer> aux){

        listColors = new ArrayList();
        this.listColors.addAll(aux);
    }



    public ArrayList<String> listColors3 = new ArrayList<>(Arrays.asList(
            "#FF0000",
            "#008F39",
            "#0000FF"
    ));
    public ArrayList<String> listColors3_1 = new ArrayList<>();
    public ArrayList<String> listColors3_2 = new ArrayList<>();

    public int RandomColor() {

        int aux = (int) (Math.random() * listColors.size());


        return listColors.get(aux);
    }

    public int color() {
        String color = "#9A2A2A";
        return Color.parseColor(color);
    }


    public int color2() {
        int aux=this.colorAux;
        int aux2;

        while(this.colorAux==aux){

            aux2 = (int) (Math.random() * listColors3.size());
            aux = Color.parseColor(listColors3.get(aux2));

        }
        this.colorAux = aux;

        return aux;

    }
    public int color3() {
        int aux=this.colorAux;
        int aux2;

        while(this.colorAux==aux){

            aux2 = (int) (Math.random() * listColors.size());
            aux = listColors.get(aux2);

        }
        this.colorAux = aux;

        return aux;

    }

}
