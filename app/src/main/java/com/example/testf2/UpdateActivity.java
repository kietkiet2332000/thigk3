package com.example.testf2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {

    private TextInputEditText inputName;
    private TextInputEditText inputClass;
    private TextInputEditText inputStatus;
    private TextInputEditText inputWorking;
    private Button btnUpdate;
    private Button btnCancel;
    Intent intent;
    String url = "https://60b75c0217d1dc0017b89c97.mockapi.io/students/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        this.inputName = (TextInputEditText) findViewById(R.id.inputNameUpdate);
        this.inputClass = (TextInputEditText) findViewById(R.id.inputClassUpdate);
        this.inputStatus = (TextInputEditText) findViewById(R.id.inputStatusUpdate);
        this.inputWorking = (TextInputEditText) findViewById(R.id.inputWorkingUpdate);
        this.btnUpdate = (Button) findViewById(R.id.btnUpdateView);
        this.btnCancel = (Button) findViewById(R.id.btnCancel);

        com.example.testf2.Student student = (com.example.testf2.Student) intent.getSerializableExtra("student");
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PutApi(url,student.getId().toString());

            }
        });
       btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void PutApi(String url,String id) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.PUT, url + '/' + 28, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(com.example.testf2.UpdateActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(com.example.testf2.UpdateActivity.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", "Lâm");
                params.put("age", "30");

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
