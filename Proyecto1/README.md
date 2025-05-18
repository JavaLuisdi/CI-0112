Proyecto 1 - CI-0112: Arcade de Batalla Naval y Ahorcado

Bienvenido al **Proyecto 1** del curso *CI-0112 - Programación I*. Este proyecto permite jugar dos juegos clásicos en consola, desarrollados completamente en Java:

- ⚓ Batalla Naval
- 🔤 Ahorcado

Ambos juegos están diseñados para dos jugadores, alternando turnos, con validación de entradas y condiciones claras de victoria.

---

## 📥 Instalación y Ejecución

1. Clonar el repositorio:

   git clone https://github.com/JavaLuisdi/CI-0112.git

2. Navegar al directorio del proyecto:

   cd CI-0112/Proyecto1

3. Compilar los archivos Java:

   javac *.java

4. Ejecutar el programa:

   java Main

Asegurate de tener Java 8 o superior instalado en tu sistema. Podés verificarlo con:

   java -version

---

## 🕹️ Ejecución del Programa

1. Abrí el proyecto en tu IDE preferido (BlueJ, Visual Studio Code, etc.).
2. Ejecutá la clase Main.java.
3. Aparecerá un menú con tres opciones:
   - 1. Ahorcado
   - 2. Batalla Naval
   - 3. Salir
4. Ingresá el número del juego que querés jugar y seguí las instrucciones en consola.

---

## 🎯 Juegos Incluidos

### 🔤 Ahorcado

- Jugador 1 escribe una palabra secreta.
- Jugador 2 intenta adivinarla, letra por letra.
- Tiene 6 oportunidades de error antes de perder.
- Luego se invierten los roles.
- Se pueden jugar múltiples rondas y se muestra un resumen de fallos y quién ganó.
- Al finalizar las rondas, se puede reiniciar el juego con nuevos jugadores.

### ⚓ Batalla Naval

- Cada jugador coloca 4 barcos de diferentes tamaños.
- Los barcos se colocan en un tablero de 5x5, eligiendo dirección (horizontal o vertical).
- Durante el juego:
  - Si acertás el disparo (¡Tocado!), jugás de nuevo.
  - Si fallás (¡Agua!), el turno pasa al otro jugador.
- El juego termina cuando un jugador hunde todos los barcos del otro.
- Se pueden jugar varias partidas seguidas.

---

## 📂 Clases del Proyecto

- Main.java – Punto de entrada del programa.
- GUI.java – Muestra el menú principal y controla el flujo general de los juegos.
- Ahorcado.java – Contiene la lógica del juego de ahorcado.
- JugadorAhorcado.java – Clase para llevar registro de nombre y fallos de cada jugador.
- BatallaNaval.java – Controla el flujo del juego naval: colocar barcos, turnos, ataques.
- Barco.java – Representa un barco con posición, largo y ancho.
- Tablero.java – Representa la matriz 5x5 de cada jugador y métodos para mostrarla.
- README.md – Este archivo de ayuda.
- Archivo de decisiones.txt – Documento donde explicamos acuerdos, diseño y mejoras futuras.

---

## ✅ Requisitos

- Java 8 o superior.
- Entrada y salida en consola (Scanner y System.out.print).
- Código modular, limpio y separado.

---

## 🧰 Solución de Problemas

- Error al compilar: Asegúrate de estar en el directorio correcto y que todos los archivos .java estén presentes.
- Java no está instalado: Descargá e instalá Java.
- Problemas al ejecutar el juego: Verificá que la clase Main contiene el método main() y que estás ejecutando desde el directorio correcto.

---

## 👥 Créditos

Desarrollado por:

- David Araya Montero – C4C553
- [Nombre 2] – [Carné]

Para el curso de *Programación I*, grupo C0112, ciclo 2025-1.

---

¡Gracias por jugar! 🎉