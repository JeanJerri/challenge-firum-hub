package br.com.alura.challenge_forumhub_topicos.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_de_criacao,
        Boolean estadoDoTopico,
        String autor,
        String curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_de_criacao(),
                topico.getEstadoDoTopico(), topico.getAutor(), topico.getCurso());
    }
}
