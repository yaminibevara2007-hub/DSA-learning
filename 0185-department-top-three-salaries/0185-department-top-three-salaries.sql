with ranked_salaries as (select e.name as Employee, e.salary AS Salary, d.name AS Department,
dense_rank() over( PARTITION BY e.departmentId order by e.salary desc ) as rnk from Employee e
join Department d on e.departmentId = d.id)

select Department, Employee, Salary from ranked_salaries where rnk <= 3;