scoreboard players set @s 0 0
scoreboard players set @s 9 9

scoreboard players set @s hasCollection 0
execute if data entity @s SelectedItem{components:{"minecraft:enchantments":{levels:{"progression_reborn:collection": 1}}}} run scoreboard players set @s hasCollection 1
execute if score @s hasCollection = 0 run run return 0

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