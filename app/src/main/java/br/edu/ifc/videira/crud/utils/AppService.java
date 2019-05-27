package br.edu.ifc.videira.crud.utils;

import br.edu.ifc.videira.crud.beans.PersonRequest;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {

    @GET("people")
    Call<PersonRequest> personList();


}
