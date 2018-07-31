create type analytics_action_type as enum(
  'connect', 'intro.start', 'intro.skip', 'menu', 'options.set',
  'game.start', 'game.pause', 'game.resume', 'game.complete', 'game.checkpoint',
  'error', 'unknown', 'debug'
);

create table if not exists "analytics_action" (
  "id" uuid not null primary key,
  "t" analytics_action_type not null,
  "arg" json not null,
  "author" uuid not null references "system_users",
  "status" varchar(64) not null,
  "occurred" timestamp without time zone not null
);

create index if not exists "analytics_action_author" on "analytics_action" using btree ("author" asc);
create index if not exists "analytics_action_task" on "analytics_action" using btree ("t" asc);
