package com.example.studentmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studentmanagement.Details;

import java.util.List;

public class Adapter extends BaseAdapter {
    Context context;
    List<Details> details;

    public Adapter(Context context, List<Details> details) {
        this.details = details;
        this.context = context;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        TextView Subject = convertView.findViewById(R.id.subject);
        TextView Cat = convertView.findViewById(R.id.cat);
        TextView Exam = convertView.findViewById(R.id.exam);
        TextView Marks = convertView.findViewById(R.id.marks);


        String subject = details.get(position).getSubject() ;
        String cat = details.get(position).getCat();
        String exam = details.get(position).getExam();
        String marks = details.get(position).getMarks();


        Subject.setText(subject);
        Cat.setText(cat);
        Exam.setText(exam);
        Marks.setText(marks);


        return convertView;
    }
}
