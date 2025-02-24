SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I inner join ANIMAL_OUTS O
                             ON I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY (O.DATETIME - I.DATETIME) desc
limit 2