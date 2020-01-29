/**
 * Programador: Alcir
 * Data: 10/01/2020
 * Finalidade: Interface de CRUD para a tabela de Tarefas conforme espeficicação do ORM utilizado
 */

package br.com.prototipos.tasks.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prototipos.tasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
