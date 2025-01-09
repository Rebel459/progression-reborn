scoreboard players set @s 0 0
scoreboard players set @s 9 9

scoreboard players set @s hasCollection 0
execute if data entity @s SelectedItem{components:{"minecraft:enchantments":{levels:{"progression_reborn:collection": 1}}}} run scoreboard players set @s hasCollection 1
execute if score @s hasCollection = 0 run run return 0

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