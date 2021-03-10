package com.example.project1602;
/**
* CustomAdapter luokka 
* @author Samu Luoma
* apuna käytetty https://www.youtube.com/watch?v=VQKq9RHMS_0
*/
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList ylapaine, alapaine, syke, paino, aika;

    CustomAdapter(Context context,
                  ArrayList ylapaine,
                  ArrayList alapaine,
                  ArrayList syke,
                  ArrayList paino,
                  ArrayList aika){
        this.context = context;
        this.ylapaine = ylapaine;
        this.alapaine = alapaine;
        this.syke = syke;
        this.paino = paino;
        this.aika = aika;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ylapaine_txt.setText(String.valueOf(ylapaine.get(position)));
        holder.alapaine_txt.setText(String.valueOf(alapaine.get(position)));
        holder.syke_txt.setText(String.valueOf(syke.get(position)));
        holder.paino_txt.setText(String.valueOf(paino.get(position)));
        holder.aika_txt.setText(String.valueOf(aika.get(position)));

    }

    @Override
    public int getItemCount() {
        return ylapaine.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ylapaine_txt, alapaine_txt, syke_txt, paino_txt, aika_txt;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            ylapaine_txt = itemView.findViewById(R.id.ylapaine_txt);
            alapaine_txt = itemView.findViewById(R.id.alapaine_txt);
            syke_txt = itemView.findViewById(R.id.syke_txt);
            paino_txt = itemView.findViewById(R.id.paino_txt);
            aika_txt = itemView.findViewById(R.id.aika_txt);

        }
    }
}
