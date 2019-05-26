package com.example.restclient;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
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


public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> implements View.OnClickListener {
    private View.OnClickListener listener;
    private Activity activity;
    public Recycler(Activity activity) {
        //theis contextr igual a acontext
        this.listatracks = new ArrayList<>();
        this.activity=activity;
    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    public void onClick(View v) {

        if (listener != null){

            listener.onClick(v);
        }

    }
    //private Context context;
    private List<Tracks> listatracks;

    public Recycler(List<Tracks> lsitatracks, Activity activity) {
        this.listatracks = lsitatracks;
        this.activity=activity;
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

        final Tracks track = listatracks.get(i);
        viewHolder.id.setText(track.getId());
        viewHolder.title.setText(track.getTitle());
        viewHolder.singer.setText(track.getSinger());
        viewHolder.id.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(activity.getApplicationContext(), segundaActivity.class);
                mIntent.putExtra("trackId", track.getId());
                activity.startActivity(mIntent);
            }
        });
    }

        ///  Picasso.with(context).load(element.getMunicipiEscut()).into(viewHolder.escutMuncipi);


    @Override
    public int getItemCount() {
        return listatracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraintLayout;
        private TextView id;
        private TextView title;
        private TextView singer;

        private Activity activity;

        public ViewHolder(View v) {
            super(v);

            constraintLayout = v.findViewById(R.id.constraintLayout);
            id = v.findViewById(R.id.id);
            title = v.findViewById(R.id.title);
            singer = v.findViewById(R.id.singer);


        }

    }
}
