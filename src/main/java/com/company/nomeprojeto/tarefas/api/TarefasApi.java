package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDto;
import com.company.nomeprojeto.tarefas.facade.TarefasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasApi {
    @Autowired
    private TarefasFacade tarefasFacade;

    @PostMapping
    @ResponseBody
    public TarefaDto criar(@RequestBody TarefaDto tarefaDto){
        return tarefasFacade.criar(tarefaDto);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDto atualizar(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaDto tarefaDto) {
        return tarefasFacade.atualizar(tarefaDto, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaDto> getAll(){
        return tarefasFacade.getAll();
    }

    @GetMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDto getById(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFacade.getById(tarefaId);
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFacade.delete(tarefaId);
    }
}
