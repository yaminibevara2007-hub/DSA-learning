select
    case
        when id % 2 = 1 and id = (select count(*) from  Seat)
            THEN id
        WHEN id % 2 = 1
            THEN id + 1
        ELSE id - 1
    END AS id,
    student
FROM Seat
ORDER BY id;