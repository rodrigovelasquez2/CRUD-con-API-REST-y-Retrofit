package com.velasquez.crud_con_api_rest_y_retrofit.interfaces;

import com.velasquez.crud_con_api_rest_y_retrofit.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Metodo donde recibira el API REST
 */
public interface CRUD_interfaces {

    @GET("product")
    Call<List<Product>> getAll();

}//Fin CRUD_interfaces
