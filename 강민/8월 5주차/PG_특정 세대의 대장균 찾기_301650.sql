-- 코드를 작성해주세요
# 3세대
SELECT G.ID
FROM ECOLI_DATA G
WHERE G.PARENT_ID in (
    # 2세대
    SELECT P.ID
    FROM ECOLI_DATA P
    WHERE P.PARENT_ID in (
        # 1세대
        SELECT C.ID
        FROM ECOLI_DATA C
        WHERE C.PARENT_ID is NULL
    )
)
ORDER By G.ID