package br.edu.ifc.videira.crud.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import br.edu.ifc.videira.crud.beans.Person;

public class PersonDeserializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject obj = json.getAsJsonObject();

        Person person = new Person();
        person.setId(obj.get("id").getAsInt());
        person.setNome(obj.get("nome").getAsString());
        person.setCpf(obj.get("cpf").getAsString());
        person.setCreatedAt(obj.get("created_at").getAsString());
        person.setUpdatedAt(obj.get("updated_at").getAsString());

        return person;
    }
}
