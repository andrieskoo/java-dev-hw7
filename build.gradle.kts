plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.h2database:h2:2.2.224")
    implementation("org.apache.logging.log4j:log4j-core:2.23.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}