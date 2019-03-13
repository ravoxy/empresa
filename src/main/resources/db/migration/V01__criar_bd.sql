CREATE TABLE usuario
(
    id_usuario bigint NOT NULL,
    email character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    status_usuario character varying(255) NOT NULL,
    version timestamp without time zone NOT NULL,
    situacao character varying NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)

);

CREATE TABLE empresa
(
    id_empresa bigint NOT NULL,
    descricao character varying(255) ,
    version timestamp without time zone NOT NULL,
    situacao character varying  NOT NULL,
    CONSTRAINT empresa_pkey PRIMARY KEY (id_empresa)
);

CREATE TABLE usuario_empresa
(
    id_usuario_empresa bigint NOT NULL,
    version timestamp without time zone NOT NULL,
    id_empresa bigint NOT NULL,
    id_usuario bigint NOT NULL,
    situacao character varying ,
    ultimo_logon timestamp without time zone,
    CONSTRAINT usuario_empresa_pkey PRIMARY KEY (id_usuario_empresa),
    CONSTRAINT fk_usuario_empresa_id_empresa FOREIGN KEY (id_empresa)
        REFERENCES empresa (id_empresa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_usuario_empresa_id_usuario FOREIGN KEY (id_usuario)
        REFERENCES usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE empresa_seq START 1;
CREATE SEQUENCE usuario_seq START 1;
CREATE SEQUENCE usuario_empresa_seq START 1;