package com.example.restclient;
import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.constraint.ConstraintLayout;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import com.squareup.picasso.Picasso;

        import java.lang.reflect.Constructor;
        import java.util.ArrayList;
        import java.util.List;


public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {

    public Recycler() {
        //theis contextr igual a acontext
        this.listatracks = new ArrayList<>();
    }

    //private Context context;
    private List<Tracks> listatracks;

    public Recycler(List<Tracks> lsitatracks) {
        this.listatracks = lsitatracks;
    }


    public void rellenarLista(List<Tracks> ltracks) {
        listatracks.addAll(ltracks);
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtrack, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Tracks track = listatracks.get(i);
        viewHolder.id.setText(track.getId());
        viewHolder.title.setText(track.getTitle());
        viewHolder.singer.setText(track.getSinger());
        ///  Picasso.with(context).load(element.getMunicipiEscut()).into(viewHolder.escutMuncipi);
    }

    @Override
    public int getItemCount() {
        return listatracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraintLayout;
        private TextView id;
        private TextView title;
        private TextView singer;

        public ViewHolder(View v) {
            super(v);

            constraintLayout = v.findViewById(R.id.constraintLayout);
            id = v.findViewById(R.id.id);
            title = v.findViewById(R.id.title);
            singer = v.findViewById(R.id.singer);


        }

    }
}
