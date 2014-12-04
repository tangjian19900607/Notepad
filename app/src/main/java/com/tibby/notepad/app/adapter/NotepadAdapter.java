package com.tibby.notepad.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tibby.notepad.app.R;
import com.tibby.notepad.app.domain.Notepad;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:tibby tang
 * Created on 4/12/14.
 * Email:tangjian19900607@gmail.com
 * QQ:562980080
 */
public class NotepadAdapter extends BaseAdapter {
    private List<Notepad> mList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public NotepadAdapter(ArrayList<Notepad> list, Context context) {
        mList = list;
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    public List<Notepad> getData() {
        return this.mList;
    }

    public void setData(List<Notepad> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void addData(Notepad notepad) {
        this.mList.add(notepad);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.note_item, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(mList.get(position).getTitle());
        viewHolder.content.setText(mList.get(position).getContent());
        if (position % 2 == 0) {
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.green_normal));
        }else{
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.yellow_normal));
        }
        return convertView;
    }

    private static class ViewHolder {
        private TextView title;
        private TextView content;
    }

}
