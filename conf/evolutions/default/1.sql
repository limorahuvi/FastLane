# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agency_ (
  agency_id                     serial not null,
  agency_name                   varchar(50) not null,
  agency_url                    varchar(255),
  constraint pk_agency_ primary key (agency_id)
);

create table calendar_ (
  service_id                    serial not null,
  days_bytes                    varchar(255),
  start_date                    timestamptz,
  end_date                      timestamptz,
  constraint pk_calendar_ primary key (service_id)
);

create table routes_ (
  route_id                      serial not null,
  agency_id                     integer,
  route_long_name               varchar(255),
  route_desc                    varchar(255),
  route_type                    varchar(255),
  route_color                   varchar(255),
  constraint pk_routes_ primary key (route_id)
);

create table segs_ (
  seg_id                        integer not null,
  shape_pt_sequence             integer not null,
  point                         geometry(point,4326),
  stop_id                       integer,
  constraint pk_segs_ primary key (seg_id,shape_pt_sequence)
);

create table shapes_ (
  shape_id                      serial not null,
  seg_id                        integer,
  shape_pt_sequence             integer,
  constraint pk_shapes_ primary key (shape_id)
);

create table stop_ (
  stop_id                       serial not null,
  stop_code                     integer,
  stop_name                     varchar(255),
  stop_desc                     varchar(255),
  location                      geometry(point,4326),
  location_type                 boolean,
  parent_station_id             integer,
  constraint pk_stop_ primary key (stop_id)
);

create table stop_times_ (
  trip_id                       varchar(255) not null,
  stop_id                       integer not null,
  arrival_time                  time not null,
  departure_time                time,
  stop_sequence                 integer,
  pickup_types                  boolean,
  drop_off_type                 boolean,
  shape_dist_traveled           integer,
  continue_passengers           integer,
  constraint pk_stop_times_ primary key (trip_id,stop_id,arrival_time)
);

create table trips_ (
  trip_id                       varchar(255) not null,
  route_id                      integer,
  service_id                    integer,
  direction_id                  boolean,
  shape_id                      integer,
  constraint pk_trips_ primary key (trip_id)
);

create index ix_routes__agency_id on routes_ (agency_id);
alter table routes_ add constraint fk_routes__agency_id foreign key (agency_id) references agency_ (agency_id) on delete restrict on update restrict;

create index ix_segs__stop_id on segs_ (stop_id);
alter table segs_ add constraint fk_segs__stop_id foreign key (stop_id) references stop_ (stop_id) on delete restrict on update restrict;

create index ix_shapes__seg_id on shapes_ (seg_id,shape_pt_sequence);
alter table shapes_ add constraint fk_shapes__seg_id foreign key (seg_id,shape_pt_sequence) references segs_ (seg_id,shape_pt_sequence) on delete restrict on update restrict;

create index ix_stop__parent_station_id on stop_ (parent_station_id);
alter table stop_ add constraint fk_stop__parent_station_id foreign key (parent_station_id) references stop_ (stop_id) on delete restrict on update restrict;

create index ix_stop_times__trip_id on stop_times_ (trip_id);
alter table stop_times_ add constraint fk_stop_times__trip_id foreign key (trip_id) references trips_ (trip_id) on delete restrict on update restrict;

create index ix_stop_times__stop_id on stop_times_ (stop_id);
alter table stop_times_ add constraint fk_stop_times__stop_id foreign key (stop_id) references stop_ (stop_id) on delete restrict on update restrict;

create index ix_trips__route_id on trips_ (route_id);
alter table trips_ add constraint fk_trips__route_id foreign key (route_id) references routes_ (route_id) on delete restrict on update restrict;

create index ix_trips__service_id on trips_ (service_id);
alter table trips_ add constraint fk_trips__service_id foreign key (service_id) references calendar_ (service_id) on delete restrict on update restrict;


# --- !Downs

alter table if exists routes_ drop constraint if exists fk_routes__agency_id;
drop index if exists ix_routes__agency_id;

alter table if exists segs_ drop constraint if exists fk_segs__stop_id;
drop index if exists ix_segs__stop_id;

alter table if exists shapes_ drop constraint if exists fk_shapes__seg_id;
drop index if exists ix_shapes__seg_id;

alter table if exists stop_ drop constraint if exists fk_stop__parent_station_id;
drop index if exists ix_stop__parent_station_id;

alter table if exists stop_times_ drop constraint if exists fk_stop_times__trip_id;
drop index if exists ix_stop_times__trip_id;

alter table if exists stop_times_ drop constraint if exists fk_stop_times__stop_id;
drop index if exists ix_stop_times__stop_id;

alter table if exists trips_ drop constraint if exists fk_trips__route_id;
drop index if exists ix_trips__route_id;

alter table if exists trips_ drop constraint if exists fk_trips__service_id;
drop index if exists ix_trips__service_id;

drop table if exists agency_ cascade;

drop table if exists calendar_ cascade;

drop table if exists routes_ cascade;

drop table if exists segs_ cascade;

drop table if exists shapes_ cascade;

drop table if exists stop_ cascade;

drop table if exists stop_times_ cascade;

drop table if exists trips_ cascade;

