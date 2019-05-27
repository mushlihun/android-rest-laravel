package br.edu.ifc.videira.crud.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.ifc.videira.crud.beans.Person;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://10.0.2.2:8000/api/";

    private static Retrofit retrofit = null;


    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new PersonDeserializer()).create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }


}
