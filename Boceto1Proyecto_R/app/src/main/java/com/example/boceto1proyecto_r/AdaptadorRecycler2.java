package com.example.boceto1proyecto_r;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecycler2 extends RecyclerView.Adapter<AdaptadorRecycler2.ViewHolder> {
    private Context context;
    private List<String> nombresList;
    private List<String> descripcionesList;

    // Constructor
    public AdaptadorRecycler2(Context context) {
        this.context = context;
        this.nombresList = generarNombres();
        this.descripcionesList = generarDescripciones();
    }

    // Método para generar nombres de ejemplo
    private List<String> generarNombres() {
        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nombres.add("Usuario " + i);
        }
        return nombres;
    }

    // Método para generar descripciones de ejemplo
    private List<String> generarDescripciones() {
        List<String> descripciones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            descripciones.add("Descripción " + i);
        }
        return descripciones;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_ranking_v2, parent, false);
        view.setBackgroundResource(R.drawable.tarjeta_rate);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Configura las vistas con datos específicos de la tarjeta
        holder.imageView.setImageResource(R.drawable.persona1);  // Usa la misma imagen en todas las tarjetas
        holder.nombreuser.setText(nombresList.get(position));
        holder.descripcionEditText.setText(descripcionesList.get(position));
    }

    @Override
    public int getItemCount() {
        return nombresList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Declare las vistas dentro de la tarjeta aquí
        private CardView cardView;
        private ImageView imageView;
        private TextView nombreTextView;
        private TextView descripcionTextView, nombreuser;
        private EditText descripcionEditText;
        private TextView puntuacionTextView;
        private ImageView star1, star2, star3, star4, star5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializa las vistas aquí usando itemView.findViewById
            cardView = itemView.findViewById(R.id.cardv);
            imageView = itemView.findViewById(R.id.imageView3);
            nombreTextView = itemView.findViewById(R.id.etnombre);
            nombreuser = itemView.findViewById(R.id.nomb);
            descripcionTextView = itemView.findViewById(R.id.desc_public);
            descripcionEditText = itemView.findViewById(R.id.editTextTextMultiLine);
            puntuacionTextView = itemView.findViewById(R.id.punttv);

            // Inicializa las estrellas usando itemView.findViewById
            star1 = itemView.findViewById(R.id.star1);
            star2 = itemView.findViewById(R.id.star2);
            star3 = itemView.findViewById(R.id.star3);
            star4 = itemView.findViewById(R.id.star4);
            star5 = itemView.findViewById(R.id.star5);
        }
    }
}
