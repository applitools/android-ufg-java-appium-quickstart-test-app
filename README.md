# android-ufg-java-appium-quickstart-test-app
A Test Application for the Appium Android UFG projec

## Installation

Add following urls to repositories in the main `build.gradle` or `settings.gradle` file
```
// This is needed to get UFG libs
maven {
    url uri("https://applitools.jfrog.io/artifactory/Android")
}
maven {
    url "https://applitools.jfrog.io/artifactory/ufg-android"
    credentials {
        username = System.getenv("ANDROID_UFG_BETA_USERNAME").toString()
        password = System.getenv("ANDROID_UFG_BETA_PASSWORD").toString()
    }
}
```

Then add the following dependencies to your application `build.gradle` file
```
// UFG libs - start
implementation "com.applitools:common-androidx:1.0.16"
implementation("com.applitools:vhs-androidx:1.0.16") {
    exclude module: 'commons-logging'
}
implementation ("com.applitools:eyes-common-java3:3.208.2") {
    exclude group: 'com.applitools', module: 'eyes-connectivity-java3-jersey2x'
    exclude module: 'commons-logging'
}
implementation ("com.applitools:eyes-connectivity-java3-net:3.208.2" ){
    exclude module: 'commons-logging'
}
// UFG libs - end
```

### Compile application with UFG library

Before compiling application should add initialization of UFG library in the main application class.
```
EyesUfg.setup(this, logger, "API_KEY_HERE", EyesUfg.Mode.PULL_VHS_MODE);
```

### Example

```
import android.app.Application
import com.applitools.eyes.Logger
import com.applitools.vhs.EyesUfg

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val logger = Logger()
        EyesUfg.setup(this, logger, "API_KEY_HERE", EyesUfg.Mode.PULL_VHS_MODE);
    }
}
```

## Possible issues

We can have duplicated META files from or libraries. To exclude them next lines should be added into the application `build.gradle` file, `android` section.
```
// This is needed to exclude duplicated META-INF
packagingOptions {
    exclude 'META-INF/**'
    exclude 'changelog.xml'
}
```
