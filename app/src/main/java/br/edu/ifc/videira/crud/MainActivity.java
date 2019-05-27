package br.edu.ifc.videira.crud;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifc.videira.crud.beans.Person;
import br.edu.ifc.videira.crud.beans.PersonRequest;
import br.edu.ifc.videira.crud.utils.ApiClient;
import br.edu.ifc.videira.crud.utils.AppService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private List<Person> listaPessoas = new ArrayList<>();
    private ArrayAdapter arrayAdapterPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton btnAdd = findViewById(R.id.fbtnAdd);

        ListView listViewPessoas = (ListView) findViewById(R.id.listaPessoas);

        arrayAdapterPessoas = new ArrayAdapter<Person>(this, R.layout.activity_main, listaPessoas) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Inflate only once
                if(convertView == null) {
                    convertView = getLayoutInflater()
                            .inflate(R.layout.list_item, null, false);
                }

                Person p = listaPessoas.get(position);

                TextView textNome = convertView.findViewById(R.id.nomeItem);
                TextView textCpf = convertView.findViewById(R.id.cpfItem);

                convertView.setTag(p);

                textNome.setText(p.getNome());
                textCpf.setText(p.getCpf());

                return convertView;
            }
        };

        // pega conexão com a API via retrofit
        Retrofit retrofit = ApiClient.getRetrofit();

        // pega da classe AppService a rota que deve ser feito a requisição na API
        AppService service = retrofit.create(AppService.class);

        //Monta a URL para requisição e coloca numa classe CALL para rodar em uma thread separada
        Call<PersonRequest> callPeople = service.personList();

        // Coloca na fila para execução e quando respondida ou falha executa seus respectivos codigos
        callPeople.enqueue(new Callback<PersonRequest>() {
            @Override
            public void onResponse(Call<PersonRequest> call, Response<PersonRequest> response) {
                listaPessoas = response.body().getData();
                arrayAdapterPessoas.clear();
                arrayAdapterPessoas.addAll(listaPessoas);
                arrayAdapterPessoas.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PersonRequest> call, Throwable t) {
                System.out.println("**************** Error:" + t);
            }
        });



        listViewPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person p = (Person) view.getTag();

                Intent intent = new Intent(MainActivity.this, EditPersonActivity.class);
                intent.putExtra("id", p.getId());
                startActivity(intent);
            }
        });

        listViewPessoas.setAdapter(arrayAdapterPessoas);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPersonActivity.class);
                startActivity(intent);
            }
        });

    }

}
