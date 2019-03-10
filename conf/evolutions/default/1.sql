# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agency (
  agency_id                     serial not null,
  agency_name                   varchar(50) not null,
  agency_url                    varchar(255),
  constraint pk_agency primary key (agency_id)
);

create table calendar (
  service_id                    serial not null,
  agency_id                     integer,
  days_bytes                    bit(7),
  start_date                    timestamptz,
  end_date                      timestamptz,
  constraint pk_calendar primary key (service_id)
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

create table shape (
  shape_id                      integer not null,
  shape_pt_sequence             integer not null,
  point                         geometry(point,4326),
  constraint pk_shape primary key (shape_id,shape_pt_sequence)
);

create table stop (
  stop_id                       serial not null,
  stop_code                     integer,
  privatestop_name              varchar(255),
  stop_desc                     varchar(255),
  loction                       geometry(point,4326),
  location_type                 integer not null,
  parent_station                integer,
  constraint pk_stop primary key (stop_id)
);

create table stop_times (
  trip_id                       varchar(255) not null,
  stop_id                       integer not null,
  arrival_time                  time not null,
  departure_time                time,
  stop_sequence                 integer,
  pickup_types                  boolean,
  drop_off_type                 boolean,
  shape_dist_traveled           integer,
  constraint pk_stop_times primary key (trip_id,stop_id,arrival_time)
);

create table trips (
  trip_id                       varchar(255) not null,
  route_id                      integer not null,
  service_id                    integer not null,
  direction_id                  boolean,
  shape_id                      integer,
  constraint pk_trips primary key (trip_id)
);

alter table routes add constraint fk_routes_agency_id foreign key (agency_id) references agency (agency_id) on delete restrict on update restrict;
create index ix_routes_agency_id on routes (agency_id);


# --- !Downs

alter table if exists routes drop constraint if exists fk_routes_agency_id;
drop index if exists ix_routes_agency_id;

drop table if exists agency cascade;

drop table if exists calendar cascade;

drop table if exists routes cascade;

drop table if exists shape cascade;

drop table if exists stop cascade;

drop table if exists stop_times cascade;

drop table if exists trips cascade;

