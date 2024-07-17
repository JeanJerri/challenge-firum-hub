package br.com.alura.challenge_forumhub_topicos.controller;

import br.com.alura.challenge_forumhub_topicos.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        repository.save(new Topico(dados));
    }

//    @GetMapping("/{id}")
//    public Optional<Topico> detalhar(@PathVariable Long id) {
//        var topico = repository.getReferenceById(id);
//
//        return repository.findById(id);
//    }

    @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10)Pageable paginacao) {
        return repository.findAllByEstadoDoTopicoTrue(paginacao).map(DadosListagemTopico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
//        repository.deleteById(id);
        var topico = repository.getReferenceById(id);
        topico.excluir();
    }
}
