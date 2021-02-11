package com.green_station_20.jsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText mobile, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile = findViewById(R.id.mobileId);
        password = findViewById(R.id.password);
        button = findViewById(R.id.btnId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonRequest();
            }
        });

    }

    private void jsonRequest() {

        String url = "https://alhasan.dev/interns/services/member-login.php";

        JSONObject params = new JSONObject();
        try {
            params.put("mobile", "01234567890");
            params.put("password", "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {

                    String Message = response.getString("Message");
                    String name = response.getString("name");
                    String institute = response.getString("institute");
                    String designation = response.getString("designation");
                    String mobile = response.getString("mobile");

                    Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
                    intent.putExtra("m", Message);
                    intent.putExtra("n", name);
                    intent.putExtra("i", institute);
                    intent.putExtra("d", designation);
                    intent.putExtra("m_b", mobile);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


              /*  for (int i = 0; i < response.length(); i++) {

                    try {

                        JSONObject jsonObject = response.getJSONObject(String.valueOf(i));
                        String Message = jsonObject.getString("Message");
                        String name = jsonObject.getString("name");
                        String institute = jsonObject.getString("institute");
                        String designation = jsonObject.getString("designation");
                        String mobile = jsonObject.getString("mobile");

                        Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
                        intent.putExtra("m", Message);
                        intent.putExtra("n", name);
                        intent.putExtra("i", institute);
                        intent.putExtra("d", designation);
                        intent.putExtra("m-b", mobile);

                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }*/

                Log.d("TAG", "onResponse: " + response);

               /* Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
                startActivity(intent);*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(objectRequest);

    }
}