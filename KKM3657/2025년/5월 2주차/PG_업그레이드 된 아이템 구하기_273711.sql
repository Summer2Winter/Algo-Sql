SELECT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I inner join
     (
         SELECT T.ITEM_ID
         FROM ITEM_TREE T
         WHERE T.PARENT_ITEM_ID IN (
             SELECT I.ITEM_ID
             FROM ITEM_INFO I
             WHERE I.RARITY = 'RARE'
         )
     ) ITEM_RARE
     on I.ITEM_ID = ITEM_RARE.ITEM_ID
ORDER BY I.ITEM_ID desc;

SELECT CHILD.ITEM_ID, CHILD.ITEM_NAME, CHILD.RARITY
FROM ITEM_TREE T inner join ITEM_INFO PARENT
                            ON T.PARENT_ITEM_ID = PARENT.ITEM_ID AND PARENT.RARITY = 'RARE'
                 inner join ITEM_INFO CHILD
                            ON T.ITEM_ID = CHILD.ITEM_ID
ORDER BY CHILD.ITEM_ID desc