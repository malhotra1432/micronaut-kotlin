plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("io.micronaut.application") version "2.0.8"
    kotlin("plugin.serialization") version "1.5.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

version = "0.1"
group = "com.kodo.api"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.kodo.api.*")
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.3.1")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.0.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("io.github.microutils:kotlin-logging:2.1.0")
}

application {
    mainClass.set("com.kodo.api.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
