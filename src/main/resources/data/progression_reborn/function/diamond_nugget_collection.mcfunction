scoreboard players set @s 9 9


execute store result score @s collectDiamondNuggets run clear @s progression_reborn:diamond_nugget 0
scoreboard players operation @s totalDiamondNuggets += @s collectDiamondNuggets
scoreboard players set @s collectDiamondNuggets 0
clear @s progression_reborn:diamond_nugget

execute if score @s totalDiamondNuggets >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondNuggets >= @s 9 run scoreboard players remove @s totalDiamondNuggets 9
execute if score @s totalDiamondNuggets >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondNuggets >= @s 9 run scoreboard players remove @s totalDiamondNuggets 9
execute if score @s totalDiamondNuggets >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondNuggets >= @s 9 run scoreboard players remove @s totalDiamondNuggets 9
execute if score @s totalDiamondNuggets >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondNuggets >= @s 9 run scoreboard players remove @s totalDiamondNuggets 9
execute if score @s totalDiamondNuggets >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondNuggets >= @s 9 run scoreboard players remove @s totalDiamondNuggets 9

advancement revoke @s only progression_reborn:function/collected_diamond_nugget