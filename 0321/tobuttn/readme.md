# 안드로이드 버튼 레이아웃 예제

이 프로젝트는 두 개의 버튼을 포함한 간단한 안드로이드 레이아웃 예제입니다. `LinearLayout`을 사용하여 버튼들을 세로로 배치합니다. 이 레이아웃은 `XML` 파일을 통해 정의되며, 각 버튼은 텍스트가 표시된 기본적인 형태입니다.

## 구성

- **LinearLayout**: 세로로 뷰들을 배치하는 레이아웃입니다. `orientation="vertical"` 속성을 사용하여 버튼들을 세로로 정렬합니다.
- **Button 1**: 첫 번째 버튼으로, "첫번째 버튼"이라는 텍스트가 표시됩니다.
- **Button 2**: 두 번째 버튼으로, "두번째 버튼"이라는 텍스트가 표시됩니다.

## XML 코드

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/main">

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="첫번째 버튼"/>

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="두번째 버튼"/>

</LinearLayout>

