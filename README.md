# XHMPublicChest (XPC)

这是一个基于Minecraft Spigot 1.19.2服务端的插件，为玩家了提供了更多的空间

## 指令手册：

1. /xpc create <ID> - ID只能为整数，XPC会根据ID创建一个PublicChest
  
2. /xpc open <ID> - ID只能为整数，XPC会根据所给的ID打开其对应的PublicChest
  
3. /xpc remove <ID> - ID只能为整数，XPC会根据所给的ID删除其所对应的PublicChest
  
4. /xpc remove <player> - 删除玩家所有的PublicChest
  
5. /xpc list - 列出服务器上存在的所有PublicChest
  
6. /xpc list <player> - 列出玩家所拥有的所有PublicChest
  

## 注意事项

该插件暂时不能提供长久的物品储存，以至于插件重载后会删除所有的PublicChest，其数据库功能或许将在以后的版本加入，因此您可以利用此特性来作为PublicChest的费用
