-- create metadata aspect table
create table metadata_aspect (
  urn                           varchar(500) not null,
  aspect                        varchar(200) not null,
  version                       bigint(20) not null,
  metadata                      longtext not null,
  createdon                     datetime(6) not null,
  createdby                     varchar(255) not null,
  createdfor                    varchar(255),
  constraint pk_metadata_aspect primary key (urn,aspect,version)
);

create table relationship (
                              relation                      varchar(200) not null,
                              sourceurn                     varchar(500) not null,
                              desturn                       varchar(500) not null,
                              createdon                     timestamp not null,
                              constraint pk_relationship primary key (relation,sourceurn,desturn)
);

create table entity_attribute (
                                  urn             varchar(500) not null,
                                  attribute  varchar(200) not null,
                                  value varchar(200) not null,
                                  createdon       timestamp not null,
                                  constraint pk_entity_attribute primary key (urn, attribute)
);