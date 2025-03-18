SELECT CAR_ID, (
CASE
WHEN SUM (
        CASE
                WHEN '2022-10-16' Between START_DATE and END_DATE THEN 1
                else 0
                END
) = 1 then '대여중'
        else '대여 가능'
END
) AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID desc