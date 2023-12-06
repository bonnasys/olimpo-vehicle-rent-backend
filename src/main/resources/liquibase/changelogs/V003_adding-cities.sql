--liquibase formatted sql

--changeset 20231205-2 author:gabriel.rodrigues@bonnasys.com.br label:adding-roles

INSERT INTO rent_vehicles.cities(id, name, state) values ('e3620689-ba65-4fee-8c9a-f66d33b936f9', 'Sumaré', 'SP');
INSERT INTO rent_vehicles.cities(id, name, state) values ('b4c12a51-d65d-492b-abee-283172ed75cf', 'Campinas', 'SP');
INSERT INTO rent_vehicles.cities(id, name, state) values ('69c62a73-0064-4f62-917c-96d594f34ef5', 'Guarulhos', 'SP');
INSERT INTO rent_vehicles.cities(id, name, state) values ('72b4df91-cab5-4b51-8b5a-1eba1b83feab', 'Manaus', 'AM');
INSERT INTO rent_vehicles.cities(id, name, state) values ('743ca0af-9e53-472f-b7ff-27f3e286e670', 'Recife', 'PE');
INSERT INTO rent_vehicles.cities(id, name, state) values ('9b9341f2-133b-4e17-b72f-9392761c72ad', 'Maceió', 'GO');
INSERT INTO rent_vehicles.cities(id, name, state) values ('afed352c-0d55-4379-9aee-c32c139a4829', 'Campo Grande', 'MS');
INSERT INTO rent_vehicles.cities(id, name, state) values ('7b6dca04-27e7-4007-955d-07a32d69cabb', 'Teresina', 'PI');
INSERT INTO rent_vehicles.cities(id, name, state) values ('319bc8c8-f576-4533-8d8e-c902ed24d3a6', 'Nova Iguaçu', 'RJ');
