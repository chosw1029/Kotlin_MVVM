# Kotlin_MVVM

Android Design Pattern 중 하나인 MVVM Pattern 을 적용한 예제입니다.

## 라이브러리
> Android Databinding   
> Android Navigation   
> RxJava2 + Retrofit2   
> Koin  
> Coroutine ( Flow )  
> Android LiveData  

## 업데이트 예정
> Android Navigation 심화 ( BackStack 관련 )   
> 비동기 처리 방식 변경 ( 기존 Rx 에서 Coroutine 으로 )   
> Room 예제 추가   
> 기존 ObservableField 에서 LiveData 이용으로

## 업데이트 내용

* 2020.07.28
> 일부 필요 없는 코드 제거  
> Coroutine Flow 적용  
> ExperimentalCoroutinesApi 관련 어노테이션 제거  

* 2020.06.25
> Gradle Version 변경  
> Base 클래스들( BaseViewModel, BaseActivity, BaseFragment, BaseRecyclerAdapter, BaseViewHolder) 의 구조적 변화로 인한 전체 코드 수정  
> 네트워크 라이브러리 변경 (~~Android Fast Networking~~ => Retrofit2)  
> Clean Architecture 적용 ( Google Architecture Sample 참조 )


블로그 <https://nextus.tistory.com/31>
