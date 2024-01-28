package com.example.recyclerview1;


import java.util.ArrayList;
import java.util.List;

public class Datos {
    public static void main(String[] args) {
        List Lista;
        Lista = new ArrayList<ItemLista>();
        Lista.add(new ItemLista(R.drawable.pajaro1, "BUHO", "Búho es el nombre común de aves de la familia Strigidae, del orden de las estrigiformes o aves rapaces nocturnas. Habitualmente designa especies que, a diferencia de las lechuzas, tienen plumas alzadas que parecen orejas"));
        Lista.add(new ItemLista(R.drawable.pajaro2, "PINGUINO", "Los pingüinos (familia Spheniscidae, orden Sphenisciformes) son un grupo de aves marinas, no voladoras, que se distribuyen únicamente en el Hemisferio Sur, sobre todo en sus altas latitudes"));
    }
}