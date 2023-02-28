-- таблица логирования для аккаунтов
CREATE TABLE account_logs_table
(
    acc_id    BIGINT,
    tstamp    TIMESTAMP(0) DEFAULT current_timestamp,
    operation TEXT,
    new_val   json,
    old_val   json
);

-- таблица логирования для форм
CREATE TABLE form_logs_table
(
    form_id   BIGINT,
    tstamp    TIMESTAMP(0) DEFAULT current_timestamp,
    operation TEXT,
    new_val   json,
    old_val   json
);

-- создаем триггер для записи изменений в таблицу логирования аккаунтов

CREATE OR REPLACE FUNCTION change_acc_trigger() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT'
    THEN
        INSERT INTO account_logs_table (acc_id, operation, new_val)
        VALUES (NEW.id, TG_OP, row_to_json(NEW));
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE'
    THEN
        INSERT INTO account_logs_table (acc_id, operation, new_val, old_val)
        VALUES (NEW.id, TG_OP, row_to_json(NEW), row_to_json(OLD));
        RETURN NEW;
    ELSIF TG_OP = 'DELETE'
    THEN
        INSERT INTO account_logs_table (acc_id, operation, old_val)
        VALUES (OLD.id, TG_OP, row_to_json(OLD));
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE 'plpgsql' SECURITY DEFINER;

-- вешаем его на таблицу аккаунтов

CREATE OR REPLACE TRIGGER accounts_info_trigger
    BEFORE INSERT OR UPDATE OR DELETE
    ON account_table
    FOR EACH ROW
EXECUTE PROCEDURE change_acc_trigger();

-- повторить для второй таблицы

CREATE OR REPLACE FUNCTION change_form_trigger() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT'
    THEN
        INSERT INTO form_logs_table (form_id, operation, new_val)
        VALUES (NEW.id, TG_OP, row_to_json(NEW));
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE'
    THEN
        INSERT INTO form_logs_table (form_id, operation, new_val, old_val)
        VALUES (NEW.id, TG_OP, row_to_json(NEW), row_to_json(OLD));
        RETURN NEW;
    ELSIF TG_OP = 'DELETE'
    THEN
        INSERT INTO form_logs_table (form_id, operation, old_val)
        VALUES (OLD.id, TG_OP, row_to_json(OLD));
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE 'plpgsql' SECURITY DEFINER;

-- повторить для второй таблицы

CREATE OR REPLACE TRIGGER forms_info_trigger
    BEFORE INSERT OR UPDATE OR DELETE
    ON form_table
    FOR EACH ROW
EXECUTE PROCEDURE change_form_trigger();