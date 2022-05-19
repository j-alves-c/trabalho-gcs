package persistencia;

import java.util.ArrayList;

public interface InterfaceDAO <Entity,PK>{
		 void inserir(Entity entidade);
		 void atualizar(Entity entidade);
		 void deletar(Entity entidade);
		 Entity buscarPorCodigo(PK chave);
		 ArrayList<Entity> listaTodos();


}
