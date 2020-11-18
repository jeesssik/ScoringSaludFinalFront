package com.pf.scoringsalud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pf.scoringsalud.R;
import com.pf.scoringsalud.api.consumo.ApiPuntuable;
import com.pf.scoringsalud.api.infraestructura.StringValueCallback;

public class WaterActivity extends AppCompatActivity {
    Button btn_tutorial;
    Button inc,dec;
    TextView tV;
    int count =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);


    //boton antras (vuelve a la ultima acttivity vista
        findViewById(R.id.backBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

       inc= findViewById(R.id.btnPlus);
       dec= findViewById(R.id.btnLess);
       tV= findViewById(R.id.tv_agua);

       //llamada a api
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        ApiPuntuable ap = new ApiPuntuable();
        ap.actualizarPuntuable(user.getEmail(), "Agua", -1, getApplicationContext(), new StringValueCallback() {
            @Override
            public void onSuccess(String value) {
                tV.setText(value);
                count = Integer.parseInt(value);
            }

            @Override
            public void onFailure() {

            }
        });

       inc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               count++;
               //tV.setText(count +"");
               FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
               ApiPuntuable ap = new ApiPuntuable();
               ap.actualizarPuntuable(user.getEmail(), "Agua", count, getApplicationContext(), new StringValueCallback() {
                   @Override
                   public void onSuccess(String value) {
                       tV.setText(value);
                       count = Integer.parseInt(value);
                   }

                   @Override
                   public void onFailure() {

                   }
               });
           }
       });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>0) {
                    count--;
                    //tV.setText(count + "");
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    ApiPuntuable ap = new ApiPuntuable();
                    ap.actualizarPuntuable(user.getEmail(), "Agua", count, getApplicationContext(), new StringValueCallback() {
                        @Override
                        public void onSuccess(String value) {
                            tV.setText(value);
                            count = Integer.parseInt(value);
                        }

                        @Override
                        public void onFailure() {

                        }
                    });
                }
            }
        });



    }




}