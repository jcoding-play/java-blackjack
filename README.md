## 기능 요구 사항

### 카드

- [x] 카드 종류는 4가지 (하트, 클로버, 스페이드, 다이아몬드)
- [x] 한 종류당 13장의 카드가 있다 (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
- [x] 카드 덱의 총 카드 수는 52장이다
- [x] 카드를 셔플한다
- [x] 맨 위의 카드를 한 장 선택한다

### 플레이어

- [x] 카드의 합을 계산한다
    - [x] A는 1 또는 11로 계산한다
    - [x] J, Q, K는 10으로 계산한다

- 이름
    - [x] 2자 이상 5자 이하의 이름을 가진다
    - [x] 이름은 중복될 수 없다
    - [ ] "딜러"라는 이름을 가질 수 없다 -> view

### 딜러

- [x] 카드 덱에서 카드를 한 장 뽑는다
- [x] 카드의 합을 계산한다
    - [x] A는 1 또는 11로 계산한다
    - [x] J, Q, K는 10으로 계산한다
- [x] 카드의 합이 16 이하이면 카드를 한 장 무조건 받아야 한다.
- [x] 카드의 합이 17 이상이면 카드를 더 받을 수 없다

- 이름
    - [x] "딜러"라는 이름을 가진다

- 정책 (두 카드 중 하나가 A일 때)
  A는 무조건 11로 한다.

1. 합이 17 이상이면 return
    - 21을 넘으면 bust
2. 16 이하면 하나 더 드로우
3. bust면 A를 1로 두고 점수 계산 -> 반복 1 or 2

### 점수

- [ ] bust 체크

### 게임

- [x] 게임 시작 전 모든 플레이어와 딜러는 카드를 2장씩 갖는다
    - 카드 돌리기 순서 : 딜러(뒤집힌 카드) -> 플레이어 1 ... n(보이는 카드) -> 딜러(보이는 카드) -> 플레이어 1 ... n(보이는 카드)
- [x] 플레이어에게 카드 한 장을 준다.
- [x] 각 플레이어별 승, 패 여부를 판단한다.
    - 딜러 승리
        - [x] 플레이어보다 카드의 합이 더 클 때 (21에 가깝다)
        - [x] 플레이어 21 초과 (버스트)
        - [x] 플레이어, 딜러 둘 다 21 초과 (버스트)
    - 플레이어 승리
        - [x] 딜러보다 카드의 합이 더 클 때 (21에 가깝다)
        - [x] 딜러 21 초과 (버스트)
    - 무승부
        - [x] 딜러와 플레이어의 합이 같을 때

### 게임 결과

- [x] 플레이어의 게임 결과로 딜러의 결과를 계산한다.

### 커맨드

- [ ] y, n의 값을 가진다
- [ ] 카드 추가 지급 여부를 판단한다

### 입력

- [ ] 게임 참가자 이름을 입력받는다
- [ ] 카드를 더 받을지 여부를 입력받는다
- [ ] **공통 예외 사항** 공백 포함, blank, null을 확인한다

### 컨버터

- [ ] 콤마로 구분된 문자열을 리스트로 변환한다

### 출력

- [ ] 2장씩 카드를 배분한 결과를 출력한다
- [ ] 딜러의 카드 중 한 장은 뒤집힌 상태로 출력한다
- [ ] 딜러의 카드 합이 16 이하일 때 카드를 한 장 더 받았는지 여부를 출력한다
- [ ] 카드 합 결과를 출력한다
- [ ] 승패 결과를 출력한다

### 체크 리스트

- [ ] indent는 1까지만 허용한다
- [ ] 3항 연산자를 쓰지 않는다
- [ ] else 예약어를 쓰지 않는다
- [ ] TDD로 구현하여 모든 기능에 대한 단위 테스트가 존재해야 한다
- [ ] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [ ] 배열 대신 컬렉션을 사용한다.
- [ ] 모든 원시 값과 문자열을 포장한다
- [ ] 일급 컬렉션을 쓴다.
- [ ] 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
