<p align="center"><img src="https://raw.githubusercontent.com/DrakesCraft-Labs/NotEnoughAddons/main/banner.svg" alt="NotEnoughAddons" width="100%"></p>

# NotEnoughAddons

> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.net` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rR7FbfCt9Y)
> * 🌐 **Web & Guía**: [drakescraft.net](https://drakescraft.net) — 🛒 **Tienda**: [tienda.drakescraft.net](https://tienda.drakescraft.net)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

Cajón de sastre de máquinas, mochilas y armas cortas para Slimefun, adaptado al ecosistema de
**DrakesCraft** (Paper/Purpur 1.21.11, Java 21).

## Qué añade

**Máquinas.** El Fabricador de Polvo Económico, un todo en uno barato que saca polvo de mineral
directamente de la roca y sus variantes — andesita, granito, diorita —, sin tener que montar la
cadena completa.

**Objetos de utilidad.** El Bloque Ángel, que coloca un bloque bajo tus pies y viene muy bien en
el aire. La Burbuja Voladora, que deja volar en modo creativo a 45 bloques a la redonda. La
Mochila de Minero, de 54 huecos, que guarda los minerales sola al recogerlos con solo llevarla en
el inventario.

**Armas cortas** al estilo Terraria, en ocho materiales — estaño, cobre, hierro, plata, oro,
plomo, platino y tungsteno —, cada una con su daño cuerpo a cuerpo, su probabilidad de crítico y
su retroceso.

## Qué cambiamos

Este repositorio **no es un fork**: es el código original integrado en el ecosistema de
DrakesCraft.

**Dos dependencias fuera.** Usaba GuizhanLib solo para el autoactualizador — que se descargaba
jars de un repositorio ajeno y se reemplazaba solo, así que sobra — y ExtraUtils para una única
clase, `LoreBuilderDynamic`, de la que solo llamaba a dos métodos que el `LoreBuilder` de nuestro
core ya tiene tal cual. Sin ellas, el `maven-shade-plugin` dejó de tener nada que relocalizar y de
generar un artefacto vacío con clasificador `-shaded` que era fácil desplegar por error.

**Al día con 1.21.11.** Los paquetes de Slimefun pasan a `com.github.drakescraft_labs`, incluido
el árbol antiguo: `me.mrCookieSlime.Slimefun` se corresponde con
`com.github.drakescraft_labs.slimefun4.legacy`, **sin el segmento `Slimefun`** — la carpeta sigue
llamándose así, pero los ficheros no lo declaran.

**Todo en español.** El fork del que partimos tenía en chino los nombres, las descripciones, las
escalas de velocidad y retroceso y los mensajes de comando; está traducido entero.

## Instalación

Necesita Slimefun de DrakesCraft (`Slimefun4-Drake`). Se pone el jar en `plugins/` y listo.

## Crédito

El trabajo de fondo es de **fhoz**. Nosotros solo lo hemos adaptado. Los detalles de procedencia y
licencia están en [UPSTREAM.md](UPSTREAM.md).

## ⚖️ Upstream Attribution & License / Licencia y Créditos

- **Original Project / Upstream**: Slimefun4 Community Addon.
- **Port & Maintenance**: DrakesCraft Labs team (Compatibility for Paper / Purpur 1.21.11).
- **License**: GPL-3.0 / MIT.
- **Source Code**: [GitHub Repository](https://github.com/DrakesCraft-Labs/NotEnoughAddons)
- **Support & Issues**: [GitHub Issues](https://github.com/DrakesCraft-Labs/NotEnoughAddons/issues) | [Discord](https://discord.gg/rR7FbfCt9Y)

*This project is an open-source derivative work maintained by DrakesCraft Labs under the terms of its original license. All original assets and concepts belong to their respective creators.*
