package com.example.autochess_v2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HeroAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Hero>  heroList;

    public HeroAdapter(Context context, int layout, List<Hero> heroList) {
        this.context = context;
        this.layout = layout;
        this.heroList = heroList;
    }

    @Override
    public int getCount() {
        return heroList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtHeroName, txtHeroSpec, txtHeroClass, txtHeroCost;
        ImageView imgHeroAvatar;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder  = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtHeroName   = (TextView) convertView.findViewById(R.id.heroname);
            holder.txtHeroSpec   = (TextView) convertView.findViewById(R.id.herospec);
            holder.txtHeroClass  = (TextView) convertView.findViewById(R.id.heroclass);
            holder.txtHeroCost  = (TextView) convertView.findViewById(R.id.herocost);
            holder.imgHeroAvatar = (ImageView) convertView.findViewById(R.id.heroavatar);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Hero hero = heroList.get(i);

        holder.txtHeroName.setText(hero.getHeroName());
        holder.txtHeroSpec.setText(hero.getHeroSpec());
        holder.txtHeroClass.setText(hero.getHeroClass());
        holder.txtHeroCost.setText("" + hero.getHeroCost());

        return convertView;
    }
}
