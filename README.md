# SimpleTextInputLayout

Simple TextInputLayout views

## Download
```groovy
dependencies {
  implementation 'com.github.owenlejeune:simpletextinputlayout:1.0.0'
}
```

## Usage
```xml
<com.owenlejeune.simpletextinputlayout.SimpleTextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:errorTextColor="@color/error_text_color"
    app:hint="@string/hint_text"
    app:backgroundColor="@color/text_background_color"
    app:boxStrokeColor="@color/box_stroke_color"
    app:endIconTint="@color/end_icon_tint"
    app:hintTextColor="@color/hint_text_color"
    app:textColor="@color/text_color" />

<com.owenlejeune.simpletextinputlayout.textviews.EmailSimpleTextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>

<com.owenlejeune.simpletextinputlayout.textviews.NameSimpleTextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:type="first_name" />

<com.owenlejeune.simpletextinputlayout.textviews.PasswordSimpleTextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:passwordConfirmation="true" />

<com.owenlejeune.simpletextinputlayout.textviews.NumericSimpleTextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

## Releases

#### 1.0
* Initial release

## License
```
Copyright 2020 Owen LeJeune

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
