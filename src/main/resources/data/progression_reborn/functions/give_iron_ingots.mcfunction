# Выдаём 1 слиток и уменьшаем счётчик
give @s minecraft:iron_ingot
scoreboard players remove @s temp 1

# Повторяем, пока temp > 0
execute if score @s temp matches 1.. run function progression_reborn:give_iron_ingots
