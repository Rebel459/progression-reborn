scoreboard players set @s 9 9

execute store result score @s collectRoseNuggets run clear @s progression_reborn:rose_nugget 0
scoreboard players operation @s totalRoseNuggets += @s collectRoseNuggets
scoreboard players set @s collectRoseNuggets 0
clear @s progression_reborn:rose_nugget

execute if score @s totalRoseNuggets >= @s 9 run give @s progression_reborn:rose_ingot
execute if score @s totalRoseNuggets >= @s 9 run scoreboard players remove @s totalRoseNuggets 9
execute if score @s totalRoseNuggets >= @s 9 run give @s progression_reborn:rose_ingot
execute if score @s totalRoseNuggets >= @s 9 run scoreboard players remove @s totalRoseNuggets 9
execute if score @s totalRoseNuggets >= @s 9 run give @s progression_reborn:rose_ingot
execute if score @s totalRoseNuggets >= @s 9 run scoreboard players remove @s totalRoseNuggets 9
execute if score @s totalRoseNuggets >= @s 9 run give @s progression_reborn:rose_ingot
execute if score @s totalRoseNuggets >= @s 9 run scoreboard players remove @s totalRoseNuggets 9
execute if score @s totalRoseNuggets >= @s 9 run give @s progression_reborn:rose_ingot
execute if score @s totalRoseNuggets >= @s 9 run scoreboard players remove @s totalRoseNuggets 9

advancement revoke @s only progression_reborn:function/collected_rose_nugget