--liquibase formatted sql

--changeset 20231205-3 author:gabriel.rodrigues@bonnasys.com.br label:adding-citiies

INSERT INTO rent_vehicles.roles(id, name) values ('baf94bd5-ca78-4d28-9674-d4742b198042', 'HUMAN_RESOURCES');
INSERT INTO rent_vehicles.roles(id, name) values ('24766044-9358-46d9-bfaa-c812ff34e176', 'ACCOUNTING');
INSERT INTO rent_vehicles.roles(id, name) values ('7bd33cb5-ee1b-48e6-9d0e-24f6dcfa1582', 'ADMINISTRATOR');

