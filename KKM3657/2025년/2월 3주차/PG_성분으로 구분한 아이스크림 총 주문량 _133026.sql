SELECT I.INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) TOTAL_ORDER
FROM ICECREAM_INFO I inner join FIRST_HALF F
on I.FLAVOR = F.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER