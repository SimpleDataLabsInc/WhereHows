create table metadata_aspect (
  urn                           varchar(500) not null,
  aspect                        varchar(200) not null,
  version                       bigint not null,
  metadata                      clob not null,
  createdon                     timestamp not null,
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
create table metadata_id (
  namespace                     varchar(255) not null,
  id                            bigint not null,
  constraint uq_metadata_id_namespace_id unique (namespace,id)
);

