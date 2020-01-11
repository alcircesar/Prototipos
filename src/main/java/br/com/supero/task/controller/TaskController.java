/**
 * Programador: Alcir
 * Data: 10/01/2020
 * Finalidade: Controllers da aplicação. Não implementei todas as práticas de REST, mas ao menos a listagem dos dados utiliza micro serviço REST
 * Demandante: Supero - Desafio de programação
 */package br.com.supero.task.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.supero.task.model.Task;
import br.com.supero.task.repository.TaskRepository;

@Controller
public class TaskController {
    private static Logger logger = LoggerFactory.getLogger(HandleController.class);

	@GetMapping(value= {"/tasks","/"})
	public String home() {
		return "tasks/listar";
		
	}
	
	
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/dados")
    @ResponseBody
    public List<Task> taskDados() {
        return taskRepository.findAll();
    }
    
    @GetMapping("/nova")
    public String nova(Model model) {
    	model.addAttribute("task", new Task());
        return "tasks/form";
    }
    
    @PostMapping("/salvar")
    public String ordemServicoSalvar(@ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors() ) {
        	System.out.println("Erro de validacao");
            model.addAttribute("task", task);
            return "tasks/nova";
        }

    	taskRepository.save(task);
    	model.addAttribute("task", task);
        return "tasks/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id,  Model model) throws NotFoundException {
    	Task task = taskRepository.findById(id).orElse(null);
    	if (task!=null) {
    		model.addAttribute("task", task);
    		return "tasks/form";
    	} else
    		throw new NotFoundException();
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificação da Tarefa inválida: " + id));
    	 taskRepository.delete(task);
    	return "redirect:/tasks";
    }
}
