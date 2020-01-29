/**
 * Programador: Alcir
 * Data: 10/01/2020
 * Finalidade: Configuracoes necessárias para o projeto Spring Boot (ver dependências no POM)
 *             Não implementei segurança na aplicação pois não estava no escopo da demanda
 *             Funcionalidades implementadas: 
 *             	• Adicionar novas tarefas;
				• Marcar e desmarcar o status de concluído;
				• Editar o conteúdo da task;
				• Deletar uma task;
				• Versionamento com Git;
			  Funcionalidades adicionais:
			  	- Comportamento do form de edição conforme o estado da tarefa (disabilitado quando a tarefa foi cancelada)
 * Demandante: Supero - Desafio de programação
 */
package br.com.prototipos.tasks.config;


import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("br.com.supero.task.repository")
@ComponentScan("br.com.supero.task")
@EntityScan("br.com.supero.task.model")   
@EnableAutoConfiguration
public class TaskApplication {

	public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		SpringApplication.run(TaskApplication.class, args);
	}

}
