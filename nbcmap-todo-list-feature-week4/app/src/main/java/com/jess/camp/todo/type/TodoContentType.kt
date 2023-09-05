package com.jess.camp.todo.type

enum class TodoContentType {

    //이넘 클래스 자체를 가지고온다
    //이넘 클래스의 네임이 스트링 값이다
    //이넘 클래스를 컨트롤 하는 법 . name/ordinal에 대한 컨트롤을 생각해볼 것
    //name 혹은 ordinal을 다시 esnum class로 바꾸기

    //액티비간의 intent에 번들 객체는 name/ordinal 둘 중 하나를 선택해서 주고 받음
    //받는 부분에서는 받아온 객체를 역으로 계산해서 이넘 클래스를 만듬 <정석
    //혹은 받은 형태로 활용하여 쓰기
    ADD, EDIT
}