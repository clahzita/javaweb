package br.com.devmedia.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.devmedia.entity.Nota;
import br.com.devmedia.exception.BDException;

public class NotaDAO {
  List<Nota> banco = new ArrayList<>();
  
  public int adicionarNota(Nota nova) {
    banco.add(nova);
    return nova.getId();
  }
  
  public void editarNota(Nota nova) throws BDException {
    for (Nota nota : banco) {
      if(nota.getId() == nova.getId()) {
        nota.setDescricao(nova.getDescricao());
        nota.setTitulo(nova.getTitulo());
        System.out.println("Editado com sucesso!");
        return;
      }
    }
    throw new BDException("Id não encontrado!");
   
  }
  
  public void removerNota(int id) throws BDException {
    for (Nota nota : banco) {
      if(nota.getId() == id) {
        banco.remove(nota);
        System.out.println("Removido com sucesso!");
        return;
      }
    }
    throw new BDException("Id não encontrado!");
  }

  public List<Nota> listarNotas(){
    return banco;
  }
  
  public Nota buscarNotaPorId(int IdNota) throws BDException {
    for (Nota nota : banco) {
      if(nota.getId() == IdNota) {
        System.err.println("Nota encontrada!");
        return nota;
      }
    }
    throw new BDException("Nenhuma nota com esse ID encontrada!");
   
  }
}
