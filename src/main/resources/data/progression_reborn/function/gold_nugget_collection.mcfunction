scoreboard players set @s 0 0
scoreboard players set @s 9 9

scoreboard players set @s hasCollection 0
execute if data entity @s SelectedItem{components:{"minecraft:enchantments":{levels:{"progression_reborn:collection": 1}}}} run scoreboard players set @s hasCollection 1
execute if score @s hasCollection = 0 run run return 0

execute store result score @s collectGoldNuggets run clear @s minecraft:gold_nugget 0
scoreboard players operation @s totalGoldNuggets += @s collectGoldNuggets
scoreboard players set @s collectGoldNuggets 0
clear @s minecraft:gold_nugget

execute if score @s totalGoldNuggets >= @s 9 run give @s minecraft:gold_ingot
execute if score @s totalGoldNuggets >= @s 9 run scoreboard players remove @s totalGoldNuggets 9
execute if score @s totalGoldNuggets >= @s 9 run give @s minecraft:gold_ingot
execute if score @s totalGoldNuggets >= @s 9 run scoreboard players remove @s totalGoldNuggets 9
execute if score @s totalGoldNuggets >= @s 9 run give @s minecraft:gold_ingot
execute if score @s totalGoldNuggets >= @s 9 run scoreboard players remove @s totalGoldNuggets 9
execute if score @s totalGoldNuggets >= @s 9 run give @s minecraft:gold_ingot
execute if score @s totalGoldNuggets >= @s 9 run scoreboard players remove @s totalGoldNuggets 9
execute if score @s totalGoldNuggets >= @s 9 run give @s minecraft:gold_ingot
execute if score @s totalGoldNuggets >= @s 9 run scoreboard players remove @s totalGoldNuggets 9

advancement revoke @s only progression_reborn:function/collected_gold_nugget