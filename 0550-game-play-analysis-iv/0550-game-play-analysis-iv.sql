select round(
        count(a.player_id) /  (select count(distinct player_id) from Activity),
        2) as fraction from Activity a
join ( select player_id,  min(event_date) as first_login from Activity group by player_id
) f on a.player_id = f.player_id and a.event_date = DATE_ADD(f.first_login, INTERVAL 1 day);