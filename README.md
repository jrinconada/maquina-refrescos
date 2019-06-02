# Máquina de refrescos
La aplicación simula el comportamiento de una **máquina de refrescos** mediante mensajes por consola y usando el teclado como método de entrada de información.

Al ejecutar la aplicación se muestran los refrescos disponibles con su precio, se espera el nombre de un refresco dando opción de salir (no se diferencia entre mayúsculas y minúsculas). Si el refresco está disponible se pide el dinero, que debe ser un importe suficiente representado por un números separado por una coma en caso de tener decimales, por ejemplo dos euros y medio serían: `2,4` . Si el importe es adecuado se mostrará el cambio indicando la cantidad de monedas de cada tipo que se van a devolver. A continuación, se vuelve a dar la opción de comprar otro refresco o salir.

## Estructura del código
La estructura general de la aplicación se compone de **cuatro clases**, cada una con un cometido específico:
- `MaquinaRefrescos`: **Interacción** con el usuario y con las clases de almacenamiento de refrescos y **gestión** de cambio.
- `Inventario`: **Almacenamiento** de refrescos.
- `Refresco`: Representación de **refresco**.
- `Cambio`: Gestión de **cambio** (almacenamiento del cambio disponible y devolución de monedas).
