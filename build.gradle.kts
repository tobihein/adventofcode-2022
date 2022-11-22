plugins {
    kotlin("jvm") version "1.7.21"
}

repositories {
    mavenCentral()
}

tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")
        }
        test {
            java.srcDirs("test")
        }
    }

    wrapper {
        gradleVersion = "7.5.1"
    }
}
