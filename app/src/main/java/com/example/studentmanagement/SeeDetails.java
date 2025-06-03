package com.example.studentmanagement;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studentmanagement.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SeeDetails extends AppCompatActivity {

    EditText StudentName;
    TextView txtsubject, txtcat, txtexam, txtmarks;
    LinearLayout Layout1, Layout2;
    ImageView see;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seedetails);

        StudentName = findViewById(R.id.Students);
        see = findViewById(R.id.See);

        Layout1 = findViewById(R.id.main1);
        Layout2 = findViewById(R.id.main2);

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveFromFirebase();
            }
        });
    }

    private void retrieveFromFirebase() {
        String studentname = StudentName.getText().toString().trim();

        if (studentname.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter student name", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getApplicationContext(), "Searching for: " + studentname, Toast.LENGTH_SHORT).show();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("details").child(studentname);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Layout1.setVisibility(View.GONE);
                    Layout2.setVisibility(View.VISIBLE);

                    Details details = dataSnapshot.getValue(Details.class);
                    if (details != null) {
                        String subject = details.getSubject();
                        String cat = details.getCat();
                        String exam = details.getExam();
                        String marks = details.getMarks();
                        txtsubject.setText(subject);
                        txtcat.setText(cat);
                        txtexam.setText(exam);
                        txtmarks.setText(marks);
                    } else {
                        Toast.makeText(getApplicationContext(), "Data not found!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No data found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(getApplicationContext(), "Database error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
