# Write your MySQL query statement below
with daily_amount as ( select visited_on,sum(amount) as amount from Customer group by visited_on),

window_sum as (select visited_on,sum(amount) OVER(order by visited_on ROWS BETWEEN 6 PRECEDING and CURRENT ROW )as total_amount,count(*) OVER(order by visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
) as days_count from daily_amount)
select visited_on,total_amount as amount, round(total_amount / 7, 2) as average_amount from window_sum where days_count = 7;