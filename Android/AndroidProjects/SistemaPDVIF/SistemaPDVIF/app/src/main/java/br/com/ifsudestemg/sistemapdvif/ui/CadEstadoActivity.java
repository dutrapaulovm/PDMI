package br.com.ifsudestemg.sistemapdvif.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.ifsudestemg.sistemapdvif.R;
import br.com.ifsudestemg.sistemapdvif.ResultCodeActivity;
import br.com.ifsudestemg.sistemapdvif.databinding.ActivityCadEstadoBinding;
import br.com.ifsudestemg.sistemapdvif.domain.AppDatabase;
import br.com.ifsudestemg.sistemapdvif.domain.EstadoDAO;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Estado;

public class CadEstadoActivity extends AppCompatActivity {
    /**
     * Classe gerada pelo Android para que possamos
     * acessar os componentes da interface sem precisar
     * declarar os objetos utilizando o método findViewById
     */
    private ActivityCadEstadoBinding binding;
    /**
     * O objeto estado é utilizado para armazenar os dados
     * do cadastro para ser enviado par ao banco de dados
     */
    private Estado estado;

    //Objeto utilizado para realizar as operações da base dados
    private EstadoDAO estadoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Configurando o recurso de Binding
         */
        binding = ActivityCadEstadoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AppDatabase db = AppDatabase.getDatabase(this);
        estadoDAO = db.estadoDAO();

        /**
         * Recuperando parâmetros enviados de outro Activity
         */
        Intent it = getIntent();
        if (it != null){
            /**
             * Para recuperar um objeto devemos converter para o
             * tipo apropriado.
             */
            if (it.hasExtra("ITEM")) {
                estado = (Estado) it.getSerializableExtra("ITEM");
                binding.edtNome.setText(estado.nome);
                binding.edtSigla.setText(estado.sigla);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_confirmarcancelar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_confirmar:

                if (estado == null){
                    estado = new Estado();
                    estado = popularObjeto(estado);
                    estadoDAO.inserir(estado);
                }
                else{
                    estado = popularObjeto(estado);
                    estadoDAO.atualizar(estado);
                }

                setResult(ResultCodeActivity.OK);
                finish();

            case android.R.id.home:
                setResult(ResultCodeActivity.CANCEL);
                finish();
                break;

            case R.id.action_cancelar:
                setResult(ResultCodeActivity.CANCEL);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private Estado popularObjeto(Estado estado) {
        estado.nome  = binding.edtNome.getText().toString();
        estado.sigla = binding.edtSigla.getText().toString();
        return estado;
    }

}