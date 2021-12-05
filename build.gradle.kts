plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.1.0"
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
    kapt("io.micronaut:micronaut-http-validation:3.1.4")
    kapt("io.micronaut.data:micronaut-data-processor:3.1.2")
    implementation("io.micronaut:micronaut-http-client:3.1.4")
    implementation("io.micronaut:micronaut-runtime:3.1.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.3.1")
    implementation("io.micronaut.graphql:micronaut-graphql:3.0.0")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.0.0")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("io.github.microutils:kotlin-logging:2.1.0")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.7")
    testImplementation("org.assertj:assertj-core:3.21.0")
    testImplementation("org.testcontainers:junit-jupiter:1.16.2")
    testImplementation("org.testcontainers:testcontainers:1.16.2")
    implementation("io.micronaut:micronaut-validation:3.1.4")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")

    testImplementation("org.hamcrest:hamcrest:2.2")

    testImplementation("org.mockito:mockito-core:4.0.0")
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
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
