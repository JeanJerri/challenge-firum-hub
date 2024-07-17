ALTER TABLE topicos ADD data_de_criacao_temp DATETIME;
UPDATE topicos SET data_de_criacao_temp = NOW();
ALTER TABLE topicos DROP COLUMN data_de_criacao;
ALTER TABLE topicos CHANGE data_de_criacao_temp data_de_criacao DATETIME;
