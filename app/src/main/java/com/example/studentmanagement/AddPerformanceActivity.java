package com.example.studentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import androidx.appcompat.app.AppCompatActivity;

public class AddPerformanceActivity extends AppCompatActivity {
    EditText name, subject, cat, exam, marks;
    Button submitBtn;

    String strname, strsubject, strcat, strexam, strmarks;

    Details details;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_performance);

        name = findViewById(R.id.nameInput);
        subject = findViewById(R.id.subjectInput);
        cat = findViewById(R.id.catInput);
        exam= findViewById(R.id.examInput);
        marks = findViewById(R.id.marksInput);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strname = name.getText().toString();
                strsubject = subject.getText().toString();
                strcat = cat.getText().toString();
                strexam = exam.getText().toString();
                strmarks = marks.getText().toString();

                if (strname.isEmpty() || strsubject.isEmpty() ||
                        strcat.isEmpty() || strexam.isEmpty() || strmarks.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                name.setText("");
                subject.setText("");
                cat.setText("");
                exam.setText("");
                marks.setText("");

                Details details = new Details(strname, strsubject, strcat, strexam, strmarks);
                connectingToFirebase(details);

                Intent intent= new Intent(AddPerformanceActivity.this, SeeDetails.class);
                startActivity(intent);

                Toast.makeText(AddPerformanceActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void connectingToFirebase(Details details) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("details");
    }
}


