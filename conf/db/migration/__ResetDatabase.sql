truncate analytics_action;

truncate audit_record;

delete from audit;

truncate note;

delete from system_users where id != '00000000-0000-0000-0000-000000000000'::uuid;
