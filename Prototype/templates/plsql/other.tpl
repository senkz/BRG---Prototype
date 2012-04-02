create or replace
TRIGGER {trigger_name}
BEFORE {trigger_event} ON {trigger_table}
FOR EACH ROW
BEGIN
IF {custom_code}
THEN raise_application_error(-20000, '[{error_code}] {error_message}');
END IF;
END;