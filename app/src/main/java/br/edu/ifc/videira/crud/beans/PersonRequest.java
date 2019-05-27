package br.edu.ifc.videira.crud.beans;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonRequest {

    @SerializedName("data")
    @Expose
    private List<Person> data = null;

    public List<Person> getData() {
        return data;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }   

}
