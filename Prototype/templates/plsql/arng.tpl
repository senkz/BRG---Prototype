create or replace
TRIGGER {trigger_name}
BEFORE {trigger_event} ON {trigger_table}
FOR EACH ROW
BEGIN
IF :new.{first_value} {operator} {second_value} AND {third_value}
THEN raise_application_error(-20000, '[{error_code}] {error_message}');
END IF;
END;