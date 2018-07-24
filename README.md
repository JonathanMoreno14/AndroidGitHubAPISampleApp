# AndroidGitHubAPI

The sample application uses **Volley** to parse JSON data from Github and display the content via **RecyclerView**

Displays the following:

**Name:**  repository name

**Description:** repository description

**Language:** programming language used

**Updated:** updated repository

### Updated repository

- API level
- Gradle
- Dependencies
- Design
- RecyclerView

| Before        | After         |
| ------------- |:-------------:|
| ![andriod_github_api_screencast](https://cloud.githubusercontent.com/assets/11635523/16028137/caebace6-31a1-11e6-96fe-7244874ebff3.gif)     | ![ezgif com-resize 19](https://user-images.githubusercontent.com/11635523/43167352-f3fb8d32-8f5e-11e8-8283-2403f2fa5713.gif) |




### Dependencies

```gradle

implementation 'com.github.bumptech.glide:glide:4.7.1'
annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'
implementation 'com.android.volley:volley:1.1.0'
implementation 'com.jakewharton:butterknife:8.8.1'
annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
implementation 'com.android.support:design:27.1.1'
implementation 'com.android.support:cardview-v7:27.1.1'
implementation 'com.android.support:recyclerview-v7:27.1.1'
implementation 'de.hdodenhof:circleimageview:2.2.0'

```

### Permissions

```xml

 <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

```

### Android Manifest
```xml

android:screenOrientation="portrait"

```

### Styles
```xml

<!-- Base application theme. -->
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    <!-- Customize your theme here. -->
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
</style>

<!--Details Activity-->
<style name="DetailsTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
    <item name="colorControlNormal">@android:color/white</item>
</style>

```

### Color
```xml

  <color name="colorPrimary">#444455</color>
  <color name="colorPrimaryDark">#222233</color>
  <color name="colorAccent">#FF4081</color>

  <!--Color Scheme Design-->
  <color name="backgroundColor">#777788</color>
  <color name="colorText">#778888</color>

```


### Github API
```url

https://api.github.com/users/username/repos

```

