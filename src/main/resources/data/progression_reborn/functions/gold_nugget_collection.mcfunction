scoreboard players set @s 9 9

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