package br.com.ifsudestemg.sistemapdvif.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.R;
import br.com.ifsudestemg.sistemapdvif.domain.AppDatabase;
import br.com.ifsudestemg.sistemapdvif.domain.EstadoDAO;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Estado;

public class ListagemEstadoFragment extends Fragment {

    private RecyclerView lstEstado;

    private EstadoDAO estadoDAO;

    public ListagemEstadoFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListagemEstadoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListagemEstadoFragment newInstance(String param1, String param2) {
        ListagemEstadoFragment fragment = new ListagemEstadoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        AppDatabase db = AppDatabase.getDatabase(getContext());
        estadoDAO = db.estadoDAO();

        List<Estado> dados = estadoDAO.buscarTodos();

        View layout = inflater.inflate(R.layout.fragment_listagem_estado, container, false);

        lstEstado = layout.findViewById(R.id.lstCidade);

        //Configurando o layout do RecycleView;
        RecyclerView.LayoutManager manager
                   = new LinearLayoutManager(this.getContext());
        lstEstado.setLayoutManager(manager);

        //Criando a instância do CustomAdapter para ser utilizado no RecycleView
        EstadoAdapter adapter = new EstadoAdapter(dados, getActivity());

        lstEstado.setAdapter(adapter);

        return layout;
    }

}