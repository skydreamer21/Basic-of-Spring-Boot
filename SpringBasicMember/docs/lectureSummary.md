# 10강
## `Optional`
- null 반환 가능성이 있을 때 null을 처리할 수 있는 객체
- null 반환 가능성이 있는 객체를 감싼다.

# 11강
- test code는 깊이있게 공부하자!
- test code 없이는 큰 규모의 프로젝트가 거의 불가능

## Annotation
- `@Test`
- `@AfterEach`

# 12강
- `Optional` 에서 바로 `.get()` 으로 꺼내는 것은 권장되지 않음
- `orElseGet()`, `ifPresent()` 등을 활용
- `Optional` 을 반환하는 게 좋지 않다 
  - Why??
- `join()` 의 직접적인 로직 말고 세부 기능의 로직은 함수로 뽑아주는 게 좋다.
- service는 좀더 Business 쪽 단어를 사용하여야 한다.
  - why? 기획자와 개발자간의 원활한 소통을 위해서 (가지는 이점 중 하나)