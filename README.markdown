# Mt. Baker #

## Introduction ##

Mt. Baker is a Java/JVM software component for configuration management.

## Using ##

## Annotations ##

Using the @Configurable and @ConfigurableField annotations sophisticated configuration management can be as simple as this:

    @Configurable(namespace = "test")
    public class ConfigurableObject {

    	@ConfigurableField("test.string")
    	private String someString;

    	@ConfigurableField("test.boolean")
    	private boolean someBoolean;

    }

See ConfigurableObject and ConfigurationInjectionTestCase in the src/test/java/com/mtbaker/client/annotations/test director.

## Maven ##

    <dependencies>
        <dependency>
            <groupId>com.rubicon.oss</groupId>
            <artifactId>mt-baker</artifactId>
        </dependency>
    </dependencies>

    <repositories>
        <repository>
            <id>samtingleff-maven-snapshot-repo</id>
            <url>https://github.com/samtingleff/maven-repo/raw/master/snapshots</url>
            <layout>default</layout>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>daily</updatePolicy>
            </snapshots>
        </repository>
    </repositories>