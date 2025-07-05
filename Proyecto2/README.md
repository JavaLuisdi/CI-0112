Proyecto 2 - CI-0112: Veterinaria los Trolls

Bienvenido al proyecto de desarrollo de una aplicación para gestionar una veterinaria. Este proyecto implementa una solución en Java para administrar cola de espera de mascotas, registrar historial de atención y mantener un registro de mascotas mediante un árbol binario.


---

## 📥 Instalación y Ejecución

1. Clonar el repositorio:

   git clone https://github.com/JavaLuisdi/CI-0112.git

2. Navegar al directorio del proyecto:

   cd CI-0112/Proyecto2

3. Compilar los archivos Java:

   javac *.java

4. Ejecutar el programa:

   java Main

Asegurate de tener Java 8 o superior instalado en tu sistema. Podés verificarlo con:

   java -version

---

## 🖱️ Interfaz de Usuario

1. La aplicación cuenta con una interfaz gráfica intuitiva donde puedes:
2. Atender la siguiente mascota en la fila
3. Agregar una nueva mascota a la fila y al registro
4. Mostrar la fila de mascotas esperando, etc......

---

## 🎯 Funcionalidades Principales

### Manejo de la Fila de Espera

- Se implementó una estructura de cola para administrar el orden de atención de las mascotas.
- Los archivos Cola.java y Nodo.java permiten insertar y eliminar mascotas de la fila.
- Registro de Historial
- Las mascotas atendidas se guardan en un historial, también implementado con una cola.
- Esta información se persiste en el archivo historial.txt.

### Árbol Binario de Registro

- Se utilizó un árbol binario para almacenar y gestionar el registro de todas las mascotas.
- Implementado en ArbolBinario.java, permite:
  - Insertar nuevas mascotas
  - Buscar mascotas por nombre
  - Eliminar mascotas del registro
- La estructura del árbol se visualiza gráficamente en una ventana adicional.

---

## ✅ Requisitos

- Java 8 o superior.
- Código modular, limpio y separado.

---

## 🧰 Solución de Problemas

- Error al compilar: Asegúrate de estar en el directorio correcto y que todos los archivos .java estén presentes.
- Java no está instalado: Descargá e instalá Java.

---

## 👥 Créditos

Desarrollado por:

- Luis Diego Elizondo Fennell – C4E844
- Christopher Chacon Mora – C32037

Para el curso de *Programación I*, ciclo 2025-1.

---

¡Gracias! 🎉
