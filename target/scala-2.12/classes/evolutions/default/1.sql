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
  days_bytes                    varchar(255),
  start_date                    timestamptz,
  end_date                      timestamptz,
  constraint pk_calendar primary key (service_id)
);

create table passenger_counts (
  pc_id                         serial not null,
  trip_id                       integer,
  passengers_continue_rounded_final integer,
  point                         geometry(point,4326),
  day_name_heb                  varchar(255),
  station_order                 varchar(255),
  date_key                      timestamptz,
  hour_key                      time,
  constraint pk_passenger_counts primary key (pc_id)
);

create table real_time (
  real_time_id                  serial not null,
  stop                          integer,
  published_line_name           varchar(255),
  location                      geometry(point,4326),
  expected_arrival_date         timestamptz,
  expected_arrival_time         time,
  recorded_at_time_date         timestamptz,
  recorded_at_time_time         time,
  constraint pk_real_time primary key (real_time_id)
);

create table routes (
  route_id                      serial not null,
  agency_id                     integer,
  route_long_name               varchar(255),
  route_desc                    varchar(255),
  route_type                    varchar(255),
  route_color                   varchar(255),
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
  stop_name                     varchar(255),
  stop_desc                     varchar(255),
  location                      geometry(point,4326),
  location_type                 boolean,
  parent_station_id             integer,
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
  route_id                      integer,
  service_id                    integer,
  direction_id                  boolean,
  shape_id                      integer,
  constraint pk_trips primary key (trip_id)
);

create index ix_real_time_stop on real_time (stop);
alter table real_time add constraint fk_real_time_stop foreign key (stop) references stop (stop_id) on delete restrict on update restrict;

create index ix_routes_agency_id on routes (agency_id);
alter table routes add constraint fk_routes_agency_id foreign key (agency_id) references agency (agency_id) on delete restrict on update restrict;

create index ix_stop_parent_station_id on stop (parent_station_id);
alter table stop add constraint fk_stop_parent_station_id foreign key (parent_station_id) references stop (stop_id) on delete restrict on update restrict;

create index ix_stop_times_trip_id on stop_times (trip_id);
alter table stop_times add constraint fk_stop_times_trip_id foreign key (trip_id) references trips (trip_id) on delete restrict on update restrict;

create index ix_stop_times_stop_id on stop_times (stop_id);
alter table stop_times add constraint fk_stop_times_stop_id foreign key (stop_id) references stop (stop_id) on delete restrict on update restrict;

create index ix_trips_route_id on trips (route_id);
alter table trips add constraint fk_trips_route_id foreign key (route_id) references routes (route_id) on delete restrict on update restrict;

create index ix_trips_service_id on trips (service_id);
alter table trips add constraint fk_trips_service_id foreign key (service_id) references calendar (service_id) on delete restrict on update restrict;


# --- !Downs

alter table if exists real_time drop constraint if exists fk_real_time_stop;
drop index if exists ix_real_time_stop;

alter table if exists routes drop constraint if exists fk_routes_agency_id;
drop index if exists ix_routes_agency_id;

alter table if exists stop drop constraint if exists fk_stop_parent_station_id;
drop index if exists ix_stop_parent_station_id;

alter table if exists stop_times drop constraint if exists fk_stop_times_trip_id;
drop index if exists ix_stop_times_trip_id;

alter table if exists stop_times drop constraint if exists fk_stop_times_stop_id;
drop index if exists ix_stop_times_stop_id;

alter table if exists trips drop constraint if exists fk_trips_route_id;
drop index if exists ix_trips_route_id;

alter table if exists trips drop constraint if exists fk_trips_service_id;
drop index if exists ix_trips_service_id;

drop table if exists agency cascade;

drop table if exists calendar cascade;

drop table if exists passenger_counts cascade;

drop table if exists real_time cascade;

drop table if exists routes cascade;

drop table if exists shape cascade;

drop table if exists stop cascade;

drop table if exists stop_times cascade;

drop table if exists trips cascade;

