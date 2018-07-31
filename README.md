# CardListItem

[![](https://jitpack.io/v/sandisetiawan444/CardListItem.svg)](https://jitpack.io/#sandisetiawan444/CardListItem)

Custom list item with CardView

### Prerequisites

Add the dependencies to enable layout preview 

```
dependencies {
    implementation 'com.android.support:cardview-v7:27.1.1'
    implementation 'de.hdodenhof:circleimageview:2.2.0'
}
```

### Installing

Step 1. Add the JitPack repository in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.sandisetiawan444:CardListItem:1.0.0'
}
```

Include the CardListItem widget in your layout

```
<com.cardlistitem.cardlistitemlibrary.CardListItem
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginLeft="4dp"
    android:layout_marginRight="4dp"
    app:cardCornerRadius="10dp"
    app:cardUseCompatPadding="true"
    app:contentShortDescription="Short description"
    app:contentTitle="Title"
    app:headerTitle="Name"
    app:timestampt="1 hour ago" />
```
