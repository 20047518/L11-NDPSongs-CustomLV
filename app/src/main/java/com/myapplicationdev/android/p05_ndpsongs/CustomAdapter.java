package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super( context, resource, objects );
        this.context = context;
        this.layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View rowView = inflater.inflate( layout_id, parent, false );
        TextView tvYear = rowView.findViewById( R.id.tvYear );
        TextView tvTitle = rowView.findViewById( R.id.tvTitle );
        TextView tvSingers = rowView.findViewById( R.id.tvSingers );
        RatingBar rb = rowView.findViewById( R.id.rb );
        ImageView imageView = rowView.findViewById( R.id.imageView );

        Song currentVersion = versionList.get(position);
        tvYear.setText( String.valueOf(currentVersion.getYearReleased()) );
        tvTitle.setText( currentVersion.getTitle() );
        tvSingers.setText( currentVersion.getSingers() );
        rb.setRating( currentVersion.getStars());

        if (currentVersion.getYearReleased()>=2019) {
            imageView.setImageResource( R.drawable.new_image );
            imageView.setVisibility( View.VISIBLE );
        } else {
            imageView.setVisibility( View.INVISIBLE );
        }

        return  rowView;
    }
}
