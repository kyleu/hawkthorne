create type trace_type as enum('client', 'connection', 'game', 'unknown');

create table if not exists "trace_result" (
  "id" uuid not null primary key,
  "t" trace_type not null,
  "data" json not null,
  "author" uuid references "system_users",
  "occurred" timestamp without time zone not null
);

create index if not exists "trace_result_author" on "trace_result" using btree ("author" asc);
create index if not exists "trace_result_t" on "trace_result" using btree ("t" asc);
