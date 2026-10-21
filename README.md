# Cloudstep

<img src="docs/cloudstep_feather.png" width="128" alt="Cloudstep Feather item texture">

A Fabric mod for Minecraft Java Edition that adds one custom item: the **Cloudstep Feather**.

## How it works

| Action | Effect | Cooldown |
| --- | --- | --- |
| Right-click | Jump Boost III for 6 seconds and Slow Falling for 12 seconds | 40 seconds |
| Sneak + right-click | Slow Falling for 40 seconds | 60 seconds |

The first mode launches you up and lets you land softly. The second mode is for gliding down from a high place.

The cooldown shows as an overlay on the item in your hotbar.

## Recipe

A feather, a phantom membrane and an amethyst shard, in any order (shapeless).

## Requirements

- Minecraft Java Edition 26.3
- Fabric Loader 0.19.3 or newer
- Fabric API
- Java 25 to build the mod

## Run it in development

```bash
./gradlew runClient
```

On Windows PowerShell use `.\gradlew runClient`. In the test world run:

```
/give @s cloudstep:cloudstep_feather
```

## Build the jar

```bash
./gradlew build
```

The jar is written to `build/libs/`. Put it in your `mods` folder together with Fabric API.

GitHub Actions also builds the jar on every push. Download it from the **Actions** tab, under the latest run's artifacts.

## Tuning

All numbers (durations, jump level, cooldowns) are constants at the top of `CloudstepFeather.java`.

## Project layout

| Path | Purpose |
| --- | --- |
| `CloudstepMod.java` | Mod entry point |
| `ModItems.java` | Registers the item and adds it to the creative tab |
| `item/CloudstepFeather.java` | Right-click behaviour and tooltip |
| `assets/cloudstep/` | Texture, model, item definition and English text |
| `data/cloudstep/recipe/` | Crafting recipe |

## License

MIT
