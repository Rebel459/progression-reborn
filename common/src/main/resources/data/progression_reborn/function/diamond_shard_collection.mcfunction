scoreboard players set @s 9 9


execute store result score @s collectDiamondShards run clear @s progression_reborn:diamond_shard 0
scoreboard players operation @s totalDiamondShards += @s collectDiamondShards
scoreboard players set @s collectDiamondShards 0
clear @s progression_reborn:diamond_shard

execute if score @s totalDiamondShards >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondShards >= @s 9 run scoreboard players remove @s totalDiamondShards 9
execute if score @s totalDiamondShards >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondShards >= @s 9 run scoreboard players remove @s totalDiamondShards 9
execute if score @s totalDiamondShards >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondShards >= @s 9 run scoreboard players remove @s totalDiamondShards 9
execute if score @s totalDiamondShards >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondShards >= @s 9 run scoreboard players remove @s totalDiamondShards 9
execute if score @s totalDiamondShards >= @s 9 run give @s minecraft:diamond
execute if score @s totalDiamondShards >= @s 9 run scoreboard players remove @s totalDiamondShards 9

advancement revoke @s only progression_reborn:function/collected_diamond_shard