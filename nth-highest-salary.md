## Nth Highest Salary

Write a SQL query to get the n<sup>th</sup> highest salary from the ``Employee`` table.

> | Id | Salary |
 | :---: | :----: |
 | 1 | 100 |
 | 2 | 200 |
 | 3 | 300 |

 For example, given the above Employee table, the n<sup>th</sup> highest salary where n = 2 is ``200``. If there is no n<sup>th</sup> highest salary, then the query should return ``null``.

 > | getnthHighestSalary(2) |
  | :---: |
	| 200 |

## 代碼實現

```
select ifnull(Salary, null)
from
	(select distinct Salary
	 from Employee
	 order by Salary desc) s
limit N-1, 1;
```
