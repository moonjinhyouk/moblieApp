
# 안드로이드 버튼 레이아웃 예제

이 프로젝트는 하나의 버튼을 포함한 간단한 안드로이드 레이아웃 예제입니다. `LinearLayout`을 사용하여 버튼을 화면에 배치하며, 배경색을 지정하는 방법을 연습합니다.

## 구성

- **LinearLayout**: `LinearLayout`은 화면에 뷰들을 수직 또는 수평으로 배치하는 레이아웃입니다. 이번 예제에서는 `orientation="vertical"`로 설정하여 버튼을 세로로 배치합니다.
- **Button**: 버튼을 화면에 표시하고, 텍스트 "버튼"을 설정합니다.
- **배경색**: `android:background` 속성을 사용하여 배경색을 설정합니다. 이 예제에서는 배경색을 #48c34a로 설정했습니다.

## XML 코드

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#48c34a">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼"/>

</LinearLayout>

