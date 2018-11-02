package br.com.devmedia.rest;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.devmedia.dao.NotaDAO;
import br.com.devmedia.entity.Nota;
import br.com.devmedia.exception.BDException;

@Path("/notas")
public class NotasService {

  private static final String CHARSET_UTF8 = ";charset=utf-8";
  private NotaDAO notaDAO;

  @PostConstruct
  private void init() {
    notaDAO = new NotaDAO();
  }

  @GET
  @Path("/listar")
  @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
  public List<Nota> listarNotas() {
    List<Nota> lista = null;
    lista = notaDAO.listarNotas();
    if(lista.isEmpty()) {
      System.out.println("lista vazia");
    }
    return lista;
  }

  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
  @Produces(MediaType.TEXT_PLAIN)
  public String addNota(Nota nota) {
    String msg = "";
    
    System.out.println(nota.getTitulo());
    
    int idGerado = notaDAO.adicionarNota(nota);
    
    msg = String.valueOf(idGerado);
    
    return msg;
  }

  @GET
  @Path("/get/{id}")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public Nota buscarPorId(@PathParam("id") int idNota) {
    Nota nota = null;

    try {
      nota = notaDAO.buscarNotaPorId(idNota);
    } catch (BDException e) {
      
      e.printStackTrace();
    }
    
    return nota;
  }
  
  @PUT
  @Path("/edit/{id}")
  @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
  @Produces(MediaType.TEXT_PLAIN)
  public String editarNota(Nota nota, @PathParam("id") int idNota) {
      String msg = "";
       
      System.out.println(nota.getTitulo());
       
      try {
          notaDAO.editarNota(nota);
           
          msg = "Nota editada com sucesso!";
      } catch (BDException e) {
          msg = "Erro ao editar a nota!";
          e.printStackTrace();
      }
       
      return msg;
  }
  
  @DELETE
  @Path("delete/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public String removerNota(@PathParam("id") int idNota) {
    String msg = "";
     
    try {
        notaDAO.removerNota(idNota);
         
        msg = "Nota removida com sucesso!";
    } catch (BDException e) {
        msg = "Erro ao remover a nota!";
        e.printStackTrace();
    }
     
    return msg;
}

}
