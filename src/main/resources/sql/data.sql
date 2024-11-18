-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;
    
-- Table: public.secrets

-- DROP TABLE IF EXISTS public.secrets;

CREATE TABLE IF NOT EXISTS public.secrets
(
    secret_id integer NOT NULL DEFAULT nextval('secrets_secret_id_seq'::regclass),
    owner_id integer,
    secret_login character varying(60) COLLATE pg_catalog."default",
    secret_password character varying(60) COLLATE pg_catalog."default",
    times_to_view integer,
    CONSTRAINT secrets_pkey PRIMARY KEY (secret_id),
    CONSTRAINT secrets_owner_id_fkey FOREIGN KEY (owner_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.secrets
    OWNER to postgres;