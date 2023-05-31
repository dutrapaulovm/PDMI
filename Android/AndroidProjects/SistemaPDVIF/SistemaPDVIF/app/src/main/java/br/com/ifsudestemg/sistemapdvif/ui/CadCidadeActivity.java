package br.com.ifsudestemg.sistemapdvif.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import br.com.ifsudestemg.sistemapdvif.R;
import br.com.ifsudestemg.sistemapdvif.ResultCodeActivity;
import br.com.ifsudestemg.sistemapdvif.databinding.ActivityCadCidadeBinding;
import br.com.ifsudestemg.sistemapdvif.domain.AppDatabase;
import br.com.ifsudestemg.sistemapdvif.domain.CidadeDAO;
import br.com.ifsudestemg.sistemapdvif.domain.EstadoDAO;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Cidade;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Estado;

public class CadCidadeActivity extends AppCompatActivity {

    /**
     * Classe gerada pelo Android para que possamos
     * acessar os componentes da interface sem precisar
     * declarar os objetos utilizando o método findViewById
     */
    private ActivityCadCidadeBinding binding;

    private CidadeDAO cidadeDAO;

    private EstadoDAO estadoDAO;

    //Utilizado pelo componentes Spinner
    private ArrayAdapter<Estado> adapterEstado;

    /**
     * O objeto cidade é utilizado para armazenar os dados
     * do cadastro para ser enviado par ao banco de dados
     */
    private Cidade cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCadCidadeBinding.
                            inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Retorna o objeto que representa a barra de comandos
        //do Activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AppDatabase db = AppDatabase.getDatabase(this);
        cidadeDAO = db.cidadeDAO();
        estadoDAO = db.estadoDAO();

        /**
         * Criando uma referência  da classe ArrayAdapter para
         * popular com dados o componente Spinner.
         */
        adapterEstado = new ArrayAdapter<Estado>(this,
                android.R.layout.simple_spinner_dropdown_item,
                estadoDAO.buscarTodos());

        /**
         * Vinculando o objeto do tipo ArrayAdapter com o Spinner
         * para que os dados sejam visualizados.
         */
        binding.spnEstado.setAdapter(adapterEstado);

        Intent it = getIntent();
        if (it != null){
            /**
             * Para recuperar um objeto devemos converter para o
             * tipo apropriado.
             */
            if (it.hasExtra("ITEM")) {
                cidade = (Cidade) it.getSerializableExtra("ITEM");
                binding.edtNome.setText(cidade.nome);
                binding.edtIBGE.setText(cidade.codIBGE);

                int codigo = cidade.codEstado;

                for (int i = 0; i < adapterEstado.getCount(); i++){

                    Estado estado = adapterEstado.getItem(i);
                    if (estado.id == codigo){
                        binding.spnEstado.setSelection(i);
                        break;
                    }
                }

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

                if (cidade == null){
                    cidade = new Cidade();
                    cidade = preencherObjeto(cidade);
                    cidadeDAO.inserir(cidade);
                }
                else{
                    cidade = preencherObjeto(cidade);
                    cidadeDAO.atualizar(cidade);
                }
                setResult(ResultCodeActivity.OK);
                finish();
                break;

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

    private Cidade preencherObjeto(Cidade cidade) {
        cidade.nome = binding.edtNome.getText().toString();
        cidade.codIBGE = binding.edtIBGE.getText().toString();

        Estado estado = null;
        estado = (Estado)binding.spnEstado.getSelectedItem();

        cidade.codEstado = estado.id;

        return cidade;
    }


}