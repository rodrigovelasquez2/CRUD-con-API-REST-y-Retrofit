package com.velasquez.crud_con_api_rest_y_retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.velasquez.crud_con_api_rest_y_retrofit.interfaces.CRUD_interfaces;
import com.velasquez.crud_con_api_rest_y_retrofit.models.Product;
import com.velasquez.crud_con_api_rest_y_retrofit.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Product> productos;
    CRUD_interfaces crudInterfaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Llamar al metodo:
        getAll();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    private void getAll() {
        Retrofit retoRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterfaces = retoRetrofit.create(CRUD_interfaces.class);
        Call<List<Product>> call = crudInterfaces.getAll();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()) { // Si no es exitoso
                    Log.e("RESPONDE ERR: >", response.message()); // imprimir
                    return;
                }//Fin if
                productos = response.body();
                productos.forEach(p -> Log.i("Prods: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable throwable) {
               Log.e("Throw err: ",throwable.getMessage()); // imprimir

            }
        });
    }//Fin getAll
}