ALTER TABLE topicos ADD estado_do_topico BOOLEAN;
UPDATE topicos SET estado_do_topico = TRUE;
ALTER TABLE topicos DROP COLUMN estadoDoTopico;