scoreboard players set @s 9 9

execute store result score @s collectCopperNuggets run clear @s progression_reborn:copper_nugget 0
scoreboard players operation @s totalCopperNuggets += @s collectCopperNuggets
scoreboard players set @s collectCopperNuggets 0
clear @s progression_reborn:copper_nugget

execute if score @s totalCopperNuggets >= @s 9 run give @s minecraft:copper_ingot
execute if score @s totalCopperNuggets >= @s 9 run scoreboard players remove @s totalCopperNuggets 9
execute if score @s totalCopperNuggets >= @s 9 run give @s minecraft:copper_ingot
execute if score @s totalCopperNuggets >= @s 9 run scoreboard players remove @s totalCopperNuggets 9
execute if score @s totalCopperNuggets >= @s 9 run give @s minecraft:copper_ingot
execute if score @s totalCopperNuggets >= @s 9 run scoreboard players remove @s totalCopperNuggets 9
execute if score @s totalCopperNuggets >= @s 9 run give @s minecraft:copper_ingot
execute if score @s totalCopperNuggets >= @s 9 run scoreboard players remove @s totalCopperNuggets 9
execute if score @s totalCopperNuggets >= @s 9 run give @s minecraft:copper_ingot
execute if score @s totalCopperNuggets >= @s 9 run scoreboard players remove @s totalCopperNuggets 9

advancement revoke @s only progression_reborn:function/collected_copper_nugget