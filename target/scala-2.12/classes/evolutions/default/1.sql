# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agency (
  agency_id                     serial not null,
  agency_name                   varchar(255),
  agency_url                    varchar(255),
  constraint pk_agency primary key (agency_id)
);

create table calendar (
  route_id                      serial not null,
  agency_id                     integer,
  route_long_name               varchar(255),
  route_desc                    varchar(255),
  route_color                   varchar(255),
  constraint pk_calendar primary key (route_id)
);

create table routes (
  route_id                      serial not null,
  agency_id                     integer,
  route_long_name               varchar(255),
  route_desc                    varchar(255),
  route_type                    varchar(255),
  route_color                   integer,
  constraint pk_routes primary key (route_id)
);


# --- !Downs

drop table if exists agency cascade;

drop table if exists calendar cascade;

drop table if exists routes cascade;

