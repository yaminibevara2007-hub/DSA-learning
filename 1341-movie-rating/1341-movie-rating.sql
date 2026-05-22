( select u.name as results from Users u join MovieRating mr on u.user_id = mr.user_id
    group by u.user_id order by count(*) desc, u.name ASC LIMIT 1
)
UNION ALL

( select m.title as results from Movies m join MovieRating mr on m.movie_id = mr.movie_id
    where mr.created_at >= '2020-02-01' and mr.created_at < '2020-03-01'
     group by m.movie_id order by avg(mr.rating) desc, m.title ASC LIMIT 1
);