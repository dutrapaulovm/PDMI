package br.com.ifsudestemg.sistemapdvif.domain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.domain.entities.Estado;

@Dao
public interface EstadoDAO extends BaseDAO<Estado>{

    @Query("SELECT * FROM estado")
    public List<Estado> buscarTodos();

}
