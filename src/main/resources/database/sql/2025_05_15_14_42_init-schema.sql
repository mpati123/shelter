--liquibase formatted sql
--changeset pnehrebecka:2025_05_15_14_42_init-schema

-- Tables
CREATE TABLE gatunek (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID not null,
                         nazwa TEXT NOT NULL
);

CREATE TABLE ludzie (
                        id BIGSERIAL PRIMARY KEY,
                        uuid UUID not null,
                        imie TEXT NOT NULL,
                        nazwisko TEXT NOT NULL,
                        email TEXT UNIQUE,
                        telefon TEXT
);

CREATE TABLE lecznica (
                          id BIGSERIAL PRIMARY KEY,
                          uuid UUID not null,
                          nazwa TEXT NOT NULL,
                          adres TEXT NOT NULL,
                          telefon TEXT
);

CREATE TABLE faktury (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID not null,
                         numer TEXT NOT NULL,
                         data DATE NOT NULL,
                         kwota NUMERIC(10,2) NOT NULL,
                         lecznica_id BIGINT NOT NULL,
                         FOREIGN KEY (lecznica_id) REFERENCES lecznica(id)
);

CREATE TABLE zbiorka (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID not null,
                         nazwa TEXT NOT NULL,
                         cel TEXT NOT NULL,
                         kwota_docelowa NUMERIC(10,2),
                         kwota_zebrana NUMERIC(10,2) DEFAULT 0
);

CREATE TABLE pracownicy (
                            id BIGSERIAL PRIMARY KEY,
                            uuid UUID not null,
                            czlowiek_id BIGINT NOT NULL,
                            stanowisko TEXT NOT NULL,
                            FOREIGN KEY (czlowiek_id) REFERENCES ludzie(id)
);

CREATE TABLE zwierzeta (
                           id BIGSERIAL PRIMARY KEY,
                           uuid UUID not null,
                           imie TEXT NOT NULL,
                           gatunek_id BIGINT NOT NULL,
                           opiekun_id BIGINT NOT NULL,
                           wiek INTEGER,
                           stan TEXT NOT NULL,
                           miejsce TEXT NOT NULL,
                           FOREIGN KEY (gatunek_id) REFERENCES gatunek(id),
                           FOREIGN KEY (opiekun_id) REFERENCES pracownicy(id)
);

CREATE TABLE zwierzeta_faktury (
                                   id BIGSERIAL PRIMARY KEY,
                                   uuid UUID not null DEFAULT gen_random_uuid(),
                                   zwierze_id BIGINT NOT NULL,
                                   faktura_id BIGINT NOT NULL,
                                   FOREIGN KEY (zwierze_id) REFERENCES zwierzeta(id),
                                   FOREIGN KEY (faktura_id) REFERENCES faktury(id)
);

CREATE TABLE zwierzeta_zbiorki (
                                   id BIGSERIAL PRIMARY KEY,
                                   uuid UUID not null DEFAULT gen_random_uuid(),
                                   zwierze_id BIGINT NOT NULL,
                                   zbiorka_id BIGINT NOT NULL,
                                   FOREIGN KEY (zwierze_id) REFERENCES zwierzeta(id),
                                   FOREIGN KEY (zbiorka_id) REFERENCES zbiorka(id)
);