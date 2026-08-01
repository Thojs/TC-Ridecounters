plugins {
    kotlin("jvm") version "2.4.10"
    id("com.gradleup.shadow") version "9.3.0"
}

group = "be.mrtibo"
version = "2.0.1"

val javaVersion: JavaLanguageVersion = JavaLanguageVersion.of(26)

repositories {
    mavenCentral()

    maven ("https://repo.papermc.io/repository/maven-public/")
    maven ("https://oss.sonatype.org/content/groups/public/")
    maven("https://ci.mg-dev.eu/plugin/repository/everything/")
}

dependencies {
    implementation(kotlin("stdlib"))

    compileOnly("io.papermc.paper:paper-api:26.2.build.+")

    compileOnly("com.bergerkiller.bukkit:TrainCarts:2.0.0")
    compileOnly("com.bergerkiller.bukkit:BKCommonLib:2.0.1")

    implementation("org.incendo:cloud-paper:2.0.0")
    implementation("org.incendo:cloud-annotations:2.1.0")
    implementation("org.incendo:cloud-minecraft-extras:2.0.0")
    implementation("org.incendo:cloud-kotlin-coroutines-annotations:2.1.0")
//    implementation("org.incendo:cloud-kotlin-coroutines:2.0.0")

    implementation("com.zaxxer:HikariCP:7.1.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")

    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.9")
    implementation("org.bstats:bstats-bukkit:3.2.1")

}

tasks {
    assemble {
        dependsOn(shadowJar)
    }
    shadowJar {
        relocate("kotlinx.coroutines", "be.mrtibo.lib.kotlinx.coroutines")
        relocate("org.incendo.cloud", "be.mrtibo.lib.cloud")
        relocate("org.bstats", "be.mrtibo.lib.bstats")

        val commonPrefix = "com.bergerkiller.bukkit.common.dep"
        relocate("io.leangen.geantyref", "$commonPrefix.typetoken")
        relocate("me.lucko.commodore", "$commonPrefix.me.lucko.commodore")
//        relocate("net.kyori", "$commonPrefix.net.kyori")
    }

}

java {
    toolchain.languageVersion.set(javaVersion)
}