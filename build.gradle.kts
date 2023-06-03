import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    java
    application
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
}

application {
    mainClass.set("org.springframework.boot.loader.JarLauncher")
    version = "0.1.0"
    group = "org.example"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_11.toString()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")

    // Transitive dependencies
    maven("https://m2.dv8tion.net/releases")
    jcenter()
}

tasks.processResources {
    val tokens = mapOf(
        "project.version"    to project.version
    )

    filter(ReplaceTokens::class, mapOf("tokens" to tokens))
}

dependencies {
    compileOnly("com.github.lavalink-devs.Lavalink:plugin-api:3.7.5")
    runtimeOnly("com.github.lavalink-devs:Lavalink:3.7.5")

    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.21")
}

tasks.named<ShadowJar>("shadowJar") {
    val impl = project.configurations.named("implementation").get()
    impl.isCanBeResolved = true
    configurations = listOf(impl)
    archiveClassifier.set("")
}

publishing {
    publications {
        register("maven", MavenPublication::class) {
            pom {
                from(components["java"])
            }
        }
    }
}