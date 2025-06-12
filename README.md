# 🏴‍☠️ Les Pirates - Juego de Mesa en Java

Un juego de mesa por turnos para 2 jugadores ambientado en el mundo de los piratas, desarrollado en Java con interfaz de terminal.

## 🎯 Objetivo del Juego

**Ganar siendo el primero en llegar a la casilla 30** o eliminando al adversario (reduciendo sus corazones a 0).

## ⚔️ Mecánicas de Juego

### Jugadores
- **Billy** (Azul) vs **Mandy** (Verde)
- Cada jugador inicia con **5 corazones** de vida
- Se turnan para lanzar 2 dados y avanzar

### Tablero
- **30 casillas** dispuestas en cuadrícula 6x5
- **Casillas especiales** colocadas aleatoriamente:
  - **[V] Vent Favorable** (2 casillas): Avanza 10 casillas extra
  - **[C] Canon** (5 casillas): Ataca o persigue al enemigo
  - **[R] Rhum** (2 casillas): +2 corazones pero retrocede 3 casillas

### Efectos de Casillas Especiales

#### 🌪️ Vent Favorable
- **Efecto**: Avanzas 10 casillas adicionales
- **Beneficio**: Acelera tu llegada a la meta

#### 💣 Canon
- **Si el enemigo está adelante**: Lo atacas (-2 corazones, 2 turnos inmóvil)
- **Si el enemigo está atrás**: Avanzas hasta su posición

#### 🍺 Rhum
- **Beneficio**: Recuperas 2 corazones (máximo 5)
- **Penalización**: Retrocedes 3 casillas
- **Límite**: No puedes tener más de 5 corazones

## 🎮 Cómo Jugar

1. **Lanzar dados**: Presiona ENTER en tu turno
2. **Avanzar**: Te mueves automáticamente según la suma de los dados
3. **Efectos**: Las casillas especiales se activan automáticamente
4. **Victoria**: Llega a la casilla 30 o elimina al adversario

## 🏆 Condiciones de Victoria

- **Victoria por llegada**: Primer jugador en alcanzar la casilla 30
- **Victoria por eliminación**: Reducir los corazones del enemigo a 0

## 🛠️ Estructura del Código

### Clases Principales
- **`Control.java`**: Punto de entrada del programa
- **`Jeu.java`**: Lógica principal del juego y bucle de turnos
- **`Joueur.java`**: Representa a cada jugador (posición, vida, estado)
- **`Plateau.java`**: Maneja el tablero y casillas especiales
- **`Affichage.java`**: Gestiona toda la visualización y mensajes

### Sistema de Casillas
- **`Cases.java`**: Clase abstracta base para casillas especiales
- **`Canon.java`**: Implementa la lógica de ataque/persecución
- **`Rhum.java`**: Implementa recuperación de vida con penalización
- **`VentFavo.java`**: Implementa avance extra

### Utilidades
- **`Des.java`**: Generador de números aleatorios para los dados

### Prerrequisitos
- Java Development Kit (JDK) 8 o superior
- Terminal/PowerShell
