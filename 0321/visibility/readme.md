
# 안드로이드 버튼 레이아웃 예제

이 프로젝트는 5개의 버튼을 포함하는 간단한 안드로이드 레이아웃 예제입니다. `LinearLayout`을 사용하여 버튼들을 세로로 배치하며, 두 번째 버튼은 **보이지 않게 설정**되어 있습니다. 이 예제는 `visibility` 속성을 사용하는 방법을 연습합니다.

## 구성

- **LinearLayout**: `LinearLayout`은 화면에 뷰들을 수직으로 배치하는 레이아웃입니다. `orientation="vertical"`로 설정하여 버튼들을 세로로 배치합니다.
- **Button 1**: "버튼1" 텍스트를 가진 첫 번째 버튼이 화면에 표시됩니다.
- **Button 2**: "버튼2" 텍스트를 가진 두 번째 버튼은 `android:visibility="invisible"` 속성으로 설정되어 **보이지 않지만, 레이아웃 공간을 차지**합니다.
- **Button 3, Button 4, Button 5**: "버튼3", "버튼4", "버튼5" 텍스트를 가진 세 번째, 네 번째, 다섯 번째 버튼이 화면에 표시됩니다.

## XML 코드

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼1"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:visibility="invisible"
        android:text="버튼2"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼3"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼4"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼5"/>

</LinearLayout>
