package br.edu.ifc.videira.crud;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PersonList {


    @SerializedName("data")
    public List<Datum> data = new ArrayList();

    public class Datum {

        @SerializedName("id")
        public Integer id;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;

    }

}
