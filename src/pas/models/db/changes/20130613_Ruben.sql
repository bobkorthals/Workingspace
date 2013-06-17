ALTER TABLE factuuritem
ADD COLUMN vestigingid INTEGER,
ADD COLUMN aantal INTEGER,
ADD CONSTRAINT fk_factuuritem_vestiging FOREIGN KEY (vestigingid) REFERENCES vestiging(id);

ALTER TABLE factuur
ALTER COLUMN tijddatum SET DEFAULT CURRENT_DATE,
ADD COLUMN status INTEGER NOT NULL DEFAULT 1;

DROP FUNCTION factuurid(INTEGER);

CREATE OR REPLACE FUNCTION factuurid(lid INTEGER)
RETURNS INTEGER AS
$BODY$
    DECLARE factuurid INTEGER;
    BEGIN
        SELECT id INTO factuurid
        FROM factuur
        WHERE factuur.lidid = $1
        AND factuur.status = 1;

        IF factuurid IS NULL THEN
            INSERT INTO factuur(lidid)
            VALUES($1)
            RETURNING factuur.id INTO factuurid;
        END IF;	

        RETURN factuurid;
    END;
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;
