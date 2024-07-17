ALTER TABLE topicos ADD estadoDoTopico BOOLEAN;
UPDATE topicos SET estadoDoTopico = TRUE;
ALTER TABLE topicos DROP COLUMN estado_do_topico;