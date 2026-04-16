scoreboard players set @s 9 9

execute store result score @s collectRawCopperNuggets run clear @s progression_reborn:raw_copper_nugget 0
scoreboard players operation @s totalRawCopperNuggets += @s collectRawCopperNuggets
scoreboard players set @s collectRawCopperNuggets 0
clear @s progression_reborn:raw_copper_nugget

execute if score @s totalRawCopperNuggets >= @s 9 run give @s minecraft:raw_copper
execute if score @s totalRawCopperNuggets >= @s 9 run scoreboard players remove @s totalRawCopperNuggets 9
execute if score @s totalRawCopperNuggets >= @s 9 run give @s minecraft:raw_copper
execute if score @s totalRawCopperNuggets >= @s 9 run scoreboard players remove @s totalRawCopperNuggets 9
execute if score @s totalRawCopperNuggets >= @s 9 run give @s minecraft:raw_copper
execute if score @s totalRawCopperNuggets >= @s 9 run scoreboard players remove @s totalRawCopperNuggets 9
execute if score @s totalRawCopperNuggets >= @s 9 run give @s minecraft:raw_copper
execute if score @s totalRawCopperNuggets >= @s 9 run scoreboard players remove @s totalRawCopperNuggets 9
execute if score @s totalRawCopperNuggets >= @s 9 run give @s minecraft:raw_copper
execute if score @s totalRawCopperNuggets >= @s 9 run scoreboard players remove @s totalRawCopperNuggets 9

advancement revoke @s only progression_reborn:function/collected_raw_copper_nugget
