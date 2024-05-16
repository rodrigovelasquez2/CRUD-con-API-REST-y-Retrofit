plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.velasquez.crud_con_api_rest_y_retrofit"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.velasquez.crud_con_api_rest_y_retrofit"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    //implementation de Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")

    //gson:
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}