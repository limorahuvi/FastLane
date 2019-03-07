# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agency (
  agency_id                     serial not null,
  agency_name                   varchar(255),
  agency_url                    varchar(255),
  constraint pk_agency primary key (agency_id)
);


# --- !Downs

drop table if exists agency cascade;

