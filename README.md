# lavalink-plugin-template

This is a template for creating a plugin for [Lavalink](https://github.com/lavalink-devs/Lavalink). It is written in
java, but you can also use kotlin (version `1.8.22`) if you want.

## How to use this template

1. Clone this repository
2. Rename the package `com.example.plugin` to your package name
3. Rename the class `ExamplePlugin` to your plugin name
4. Rename the file `ExamplePlugin.java` to your plugin name
5. fill in the `lavalinkPlugin` in [build.gradle.kts](build.gradle.kts)
6. Write your plugin

## How to test your plugin

1. Place a `application.yml` file in the root directory (see [here](https://lavalink.dev/configuration/index.html#example-applicationyml) for an example)
2. Run `./gradlew runLavalink` (for windows: `./gradlew.bat runLavalink`) in the root directory
3. The plugin will be loaded
4. You can now test your plugin
5. If you change something in the plugin, you can just run `./gradlew runLavalink` again

## How to build your plugin

1. Run `./gradlew build` (for windows: `./gradlew.bat build`) in the root directory
2. The jar file will be in `build/libs/`

## How to publish your plugin

This template uses [jitpack](https://jitpack.io/) to publish the plugin. You just need to push your changes to github
and jitpack will build the plugin for you.

## How to use your plugin

Go to [jitpack](https://jitpack.io/) and paste the link to your repository. There you can find the version you want to use.

```yml
lavalink:
  plugins:
    - dependency: com.github.lavalink:lavalink-plugin-template:{VERSION} # replace {VERSION} with the version you want to use from jitpack
      repository: https://jitpack.io
```

## How to get help

If you need help, you can join the [Lavalink Discord Server](https://discord.gg/jttmwHTAad) and ask in
the `#plugin-dev` channel.
