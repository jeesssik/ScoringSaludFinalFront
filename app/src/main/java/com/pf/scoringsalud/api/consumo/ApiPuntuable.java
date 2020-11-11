package com.pf.scoringsalud.api.consumo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.pf.scoringsalud.api.Config;
import com.pf.scoringsalud.api.infraestructura.PuntuableEndPoint;
import com.pf.scoringsalud.api.interfaces.PuntuableApi;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiPuntuable {
    final Retrofit retrofit = new Retrofit.Builder().baseUrl(Config.URL_API)
            .addConverterFactory(GsonConverterFactory.create()).build();

    final PuntuableApi puntuableApi = retrofit.create(PuntuableApi.class);

    public void crearPuntuable(PuntuableEndPoint puntuable, final Class activityDestino, final Context actualContext) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Call<ResponseBody> call = puntuableApi.crearPuntuable(puntuable);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                    }
                    Log.i("Response body:", response.body().string());
                    Log.i("Response code: ", Integer.toString(response.code()));
                } catch (Exception e) {
                    Log.i("Excepcion", "register exception" + e.getMessage());
                    //Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String error = "Error de conexion, intente nuevamente";
                Toast.makeText(actualContext, error, Toast.LENGTH_SHORT).show();
                Log.i("Failure", t.toString());
            }
        });
    }

    public void actualizarPuntuable(final String mail, final String tipo, final int cantidad, final Class activityDestino, final Context actualContext) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Call<ResponseBody> call = puntuableApi.actualizarPuntuable(mail, tipo, cantidad);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                    }
                    Log.i("Response code: ", Integer.toString(response.code()));
                } catch (Exception e) {
                    Log.i("Excepcion", "register exception" + e.getMessage());
                    //Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String error = "Error de conexion, intente nuevamente";
                Toast.makeText(actualContext, error, Toast.LENGTH_SHORT).show();
                Log.i("Failure", t.toString());
            }
        });
    }

    public void obtenerPuntosDia(final String mail, final Class activityDestino, final Context actualContext) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Call<ResponseBody> call = puntuableApi.obtenerPuntosDia(mail);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                    }
                    Log.i("Response code: ", Integer.toString(response.code()));
                } catch (Exception e) {
                    Log.i("Excepcion", "register exception" + e.getMessage());
                    //Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String error = "Error de conexion, intente nuevamente";
                Toast.makeText(actualContext, error, Toast.LENGTH_SHORT).show();
                Log.i("Failure", t.toString());
            }
        });
    }

    public void obtenerReportes(final String mail, final String tipo, final Class activityDestino, final Context actualContext) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Call<ArrayList<ResponseBody>> call = puntuableApi.obtenerReportes(mail, tipo);
        call.enqueue(new Callback<ArrayList<ResponseBody>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseBody>> call1, Response<ArrayList<ResponseBody>> response) {
                try {
                    if (response.isSuccessful()) {

                    }
                    Log.i("Response code: ", Integer.toString(response.code()));
                } catch (Exception e) {
                    Log.i("Excepcion", "register exception" + e.getMessage());
                    //Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseBody>> call, Throwable t) {
                String error = "Error de conexion, intente nuevamente";
                Toast.makeText(actualContext, error, Toast.LENGTH_SHORT).show();
                Log.i("Failure", t.toString());
            }
        });
    }

    /*public void obtenerPuntuable(final String id, final Class activityDestino, final Context actualContext) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Call<Puntuable> call = puntuableApi.obtenerPuntuable(id);
        call.enqueue(new Callback<Puntuable>() {
            @Override
            public void onResponse(Call<Puntuable> call, Response<Puntuable> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.i("Successful", response.body().toString());
                    } else {
                        Log.i("Error parseo response: ", retrofit.baseUrl().toString() + response.code());
                    }
                    //goIntent(activityDestino, response, actualContext, mail);
                } catch (Exception e) {
                    Log.i("Exception catch onResponse: ", e.getMessage());
                    //goIntent(activityDestino, null, actualContext, mail);
                }
            }

            @Override
            public void onFailure(Call<Puntuable> call, Throwable t) {
                Log.i("Failure (OnFailure): ", t.toString());
                String error = "Error de conexion, intente nuevamente";
                Toast.makeText(actualContext, error, Toast.LENGTH_SHORT).show();
                //goIntent(activityDestino, null, actualContext, null);
            }
        });
    }*/

}