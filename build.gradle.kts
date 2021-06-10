import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("dev.kord:kord-core:0.7.0-RC3")
    implementation("org.slf4j:slf4j-simple:1.6.1")
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
}

tasks.test {
    useJUnit()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

