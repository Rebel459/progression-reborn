scoreboard players set @s 0 0
scoreboard players set @s 9 9

scoreboard players set @s hasCollection 0
execute if data entity @s SelectedItem{components:{"minecraft:enchantments":{levels:{"progression_reborn:collection": 1}}}} run scoreboard players set @s hasCollection 1
execute if score @s hasCollection = 0 run run return 0

execute store result score @s collectRawIronNuggets run clear @s progression_reborn:raw_iron_nugget 0
scoreboard players operation @s totalRawIronNuggets += @s collectRawIronNuggets
scoreboard players set @s collectRawIronNuggets 0
clear @s progression_reborn:raw_iron_nugget

execute if score @s totalRawIronNuggets >= @s 9 run give @s minecraft:raw_iron
execute if score @s totalRawIronNuggets >= @s 9 run scoreboard players remove @s totalRawIronNuggets 9
execute if score @s totalRawIronNuggets >= @s 9 run give @s minecraft:raw_iron
execute if score @s totalRawIronNuggets >= @s 9 run scoreboard players remove @s totalRawIronNuggets 9
execute if score @s totalRawIronNuggets >= @s 9 run give @s minecraft:raw_iron
execute if score @s totalRawIronNuggets >= @s 9 run scoreboard players remove @s totalRawIronNuggets 9
execute if score @s totalRawIronNuggets >= @s 9 run give @s minecraft:raw_iron
execute if score @s totalRawIronNuggets >= @s 9 run scoreboard players remove @s totalRawIronNuggets 9
execute if score @s totalRawIronNuggets >= @s 9 run give @s minecraft:raw_iron
execute if score @s totalRawIronNuggets >= @s 9 run scoreboard players remove @s totalRawIronNuggets 9

advancement revoke @s only progression_reborn:function/collected_raw_iron_nugget
