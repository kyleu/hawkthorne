do $$
begin
  if not exists (select 1 from "pg_type" where "typname" = 'game_history_type') then
    create type "game_history_type" as enum('client', 'server', 'unknown');
  end if;
end$$;

do $$
begin
  if not exists (select 1 from "pg_type" where "typname" = 'game_snapshot_type') then
    create type "game_snapshot_type" as enum('initial', 'manual', 'final', 'unknown');
  end if;
end$$;

create table if not exists "game_history" (
  "id" uuid not null primary key,
  "t" game_history_type not null,
  "options" json not null,
  "creator" uuid references "system_users",
  "started" timestamp without time zone not null
);

create index if not exists "game_history_creator" on "game_history" using btree ("creator" asc);
create index if not exists "game_history_t" on "game_history" using btree ("t" asc);

create table if not exists "game_snapshot" (
  "id" uuid not null primary key,
  "game_id" uuid references "game_history",
  "t" game_snapshot_type not null,
  "snapshot" json not null,
  "occurred" timestamp without time zone not null
);

create table if not exists "game_player" (
  "game_id" uuid references "game_history",
  "user_id" uuid references "system_users",
  "idx" int not null,
  "joined" timestamp without time zone not null,
  primary key ("game_id", "user_id")
);

create index if not exists "game_players_game_id" on "game_player" using btree ("game_id" asc);
create index if not exists "game_players_user_id" on "game_player" using btree ("user_id" asc);
