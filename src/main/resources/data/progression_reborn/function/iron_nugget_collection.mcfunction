scoreboard players set @s 0 0
scoreboard players set @s 9 9

scoreboard players set @s hasCollection 0
execute if data entity @s SelectedItem{components:{"minecraft:enchantments":{levels:{"progression_reborn:collection": 1}}}} run scoreboard players set @s hasCollection 1
execute if score @s hasCollection = 0 run run return 0

execute store result score @s collectIronNuggets run clear @s minecraft:iron_nugget 0
scoreboard players operation @s totalIronNuggets += @s collectIronNuggets
scoreboard players set @s collectIronNuggets 0
clear @s minecraft:iron_nugget

execute if score @s totalIronNuggets >= @s 9 run give @s minecraft:iron_ingot
execute if score @s totalIronNuggets >= @s 9 run scoreboard players remove @s totalIronNuggets 9
execute if score @s totalIronNuggets >= @s 9 run give @s minecraft:iron_ingot
execute if score @s totalIronNuggets >= @s 9 run scoreboard players remove @s totalIronNuggets 9
execute if score @s totalIronNuggets >= @s 9 run give @s minecraft:iron_ingot
execute if score @s totalIronNuggets >= @s 9 run scoreboard players remove @s totalIronNuggets 9
execute if score @s totalIronNuggets >= @s 9 run give @s minecraft:iron_ingot
execute if score @s totalIronNuggets >= @s 9 run scoreboard players remove @s totalIronNuggets 9
execute if score @s totalIronNuggets >= @s 9 run give @s minecraft:iron_ingot
execute if score @s totalIronNuggets >= @s 9 run scoreboard players remove @s totalIronNuggets 9

advancement revoke @s only progression_reborn:function/collected_iron_nugget