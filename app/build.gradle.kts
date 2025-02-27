/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.11.1/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("info.picocli:picocli:4.7.6") 
 

  testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
  mainClass = "java.com.grocery.test"
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}