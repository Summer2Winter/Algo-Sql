SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I inner join ANIMAL_OUTS O
on I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME