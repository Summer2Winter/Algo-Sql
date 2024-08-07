SELECT CONCAT('/home/grep/src/', B.BOARD_ID, '/', B.FILE_ID, B.FILE_NAME, B.FILE_EXT) FILE_PATH
FROM USED_GOODS_BOARD A Inner Join USED_GOODS_FILE B
ON A.BOARD_ID = B.BOARD_ID
WHERE A.BOARD_ID = (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS desc
    limit 1
    )
ORDER BY B.FILE_ID desc