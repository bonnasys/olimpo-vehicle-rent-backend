--liquibase formatted sql

--changeset 20231205-1 author:gabriel.rodrigues@bonnasys.com.br label:create-schema

create table rent_vehicles.categories (
    name varchar(100),
    qualification varchar(100),
    category_image TEXT,
    description varchar(255),
    id varchar(255) not null,
    primary key (id)) engine=InnoDB;

create table rent_vehicles.characteristics(
    icon varchar(255),
    id   varchar(255) not null,
    name varchar(255),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.cities(
    id    varchar(255) not null,
    name  varchar(255),
    state varchar(255),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.reserves(
    id         varchar(255) not null,
    id_client varchar(255),
    id_vehicle varchar(255),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.roles(
    id   varchar(255) not null,
    name varchar(255),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.users(
    created_at datetime(6),
    updated_at datetime(6),
    email      varchar(255),
    id         varchar(255) not null,
    name       varchar(255),
    password   varchar(255),
    phone      varchar(255),
    type       enum ('CLIENT','EMPLOYEE'),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.users_clients(
    city_id varchar(255),
    id      varchar(255) not null,
    primary key (id)) engine=InnoDB;

create table rent_vehicles.users_employees(
    id           varchar(255) not null,
    registration varchar(255),
    user_role    varchar(255),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.vehicles(
    category_id varchar(255),
    description varchar(255),
    id          varchar(255) not null,
    model       varchar(255),
    vehicle_id  varchar(255),
    primary key (id)) engine=InnoDB;

create table rent_vehicles.vehicles_characteristics(
    id_characteristic varchar(255) not null,
    id_vehicle        varchar(255) not null,
    primary key (id_characteristic, id_vehicle)) engine=InnoDB;

alter table rent_vehicles.roles add constraint uq_role_name unique (name);
alter table rent_vehicles.reserves add constraint fk_reserve_client foreign key (id_client) references users_clients (id);
alter table rent_vehicles.reserves add constraint fk_reserve_vehicle foreign key (id_vehicle) references vehicles (id);
alter table rent_vehicles.users_clients add constraint fk_clients_city foreign key (city_id) references cities (id);
alter table rent_vehicles.users_clients add constraint fk_client_user foreign key (id) references users (id);
alter table rent_vehicles.users_employees add constraint fk_employee_role foreign key (user_role) references roles (id);
alter table rent_vehicles.users_employees add constraint fk_employee_user foreign key (id) references users (id);
alter table rent_vehicles.vehicles add constraint fk_category_vehicle foreign key (category_id) references categories (id);
alter table rent_vehicles.vehicles add constraint fk_city_vehicle foreign key (vehicle_id) references cities (id);
alter table rent_vehicles.vehicles_characteristics add constraint fk_characteristic_vehicle foreign key (id_characteristic) references characteristics (id);
alter table rent_vehicles.vehicles_characteristics add constraint fk_vehicle_characteristic foreign key (id_vehicle) references vehicles (id);