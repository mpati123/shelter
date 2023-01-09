CREATE TYPE animalType as enum (
    'DOG',
    'CAT',
    'BIRD',
    'RODENT',
    'REPTILE',
    'OTHER'
);
CREATE TABLE shelter (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE animalEntity (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    type animalType NOT NULL,
    breed TEXT NOT NULL,
    age INTEGER NOT NULL,
    shelter_id INTEGER NOT NULL,
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);

CREATE TABLE donationEntity (
    id SERIAL PRIMARY KEY,
    donor_name TEXT NOT NULL,
    amount NUMERIC(5,2) NOT NULL,
    animal_id INTEGER NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animalEntity(id)
);

CREATE TABLE invoiceEntity (
    id SERIAL PRIMARY KEY,
    recipient_name TEXT NOT NULL,
    amount NUMERIC(5,2) NOT NULL,
    animal_id INTEGER NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animalEntity(id)
);
