with same_tiv as (select tiv_2015 from Insurance group by tiv_2015 having count(*) > 1),

unique_city as ( select lat, lon from Insurance group by lat, lon having count(*) = 1)

select round(sum(tiv_2016), 2) as tiv_2016 from Insurance where tiv_2015 in (
select tiv_2015 from same_tiv)and (lat, lon) in (select lat, lon from unique_city);