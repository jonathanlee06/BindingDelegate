# BindingDelegate :pushpin:

<p>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://jitpack.io/#jonathanlee06/BindingDelegate"><img alt="Jitpack" src="https://jitpack.io/v/jonathanlee06/BindingDelegate.svg"/></a>
</p>

BindingDelegate is a simplify usage of Android View Binding built
by [Jonathan Lee](https://github.com/jonathanlee06)
utilising Kotlin Property Delegate. Initialise your view binding using just one line of code.

> Made with :heart: in Malaysia

## :pencil2: Getting Started

### 1. Add JitPack repository

Add the repository in your root `build.gradle` file under `repositories` section:

- Kotlin DSL

```kotlin
allprojects {
    repositories {
        ...
        maven(url = "https://jitpack.io")
    }
}
```

- Groovy

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add the library dependency

- Kotlin DSL

```kotlin
dependencies {
    implementation("com.github.jonathanlee06:BindingDelegate:1.0.2")
}
```

- Groovy

```gradle
dependencies {
    implementation 'com.github.jonathanlee06:BindingDelegate:1.0.2'
}
```

## :mag_right: Usage

### 1. Activity (with reflection) [See example](https://github.com/jonathanlee06/BindingDelegate/blob/master/app/src/main/java/com/jonathanlee/bindingdelegate/demo/MainActivity.kt)

<details>
    <summary>Click to expand</summary>

```kotlin
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.button.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java).also {
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
            startActivity(intent)
        }
    }
}
```

</details>
<br>

### 2. Activity (without reflection): Pass `::inflate` method reference [See example](https://github.com/jonathanlee06/BindingDelegate/blob/master/app/src/main/java/com/jonathanlee/bindingdelegate/demo/second/FragmentActivity.kt)

<details>
    <summary>Click to expand</summary>

```kotlin
class FragmentActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityFragmentBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
    }
}
```

</details>
<br>

### 3. Fragment (with reflection) [See example](https://github.com/jonathanlee06/BindingDelegate/blob/master/app/src/main/java/com/jonathanlee/bindingdelegate/demo/second/FirstFragment.kt)

<details>
    <summary>Click to expand</summary>

```kotlin
class FirstFragment : Fragment() {

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
```

</details>

<br>

### 4. Fragment (without reflection): Pass `::bind` method reference [See example](https://github.com/jonathanlee06/BindingDelegate/blob/master/app/src/main/java/com/jonathanlee/bindingdelegate/demo/second/SecondFragment.kt)

<details>
    <summary>Click to expand</summary>

```kotlin
class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
```

</details>
<br>

## :notebook: Note

### Proguard

If there is any problem with `Proguard`, add below to your `app/proguard-rules.pro`:

```
# BindingDelegate uses Reflection.
-keepclassmembers class ** implements androidx.viewbinding.ViewBinding {
    public static ** bind(android.view.View);
    public static ** inflate(android.view.LayoutInflater, android.view.ViewGroup, boolean);
    public static ** inflate(android.view.LayoutInflater, android.view.ViewGroup);
}
```

## :heart: See anything you like?

Support it by joining __[stargazers](https://github.com/jonathanlee06/BindingDelegate/stargazers)__
for this repository. :star:

## :octocat: Author

[Jonathan Lee](https://github.com/jonathanlee06)

## :bookmark_tabs: License

This project is licensed under the Apache License, Version 2.0 . See
the [LICENSE](https://github.com/jonathanlee06/Popcorn/blob/master/LICENSE) file for more info.

```xml
Designed and developed by 2022 Jonathan Lee

    Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, softwaredistributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.See the License for the specific language governing permissions andlimitations under the License.
```

