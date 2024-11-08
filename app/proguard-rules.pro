# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.conscrypt.Conscrypt$Version
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.ConscryptHostnameVerifier
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE


-keepnames class * implements android.os.Parcelable {
  public static final ** CREATOR;
}


# Don't obfuscate class name of fragments
# it will help to debug or identify crashes in production build

##---------------Begin: proguard configuration for Retrofit  ----------
# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { <fields>; }

# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Prevent R8 from leaving Data object members always null
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

##---------------End: proguard configuration for Gson  ----------

-keepclassmembers enum * { *; }
-keep class **$$Parcelable { *; }

# The Maps API uses serialization.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
# The Maps API uses custom Parcelables.
# Use this rule (which is slightly broader than the standard recommended one)
# to avoid obfuscating them.
-keepclassmembers class * implements android.os.Parcelable {
    static *** CREATOR;
}

-keepattributes *Annotation*
-keepclassmembers class * {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# And if you use AsyncExecutor:
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

-keep class android.support.v4.app.Fragment { *; }
-keep class android.support.v4.app.FragmentPagerAdapter { *; }
-keep class android.support.v4.app.FragmentStatePagerAdapter { *; }
-keep class android.support.v4.view.ViewPager
-keep class android.support.v4.view.ViewPager$LayoutParams { *; }

-keep class android.support.v7.app.Fragment { *; }
-keep class android.support.v7.app.FragmentPagerAdapter { *; }
-keep class android.support.v7.app.FragmentStatePagerAdapter { *; }
-keep class android.support.v7.view.ViewPager
-keep class android.support.v7.view.ViewPager$LayoutParams { *; }

-keep class android.support.v7.widget.** { *; }

-keep class android.support.v13.app.FragmentPagerAdapter { *; }
-keep class android.support.v13.app.FragmentStatePagerAdapter { *; }

-keep class com.adobe.adms.measurement.ADMS_Measurement { *; }
-keep class com.adobe.mobile.Analytics { *; }
-keep class com.adobe.mobile.Config { *; }

-keep class com.amplitude.api.AmplitudeClient { *; }
-keep class com.amplitude.api.Revenue { *; }
-keep class com.amplitude.api.Identify { *; }

-keep class com.google.android.gms.analytics.Tracker { *; }
-keep class com.google.analytics.tracking.android.Tracker { *; }

-keep class com.google.firebase.analytics.FirebaseAnalytics { *; }
-keep class android.os.Bundle { *; }

-keep class com.crashlytics.** { *; }
-keep class com.flurry.android.FlurryAgent { *; }
-keep class com.localytics.android.Localytics { *; }
-keep class com.mixpanel.android.mpmetrics.MixpanelAPI { *; }
-keep class com.omniture.AppMeasurementBase { *; }
-keep class com.segment.analytics { *; }

-keep class ch.qos.** { *; }
-keep class org.slf4j.** { *; }
-keepattributes *Annotation*

-dontwarn ch.qos.logback.core.net.*

# sqlCipher
-keep,includedescriptorclasses class net.sqlcipher.** { *; }
-keep,includedescriptorclasses interface net.sqlcipher.** { *; }

# deobfuscate crash reports only for prod flavor
-keepattributes SourceFile,LineNumberTable        # Keep file names and line numbers.
-keep public class * extends java.lang.Exception  # Optional: Keep custom exceptions.

# Cloud Firestore
-keep class io.grpc.** {*;}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
# Banner library requirement
-keep class androidx.recyclerview.widget.**{*;}
-keep class androidx.viewpager2.widget.**{*;}


-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

 # R8 full mode strips generic signatures from return types if not kept.
-if interface * { @retrofit2.http.* public *** *(...); }
-keep,allowoptimization,allowshrinking,allowobfuscation class <3>

 # With R8 full mode generic signatures are stripped for classes that are not kept.
-keep,allowobfuscation,allowshrinking class retrofit2.Response

